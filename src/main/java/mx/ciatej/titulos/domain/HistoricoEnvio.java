package mx.ciatej.titulos.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "historicoenvio")
public class HistoricoEnvio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idhistoricoenvio;
    private Long idusuario;
    //private Long idtitulo;
    private Date timestamp;
    private String accion;
    private String  mensaje;
    private Long lote;
    private Long idestaustitulo;
    private String archivo;
    
    @OneToMany(mappedBy="historicoenvio", fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    private List<Titulo> titulos;
    
    public  HistoricoEnvio(){
        this.titulos = new ArrayList<>();
    }
    
    public void addTitulo(Titulo t){
        this.titulos.add(t);
    }
    
}
