package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "motivocancelacion")
public class MotivoCancelacion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_motivo_can;
     @Column(name = "descripcion_cancelación")
    private String descripcion_cancelacion;
    private String idmotivo;
    
    
    
}
