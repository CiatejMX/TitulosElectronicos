
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    
    public List<Usuario> listar();
    
    public void guardar(Usuario c);
    
    public void eliminar(Usuario c);
    
    public Usuario encontrar(Usuario c);

    public Usuario encontrarID (String nombre);
}
