
package mx.ciatej.titulos.service;

import java.util.List;
import java.util.Optional;
import mx.ciatej.titulos.dao.carreraDAO;
import mx.ciatej.titulos.dao.institucionDAO;
import mx.ciatej.titulos.dao.institucioncarreraDAO;
import mx.ciatej.titulos.domain.carrera;
import mx.ciatej.titulos.domain.institucion;
import mx.ciatej.titulos.domain.institucioncarrera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class carreraServiceImp implements carreraService {
    
    @Autowired
    private carreraDAO dao;
    
    @Autowired
    private institucioncarreraDAO daoic;
    
    @Autowired
    private institucionDAO daoi; 
    

    @Override
    public List<carrera> listar() {
         return (List<carrera>) dao.findAll();
    }

    @Override
    public void guardar(carrera c) {
        dao.save(c);
        
        institucioncarrera ic = daoic.findByCarrera(c.getCve_carrera());
            
        if( ic == null ){
            ic = new institucioncarrera();
            Optional<institucion> i = daoi.findById( daoic.ultimoIdinstitucion() );
             ic.setInstitucion(i.get());
             ic.setCarrera(c);
        }
        
        
        daoic.save(ic);
        
    }

    @Override
    public void eliminar(carrera c) {
        dao.delete(c);
        institucioncarrera ic = daoic.findByCarrera(c.getCve_carrera());
                    
        if( ic != null ){
            daoic.delete(ic);
        }
        
          
        
    }

    @Override
    public carrera encontrar(carrera c) {
         return dao.findById(c.getCve_carrera()).orElse(null); 
    }

    @Override
    public carrera encontrarId(Long Id) {
        return dao.encuentraID(Id);
    }
    
}
