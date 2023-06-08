package mx.ciatej.titulos.dao;


import mx.ciatej.titulos.domain.entidadFederativa;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface entidadFederativaDAO extends CrudRepository<entidadFederativa, Long> {
    
    @Query("SELECT mt from entidadFederativa mt where mt.identidadfederativa = ?1")
    entidadFederativa encuentraID(Long Id);
    
}
