package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "modalidadtitulacion")
public class ModalidadTitulacion implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modalidad_titulación")
    private Long id_modalidad_titulacion;
    @Column(name = "modalidad_titulación")
    private String modalidad_titulacion;
    private String tipo_de_modalidad;
    
    
}
