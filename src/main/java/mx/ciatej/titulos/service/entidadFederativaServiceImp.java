package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.entidadFederativaDAO;
import mx.ciatej.titulos.domain.entidadFederativa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class entidadFederativaServiceImp implements entidadFederativaService {
    
    @Autowired
    private entidadFederativaDAO efDAO;

    @Override
    public List<entidadFederativa> listarEF() {
         return (List<entidadFederativa>) efDAO.findAll();
    }

    @Override
    public void guardar(entidadFederativa ef) {
            efDAO.save(ef);
    }

    @Override
    public void eliminar(entidadFederativa ef) {
            efDAO.delete(ef);
    }

    @Override
    public entidadFederativa encontrarEF(entidadFederativa ef) {
        return efDAO.findById(ef.getIdentidadfederativa()).orElse(null);
    }

    @Override
    public entidadFederativa encontrarId(Long Id) {
        return efDAO.encuentraID(Id);
    }
    
}
