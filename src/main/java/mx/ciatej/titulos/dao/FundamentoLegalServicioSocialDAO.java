
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.FundamentoLegalServicioSocial;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface FundamentoLegalServicioSocialDAO extends CrudRepository<FundamentoLegalServicioSocial,Long> {
    
     @Query("SELECT mt from FundamentoLegalServicioSocial mt where mt.id_fundamento_legal_servicio_social = ?1")
    FundamentoLegalServicioSocial encuentraID(Long Id);
    
}
