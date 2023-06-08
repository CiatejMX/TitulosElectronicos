package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "autorizacionreconocimiento")
public class AutorizacionReconocimiento implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_autorizacion_reconocimiento;
    @Column(name = "autorización_reconocimiento")
    private String autorizacion_reconocimiento;
    
    
    
}
