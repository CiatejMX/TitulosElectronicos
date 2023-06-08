
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.MotivoCancelacionDAO;
import mx.ciatej.titulos.domain.MotivoCancelacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotivoCancelacionServiceImp implements MotivoCancelacionService {
    
    @Autowired
    private MotivoCancelacionDAO dao;

    @Override
    public List<MotivoCancelacion> listar() {
         return (List<MotivoCancelacion>) dao.findAll();
    }

    @Override
    public void guardar(MotivoCancelacion mc) {
        dao.save(mc);
     }

    @Override
    public void eliminar(MotivoCancelacion mc) {
        dao.delete(mc);
    }

    @Override
    public MotivoCancelacion encontrar(MotivoCancelacion mc) {
        return dao.findById(mc.getId_motivo_can()).orElse(null);
    }
    
}
