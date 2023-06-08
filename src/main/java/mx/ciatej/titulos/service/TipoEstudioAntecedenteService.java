/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.TipoEstudioAntecedente;

/**
 *
 * @author crojo
 */
public interface TipoEstudioAntecedenteService {
    
    public List<TipoEstudioAntecedente> listar();
    
    public void guardar(TipoEstudioAntecedente TipoEstudio);
    
    public void eliminar(TipoEstudioAntecedente TipoEstudio);
    
    public TipoEstudioAntecedente encontrar(TipoEstudioAntecedente TipoEstudio);
    
     public TipoEstudioAntecedente encontrarId(Long Id);
    
    
}
