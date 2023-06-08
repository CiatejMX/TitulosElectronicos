
package mx.ciatej.titulos.dao;


import java.util.List;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;
import mx.ciatej.titulos.domain.institucioncarrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface RolesDAO extends  CrudRepository<Roles,Long>{
    
     
    List<Roles>  findByIdusuario(long usr);
    
    Roles findByIdusuarioAndNombre(long usr, String name);
    
}
