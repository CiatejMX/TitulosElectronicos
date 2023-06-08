package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.MotivoCancelacion;



public interface MotivoCancelacionService {
    
     public List<MotivoCancelacion> listar();
    
    public void guardar(MotivoCancelacion mc);
    
    public void eliminar(MotivoCancelacion mc);
    
    public MotivoCancelacion encontrar(MotivoCancelacion mc);
    
}
