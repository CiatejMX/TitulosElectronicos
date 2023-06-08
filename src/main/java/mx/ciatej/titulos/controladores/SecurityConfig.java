package mx.ciatej.titulos.controladores;

import java.util.List;
import mx.ciatej.titulos.domain.Permisos;
import mx.ciatej.titulos.service.PermisosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserDetailsService userDetailService;
    
    @Autowired
    private PermisosService permisosSrv;
    
     @Value("${configuracion.tipoPermisos}")
        private String tipoPermisos;

            
    
   /* @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("admin")
                    .password("{noop}123")
                    .roles("ADMIN","USER")
                .and()
                .withUser("user")
                    .password("{noop}123")
                    .roles("USER")
                ;
    } */
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build)  throws Exception{
        build.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
                
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        
        if ( "db".equals(tipoPermisos) ){
           List<Permisos> lista =  permisosSrv.listar();
           
           for(Permisos rol: permisosSrv.listar() ){
                http.authorizeRequests()
                    .antMatchers(rol.getUrl() )
                    .hasAnyRole( rol.getRol() );
                   
            }
            
        
        }
        
        if ( "nodb".equals(tipoPermisos) ){
        
        
        http.authorizeRequests()
                .antMatchers(
                        "/catalogo/entidadfederativa/guardar", 
                        "/catalogo/cargo/guardar", 
                        "/catalogo/tipoestudioantecedente/guardar", 
                        "/catalogo/modalidadtitulacion/guardar",
                        "/catalogo/autorizacionreconocimiento/guardar",
                        "/catalogo/motivocancelacion/guardar",
                        "/catalogo/responsable/guardar",
                        
                        
                        "/catalogo/entidadfederativa/eliminar",
                        "/catalogo/cargo/eliminar",
                        "/catalogo/tipoestudioantecedente/eliminar",
                        "/catalogo/modalidadtitulacion/eliminar",
                        "/catalogo/autorizacionreconocimiento/eliminar",
                        "/catalogo/motivocancelacion/eliminar",
                        "/catalogo/responsable/eliminar",
                        
                        "/catalogo/responsable/editar/**",
                        "/catalogo/responsable/agregar",
                        "/titulo/historicoenvio/guardaritem",
                        "/titulo/historicoenvio/guardar",
                        "/titulo/historicoenvio/eliminar"
                        
                )
                    .hasRole("ADMIN")
                ;
        }
        
         http.authorizeRequests()
                 .antMatchers("/panel","/")
                    .hasAnyRole("USER","ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login")
                .and()
                    .exceptionHandling().accessDeniedPage("/403");
    }
}
