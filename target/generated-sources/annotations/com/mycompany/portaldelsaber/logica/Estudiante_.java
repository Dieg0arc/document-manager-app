package com.mycompany.portaldelsaber.logica;

import com.mycompany.portaldelsaber.logica.Acudiente;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2025-03-21T21:42:48", comments="EclipseLink-2.7.12.v20230209-rNA")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile SingularAttribute<Estudiante, String> registro_civil;
    public static volatile SingularAttribute<Estudiante, String> grado;
    public static volatile SingularAttribute<Estudiante, Integer> id_Estudiante;
    public static volatile SingularAttribute<Estudiante, Acudiente> acudiente;
    public static volatile SingularAttribute<Estudiante, String> apellido;
    public static volatile SingularAttribute<Estudiante, String> nombre;
    public static volatile SingularAttribute<Estudiante, String> anio;

}