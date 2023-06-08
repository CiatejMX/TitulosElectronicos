
package mx.ciatej.titulos.domain;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;


@Data
@Entity
@Table(name = "logacciones")
public class LogAccion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ; 
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private Date timestamp;
    private String url;
    private String data;
    private String usuario;
    
            
       
    
}
