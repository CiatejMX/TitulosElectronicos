package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tituloresponsable")
public class TituloResponsable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idtituloresponsable;
    private Long idtitulo;
    private Long idresponsable;
    
    
    
    
}
