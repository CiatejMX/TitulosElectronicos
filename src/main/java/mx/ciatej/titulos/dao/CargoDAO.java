package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.Cargo;
import org.springframework.data.repository.CrudRepository;


public interface CargoDAO extends CrudRepository<Cargo,Long> {
    
}
