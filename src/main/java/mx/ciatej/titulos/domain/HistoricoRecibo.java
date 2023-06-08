package mx.ciatej.titulos.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;



@Data
@Entity
@Table(name = "historicorecibo")
public class HistoricoRecibo implements Serializable {
    
    private static final long serialVersionUID = 1L; 
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Idhistoricorecibo;
    
    @OneToOne(fetch=FetchType.LAZY)
     @JoinColumn(name="idhistoricoenvio")
     @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
     private HistoricoEnvio historicoEnvio;
    //
    
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date datestamp;
    
    private String archivo;
    
    private String mensaje;
   
    public HistoricoRecibo() {
        datestamp = new Date();
    }
    
    
    
}
