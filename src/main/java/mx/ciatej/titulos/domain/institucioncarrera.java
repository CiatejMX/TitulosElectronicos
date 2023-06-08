package mx.ciatej.titulos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "institucioncarrera")
public class institucioncarrera implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idinstitucioncarrera;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institucion_id")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private institucion institucion;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="cve_carrera")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private carrera carrera;
}
