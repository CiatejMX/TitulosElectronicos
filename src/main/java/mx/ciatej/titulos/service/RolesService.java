
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;

public interface RolesService {
    
    
    public List<Roles> listar();
     
    public List<Roles> listarroles(Long usr);
    
    public void guardar(Roles r);
    
    public void eliminar(Roles r);
    
    public Roles encontrar(Roles r);
    
    public Roles encuentraUsuarioRol(Long id,String nombre);
}
