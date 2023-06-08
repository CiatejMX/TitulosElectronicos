
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.carrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface carreraDAO extends CrudRepository<carrera,Long> {
    
     @Query("SELECT mt from carrera mt where mt.cve_carrera = ?1")
    carrera encuentraID(Long Id);
    
}
