
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.HistoricoEnvio;


public interface HistoricoEnvioService {
    
    public List<HistoricoEnvio> listar();
    
    public void guardar(HistoricoEnvio ef);
    
    public void eliminar(HistoricoEnvio ef);
    
    public HistoricoEnvio encontrar(HistoricoEnvio ef);
    
    public List<HistoricoEnvio> buscaCurp(String termino);
    
    public List<HistoricoEnvio> buscaNombreCompleto(String termino);
    
}
