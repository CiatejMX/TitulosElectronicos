
package mx.ciatej.titulos.service;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.ciatej.titulos.dao.institucionDAO;
import mx.ciatej.titulos.dao.institucioncarreraDAO;
import mx.ciatej.titulos.domain.institucion;
import mx.ciatej.titulos.domain.institucioncarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class institucioncarrreraServiceImp implements institucioncarreraService{
    
    @Autowired
    private institucioncarreraDAO dao;
    
    @Autowired
    private institucionDAO institucionDao;
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<institucioncarrera> listar() {
         return (List<institucioncarrera>) dao.findAll();
    }

    @Override
    public void guardar(institucioncarrera ins) {
         dao.save(ins);
    }

    @Override
    public void eliminar(institucioncarrera ins) {
        dao.delete(ins);
    }

    @Override
    public institucioncarrera encontrar(institucioncarrera ins) {
        return dao.findById(ins.getIdinstitucioncarrera()).orElse(null);
    }

    @Override
    public List<institucion> institucionlistar( ) {
        return (List<institucion>) institucionDao.findAll();
    }
    
    @Override
    public institucion institucionActual (){
        return entityManager
                .createQuery("SELECT i FROM institucion i ORDER BY i.institucion_id desc" , institucion.class)
                .setMaxResults(1)
                .getSingleResult();
    }

    @Override
    public institucioncarrera encontrarIdCarrera(Long Id) {
        return dao.findByCarrera(Id);
    }
    
    
    
    
}
