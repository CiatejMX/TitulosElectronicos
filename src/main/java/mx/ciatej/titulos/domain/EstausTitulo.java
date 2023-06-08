package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "estaustitulo")
public class EstausTitulo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idestaustitulo;
    private String descripcion;
    
    
    
    
}
