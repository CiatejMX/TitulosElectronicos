
package mx.ciatej.titulos.service;

import java.util.List;

import mx.ciatej.titulos.domain.Responsable;
import mx.ciatej.titulos.dao.ResponsableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResponsableServiceImp implements ResponsableService {
       @Autowired
       private ResponsableDAO dao;

    @Override
    public List<Responsable> listar() {
         return (List<Responsable>) dao.findAll();
    }

    @Override
    public void guardar(Responsable re) {
        dao.save(re);
    }

    @Override
    public void eliminar(Responsable re) {
        dao.delete(re);
    }

    @Override
    public Responsable encontrar(Responsable re) {
        return dao.findById(re.getIdresponsable()).orElse(null);
    }
       
    
}
