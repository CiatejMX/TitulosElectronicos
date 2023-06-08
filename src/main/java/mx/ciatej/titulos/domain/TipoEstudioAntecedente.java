package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tipoestudioantecedente")
public class TipoEstudioAntecedente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipo_estudio_antecedente;
    private String tipo_estudio_antecedente;
    private String tipo_educativo_del_antecedente;
    
}
