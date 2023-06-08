/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "datorecibo")
public class DatoRecibo {
             @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long iddatorecibo;
  
            private Long idhistoricorecibo;
            private String archivo;
            private String estatus;
            private String folio;
            
            private String mensaje;
            
    
}
