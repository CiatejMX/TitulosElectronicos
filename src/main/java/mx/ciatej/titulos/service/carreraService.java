
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.carrera;


public interface carreraService {
    
     public List<carrera> listar();
    
    public void guardar(carrera c);
    
    public void eliminar(carrera c);
    
    public carrera encontrar(carrera c);
    
    public carrera encontrarId(Long Id);
    
}
