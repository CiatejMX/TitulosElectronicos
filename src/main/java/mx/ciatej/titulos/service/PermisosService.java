package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Permisos;


public interface PermisosService {

    public List<Permisos> listar();
    
    public void guardar(Permisos per);
    
    public void eliminar(Permisos per);
    
    public Permisos encontrar(Permisos per);
    
    
    
}
