/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.controladores;

import java.util.List;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;
import mx.ciatej.titulos.service.LogAccionService;
import mx.ciatej.titulos.service.RolesService;
import mx.ciatej.titulos.service.UsuarioService;
import mx.ciatej.titulos.ws.Utileria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UsuarioController {
    
        //----------------------------------------------------
     @Autowired
    private UsuarioService  usuarioSrv;
      @Autowired
    private RolesService  rolesSrv;
    
    
      @GetMapping("/catalogo/usuario")
    public String usuario(Model model , @AuthenticationPrincipal User user ){
       
        List<Usuario> usuarios = usuarioSrv.listar();
        Usuario usuarioNew = new Usuario();
        model.addAttribute("Usuarios", usuarios);
        model.addAttribute("UsuarioNew", usuarioNew);
        model.addAttribute("user", user);
       return "Catalogo/usuario";  
    }
    @Autowired
    private LogAccionService loga;
     @PostMapping("/catalogo/usuario/guardar")
    public String usuarioGuardar(@Valid Usuario usr, Errors errores){
        if(errores.hasErrors()){
            return "modificar";
        }
        Usuario usrold = null;
       if ( usr.getIdusuario() != null ) {
             usrold = usuarioSrv.encontrar(usr);
       }
       
       
       if (usr.getPassword().equals("")  ){
                
                usr.setPassword( usrold.getPassword() ) ;
       }     
       else{
              usr.setPassword(Utileria.encripta(usr.getPassword()));
       }
        loga.log("/catalogo/usuario/guardar",usr.toString() );
       usuarioSrv.guardar( usr);
        return "redirect:/catalogo/usuario/";
    }
    
     @GetMapping("/catalogo/usuario/eliminar/{idusuario}")
    public String usuarioEliminar(Usuario usuario){
         loga.log("/catalogo/usuario/eliminar/",usuario.toString() );
        usuarioSrv.eliminar(usuario);
        return "redirect:/catalogo/usuario/";
    }
    
    @GetMapping("/catalogo/usuario/editar/{idusuario}")
    public String usuarioEditar(Usuario usuario, Model model){
        Usuario usr = usuarioSrv.encontrar(usuario);
        
        List<Roles> roles = rolesSrv.listarroles(usr.getIdusuario());
        model.addAttribute("Roles", roles);
        
        model.addAttribute("Usuario", usr);
        return "Catalogo/usuarioedit";
    }
    
     @GetMapping("/catalogo/usuario/agregar")
    public String usuarioAgregar(Usuario usuario, Model model){
        
        List<Roles> roles = rolesSrv.listar();
        model.addAttribute("Roles", roles);
        
        usuario = new Usuario();
        model.addAttribute("Usuario", usuario);
        
         Roles  rol = new Roles();
        model.addAttribute("newrole", rol);
        
        return "Catalogo/usuarioedit";
    }
    
     @PostMapping("/catalogo/roles/guardar/")
    public String rolAgregar(Roles rol, Model model){
         loga.log("/catalogo/roles/guardar/",rol.toString() );       
        rolesSrv.guardar(rol);
        
        List<Roles> roles = rolesSrv.listar();
        model.addAttribute("Roles", roles);
        
        Usuario usuario = new Usuario();
        usuario.setIdusuario(rol.getIdusuario());
        usuario =usuarioSrv.encontrar(usuario);
        model.addAttribute("Usuario", usuario);
                
        Roles  newrol = new Roles();
        model.addAttribute("newrole", newrol);
        
        model.addAttribute("Roles", roles);
    
       return "redirect:/catalogo/usuario/editar/"+usuario.getIdusuario().toString();
    }
    
     @GetMapping("/catalogo/roles/eliminar")
    public String roleliminar(Roles rol, Model model){
         loga.log("/catalogo/roles/eliminar/",rol.toString() );     
        rol = rolesSrv.encontrar(rol);
        
        rolesSrv.eliminar(rol);
        
        List<Roles> roles = rolesSrv.listar();
        model.addAttribute("Roles", roles);
        
        Usuario usuario = new Usuario();
        usuario.setIdusuario(rol.getIdusuario());
        usuario =usuarioSrv.encontrar(usuario);
        model.addAttribute("Usuario", usuario);
                
        Roles  newrol = new Roles();
        model.addAttribute("newrole", newrol);
        
        model.addAttribute("Roles", roles);
    
     return "redirect:/catalogo/usuario/editar/"+usuario.getIdusuario().toString();
    }
    
}
