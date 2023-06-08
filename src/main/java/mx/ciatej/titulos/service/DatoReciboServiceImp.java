
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.DatoReciboDAO;
import mx.ciatej.titulos.domain.DatoRecibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DatoReciboServiceImp   implements DatoReciboService {
    
    @Autowired
    private DatoReciboDAO dao;

    @Override
    public List<DatoRecibo> listar() {
        return (List<DatoRecibo>)dao.findAll();
    }

    @Override
    public void guardar(DatoRecibo ef) {
        dao.save(ef);
    }

    @Override
    public void eliminar(DatoRecibo ef) {
        dao.delete(ef);
    }

    @Override
    public DatoRecibo encontrar(DatoRecibo ef) {
        return  dao.findById(ef.getIddatorecibo()).orElse(null);
    }

    @Override
    public DatoRecibo encontrarFolio(String folio,String estatus) {
        return dao.findByFolioAndEstatus(folio,estatus);
    }
    
}
