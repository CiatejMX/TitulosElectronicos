
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Responsable;



public interface ResponsableService {
    
    public List<Responsable> listar();
    
    public void guardar(Responsable re);
    
    public void eliminar(Responsable re);
    
    public Responsable encontrar(Responsable re);
    
}
