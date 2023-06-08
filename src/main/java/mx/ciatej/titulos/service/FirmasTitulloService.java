/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.FirmasTitulo;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.Usuario;

/**
 *
 * @author crojo
 */
public interface FirmasTitulloService {
    
    public List<FirmasTitulo> listar();
    
    public void guardar( FirmasTitulo ft);
    
    public void eliminar( FirmasTitulo ft);
    
    public FirmasTitulo encontrar( FirmasTitulo ft );
    
    public List<FirmasTitulo> encontrarFirmas ( Long id );
    
    public FirmasTitulo encontrarUsuarioTitulo(Titulo titulo, Usuario usuario);
    
    
}
