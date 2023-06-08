/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.dao;

import java.util.List;
import mx.ciatej.titulos.domain.FirmasTitulo;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crojo
 */
public interface FirmasTituloDAO extends CrudRepository<FirmasTitulo,Long>{
    
    // @Query("select t from FirmasTitulo t where t.idtitulo = ?1 ")
    // public List<FirmasTitulo> buscarFirmasTitulo(Long idtitulo);
    
    FirmasTitulo findByTituloAndUsuario(Titulo titulo, Usuario usuario );
    
}
