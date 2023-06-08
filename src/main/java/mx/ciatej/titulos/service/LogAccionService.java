/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import mx.ciatej.titulos.domain.LogAccion;


public interface LogAccionService  {
    public List<LogAccion> listar();
    

    
    public void guardar(LogAccion ef);
    
    public void eliminar(LogAccion ef);
    
    public  List<LogAccion> buscarFecha(  LocalDate f, LocalDate f2);
    
    public  List<LogAccion> buscarUsuario(String usr);
    
    public  List<LogAccion> buscarUrl(String url);
    
  public void log ( String url, String accion) ;
    
    
    
    
}
