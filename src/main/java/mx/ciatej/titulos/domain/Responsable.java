package mx.ciatej.titulos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "responsable")
public class Responsable implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idresponsable;
    private String nombre;
    private String primerapellido;
    private String segundoapellido;
    private String curp;
    //private Long idcargo;
    private String abrtitulo;
    private String certificadoresponsable;
    private String llaveesponsable;
    private String numerocertificado;
    private String pwdkey;
    
     @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="idcargo")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Cargo cargo; 
    
    
    
    
}
