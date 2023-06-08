
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.HistoricoReciboDAO;
import mx.ciatej.titulos.domain.HistoricoRecibo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service 
public class HistoricoReciboServiceImp implements HistoricoReciboService{
    
    @Autowired
    private HistoricoReciboDAO dao;

    @Override
    public List<HistoricoRecibo> listar() {
        return (List<HistoricoRecibo>)dao.findAll();
    }

    @Override
    public void guardar(HistoricoRecibo ef) {
        dao.save(ef);
        
    }

    @Override
    public void eliminar(HistoricoRecibo ef) {
       dao.delete(ef);
    }

    @Override
    public HistoricoRecibo encontrar(HistoricoRecibo ef) {
        return dao.findById(ef.getIdhistoricorecibo()).orElse(null);
    }
    
}
