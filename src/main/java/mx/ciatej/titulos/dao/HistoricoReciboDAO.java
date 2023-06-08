/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.dao;

import mx.ciatej.titulos.domain.HistoricoRecibo;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author charlysama
 */
public interface  HistoricoReciboDAO extends CrudRepository< HistoricoRecibo,Long> {
    
}
