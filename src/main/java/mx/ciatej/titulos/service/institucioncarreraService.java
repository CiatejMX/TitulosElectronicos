/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import java.util.Optional;
import mx.ciatej.titulos.domain.institucion;
import mx.ciatej.titulos.domain.institucioncarrera;

/**
 *
 * @author carlysama
 */
public interface institucioncarreraService {
    
     public List<institucioncarrera> listar();
    
    public void guardar(institucioncarrera ins);
    
    public void eliminar(institucioncarrera ins);
    
    public institucioncarrera encontrar(institucioncarrera ins);
    
    public institucioncarrera encontrarIdCarrera(Long Id);
    
    public List<institucion>  institucionlistar();
    
     public institucion institucionActual ();
    
    
}
