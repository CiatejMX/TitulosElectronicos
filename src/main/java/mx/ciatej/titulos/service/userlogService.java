/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.ArrayList;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.dao.RolesDAO;
import mx.ciatej.titulos.dao.UsuarioDAO;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailService")
@Slf4j
public class userlogService implements UserDetailsService{
    
     @Autowired
     private UsuarioDAO dao;
     @Autowired
     private RolesDAO rolesdao;
    
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = dao.findByUsername(username);
       
       if (usuario == null ){
           throw new UsernameNotFoundException(username);
       }
       
       ArrayList<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
       
       for(Roles rol: rolesdao.findByIdusuario(usuario.getIdusuario())){
           roles.add( new SimpleGrantedAuthority( rol.getNombre() ) );
       }
       
       return new User(usuario.getUser(),usuario.getPassword(), roles);
    }
    
}
