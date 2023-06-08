
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.AutorizacionReconocimiento;

public interface AutorizacionReconocimientoService {
    
    public List<AutorizacionReconocimiento> listar();
    
    public void guardar(AutorizacionReconocimiento ar);
    
    public void eliminar(AutorizacionReconocimiento ar);
    
    public AutorizacionReconocimiento encontrar(AutorizacionReconocimiento ar);
    
     public AutorizacionReconocimiento encontrarId(Long Id);
}
