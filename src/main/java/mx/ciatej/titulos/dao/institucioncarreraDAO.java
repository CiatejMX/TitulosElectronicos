
package mx.ciatej.titulos.dao;



import mx.ciatej.titulos.domain.institucioncarrera;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface institucioncarreraDAO extends CrudRepository<institucioncarrera,Long>{
    
    @Query ("select c  from institucioncarrera  c where cve_carrera = ?1")
    institucioncarrera findByCarrera(Long cveCarrera);
    
    @Query ("select max(institucion_id) from institucion i  ")
    Long ultimoIdinstitucion();
    
    
}
