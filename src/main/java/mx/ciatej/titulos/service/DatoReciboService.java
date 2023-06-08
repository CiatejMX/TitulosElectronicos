/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.DatoRecibo;

/**
 *
 * @author charlysama
 */
public interface DatoReciboService {
    
    public List<DatoRecibo> listar();
    
    public void guardar( DatoRecibo ef);
    
    public void eliminar( DatoRecibo ef);
    
    public  DatoRecibo encontrar( DatoRecibo ef);
    
    public DatoRecibo encontrarFolio ( String folio,String estatus);
    
}
