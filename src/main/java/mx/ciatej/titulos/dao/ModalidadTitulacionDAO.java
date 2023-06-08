/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.ModalidadTitulacion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crojo
 */
public interface ModalidadTitulacionDAO extends CrudRepository<ModalidadTitulacion,Long> {
    
    
    //ModalidadTitulacion findById__modalidad__titulacion(Long id__modalidad__titulacion);
    
    @Query("SELECT mt from ModalidadTitulacion mt where mt.id_modalidad_titulacion = ?1")
    ModalidadTitulacion encuentraID(Long Id);
}
