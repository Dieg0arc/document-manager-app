package com.mycompany.portaldelsaber.logica;

import com.mycompany.portaldelsaber.logica.Estudiante;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-18T14:56:13", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Acudiente.class)
public class Acudiente_ { 

    public static volatile SingularAttribute<Acudiente, Integer> id_Acudiente;
    public static volatile SingularAttribute<Acudiente, String> cedula;
    public static volatile SingularAttribute<Acudiente, String> apellido;
    public static volatile ListAttribute<Acudiente, Estudiante> estudiantes;
    public static volatile SingularAttribute<Acudiente, String> telefono;
    public static volatile SingularAttribute<Acudiente, String> nombre;

}