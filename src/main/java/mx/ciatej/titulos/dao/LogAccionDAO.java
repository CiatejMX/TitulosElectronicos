package mx.ciatej.titulos.dao;

import java.util.Date;
import java.util.List;
import mx.ciatej.titulos.domain.LogAccion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface LogAccionDAO  extends JpaRepository<LogAccion,Long> {
    
        //@Query("select t from Titulo t where t.nombre like %?1% and historicoenvio is null")
    @Query("select l from LogAccion l where l.timestamp between  ?1 and ?2")
    public List<LogAccion> findByTimestamp(Date f,Date f2);
    
    @Query("select l from LogAccion l where l.usuario like %?1%")
    public List<LogAccion> findByUsuario(String usr);
    
    @Query("select l from LogAccion l where l.url like %?1%")
    public List<LogAccion> findByUrl(String term);
    
    
}
