 
package mx.ciatej.titulos.dao;


import mx.ciatej.titulos.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface UsuarioDAO extends JpaRepository<Usuario,Long>{
    
     @Query ("select u  from Usuario  u where user = ?1")
    public Usuario findByUsername(String username);
    
}
