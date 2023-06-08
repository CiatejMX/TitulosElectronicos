
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.TipoEstudioAntecedente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface TipoEstudioAntecedenteDAO extends CrudRepository<TipoEstudioAntecedente,Long> {
    
     @Query("SELECT mt from TipoEstudioAntecedente mt where mt.id_tipo_estudio_antecedente = ?1")
    TipoEstudioAntecedente encuentraID(Long Id);
    
}
