package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Cargo;

public interface CargoService {
    
    public List<Cargo> listar();
    
    public void guardar(Cargo ef);
    
    public void eliminar(Cargo ef);
    
    public Cargo encontrar(Cargo ef);
    
    
    
}
