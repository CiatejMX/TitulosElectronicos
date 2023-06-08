/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.AutorizacionReconocimiento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author crojo
 */
public interface AutorizacionReconocimientoDAO extends CrudRepository<AutorizacionReconocimiento,Long> {
    
     @Query("SELECT mt from AutorizacionReconocimiento mt where mt.id_autorizacion_reconocimiento = ?1")
    AutorizacionReconocimiento encuentraID(Long Id);
}
