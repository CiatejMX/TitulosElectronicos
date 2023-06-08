/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.dao;

import java.util.List;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.TituloDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crojo
 */
public interface TituloExtDAO extends CrudRepository<TituloDTO,Long> {
    
     @Query(nativeQuery = true, value = "select t.*,recibo.archivo, datorecibo.estatus, datorecibo.folio from titulo t left join historicoenvio envio 	on t.idhistoricoenvio = envio.idhistoricoenvio left join historicorecibo  recibo  on envio.idhistoricoenvio = recibo.idhistoricoenvio  left join datorecibo on datorecibo.idhistoricorecibo = recibo.Idhistoricorecibo" )
    public List<TituloDTO> listar();
    
}
