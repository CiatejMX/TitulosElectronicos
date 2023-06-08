
package mx.ciatej.titulos.service;

import java.util.ArrayList;
import java.util.List;
import mx.ciatej.titulos.dao.RolesDAO;
import mx.ciatej.titulos.dao.UsuarioDAO;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImp implements UsuarioService {
    
     @Autowired
    private UsuarioDAO dao;


    public List<Usuario> listar() {
         return (List<Usuario>) dao.findAll();
    }

    @Override
    public void guardar(Usuario u) {
        dao.save(u);
    }

    @Override
    public void eliminar(Usuario u) {
        dao.delete(u);
    }

    @Override
    public Usuario encontrar(Usuario u) {
        return dao.findById(u.getIdusuario()).orElse(null);
    }

    @Override
    public Usuario encontrarID(String nombre) {
        return dao.findByUsername(nombre);
    }

    

  
    
    
}
