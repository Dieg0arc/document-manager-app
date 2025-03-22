package com.mycompany.portaldelsaber.persistencia;

import com.mycompany.portaldelsaber.logica.Acudiente;
import com.mycompany.portaldelsaber.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.portaldelsaber.persistencia.exceptions.PreexistingEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class AcudienteJpaController implements Serializable {

    private EntityManagerFactory emf = null;

    public AcudienteJpaController() {
       emf = Persistence.createEntityManagerFactory("PortalSaberPU");
    }
    
    public AcudienteJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
        
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Acudiente acudiente) throws PreexistingEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(acudiente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAcudiente(acudiente.getCedulaAcuediente()) != null) {
                throw new PreexistingEntityException("Acudiente " + acudiente.getCedulaAcuediente() + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Acudiente acudiente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            acudiente = em.merge(acudiente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = acudiente.getCedulaAcuediente();
                if (findAcudiente(id) == null) {
                    throw new NonexistentEntityException("El acudiente con cédula " + id + " ya no existe.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Acudiente acudiente;
            try {
                acudiente = em.getReference(Acudiente.class, id);
                acudiente.getCedulaAcuediente();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("El acudiente con cédula " + id + " ya no existe.", enfe);
            }
            em.remove(acudiente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Acudiente> findAcudienteEntities() {
        return findAcudienteEntities(true, -1, -1);
    }

    public List<Acudiente> findAcudienteEntities(int maxResults, int firstResult) {
        return findAcudienteEntities(false, maxResults, firstResult);
    }

    private List<Acudiente> findAcudienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Acudiente.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Acudiente findAcudiente(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Acudiente.class, id);
        } finally {
            em.close();
        }
    }

    public int getAcudienteCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Acudiente> rt = cq.from(Acudiente.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}