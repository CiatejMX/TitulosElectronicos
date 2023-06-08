
package mx.ciatej.titulos.dao;

import java.util.List;
import mx.ciatej.titulos.domain.Titulo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TituloDAO extends CrudRepository<Titulo,Long>{
    
    @Query("select t from Titulo t where t.nombre like %?1% and historicoenvio is null")
    public List<Titulo> buscaNombre(String termino);
    
    @Query("select t from Titulo t where t.curp like %?1% ")
    public List<Titulo> buscaCurp(String termino);
    
    @Query("select t from Titulo t where CONCAT( t.nombre,' ',t.primerapellido,' ',t.segundoapellido) like %?1% ")
    public List<Titulo> buscaNombreCompleto(String termino);
    
}
