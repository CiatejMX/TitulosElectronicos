
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.AutorizacionReconocimientoDAO;
import mx.ciatej.titulos.domain.AutorizacionReconocimiento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorizacionReconocimientoServiceImp implements AutorizacionReconocimientoService  {
    
    @Autowired
    private AutorizacionReconocimientoDAO dao;

    @Override
    public List<AutorizacionReconocimiento> listar() {
        return (List<AutorizacionReconocimiento>) dao.findAll();
    }

    @Override
    public void guardar(AutorizacionReconocimiento ar) {
        dao.save(ar);
    }

    @Override
    public void eliminar(AutorizacionReconocimiento ar) {
        dao.delete(ar);
    }

    @Override
    public AutorizacionReconocimiento encontrar(AutorizacionReconocimiento ar) {
        return dao.findById(ar.getId_autorizacion_reconocimiento()).orElse(null);
    }

    @Override
    public AutorizacionReconocimiento encontrarId(Long Id) {
       return dao.encuentraID(Id);
    }
    
    
    
}
