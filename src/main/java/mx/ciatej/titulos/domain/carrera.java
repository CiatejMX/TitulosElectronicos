package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "carrera")
public class carrera implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private Long cve_carrera;
    private String nombre_carrera;
    private String nivel_educativo;
    private Long rvoe_dgp;
    private String tipo_rvoe;
    private Long id_entidad_federativa_rvoe;
    private String sostenimiento;
    
    
    
    
    
}
