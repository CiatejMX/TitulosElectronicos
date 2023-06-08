package mx.ciatej.titulos.domain;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "fundamentolegalserviciosocial")
public class FundamentoLegalServicioSocial implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_fundamento_legal_servicio_social;
    private String fundamento_legal_servicio_social;
    
    
}
