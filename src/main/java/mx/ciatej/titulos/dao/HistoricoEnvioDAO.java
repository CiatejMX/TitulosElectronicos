
package mx.ciatej.titulos.dao;

import java.util.List;
import mx.ciatej.titulos.domain.HistoricoEnvio;
import mx.ciatej.titulos.domain.Titulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface HistoricoEnvioDAO extends CrudRepository<HistoricoEnvio,Long> {
    
    
    @Query(value = "select h.* from historicoenvio h  inner join titulo t on t.idhistoricoenvio = h.idhistoricoenvio "
            + "where CONCAT( t.nombre,' ',t.primerapellido,' ',t.segundoapellido) like %:ter% "
            , nativeQuery = true)
    public List<HistoricoEnvio> buscaNombreCompleto(@Param("ter") String termino);
    
        @Query(value = "select h.* from historicoenvio h  inner join titulo t on t.idhistoricoenvio = h.idhistoricoenvio "
            + "where t.curp like %:ter% "
            , nativeQuery = true)
    public List<HistoricoEnvio> buscaCurp(@Param("ter") String termino);
   
    
}
