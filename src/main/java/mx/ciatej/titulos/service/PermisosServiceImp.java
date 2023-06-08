
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.PermisosDAO;
import mx.ciatej.titulos.domain.Permisos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PermisosServiceImp  implements PermisosService{
    
    @Autowired
    private PermisosDAO dao;
    
    
    @Override
    public List<Permisos> listar() {
       return  dao.findAll();
    }

    @Override
    public void guardar(Permisos per) {
      dao.save(per);
    }

    @Override
    public void eliminar(Permisos per) {
      dao.delete(per);
    }

    @Override
    public Permisos encontrar(Permisos per) {
      return dao.findById( per.getId()).orElse(null);
    }
    
}
