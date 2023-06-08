
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.DatoRecibo;
import org.springframework.data.repository.CrudRepository;


public interface DatoReciboDAO extends CrudRepository<DatoRecibo,Long>{
    
    public DatoRecibo findByFolioAndEstatus(String folio,String estatus); 
    
}
