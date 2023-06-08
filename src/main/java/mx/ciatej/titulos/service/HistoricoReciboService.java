
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.HistoricoRecibo;


public interface HistoricoReciboService {
    
     public List<HistoricoRecibo> listar();
    
    public void guardar(HistoricoRecibo ef);
    
    public void eliminar(HistoricoRecibo ef);
    
    public HistoricoRecibo encontrar(HistoricoRecibo ef);
    
}
