/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.HistoricoEnvioDAO;
import mx.ciatej.titulos.domain.HistoricoEnvio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoricoEnvioServiceImp implements HistoricoEnvioService{
    
    @Autowired 
     private HistoricoEnvioDAO dao;
    

    @Override
    public List<HistoricoEnvio> listar() {
       return  (List<HistoricoEnvio>)dao.findAll();
    }

    @Override
    public void guardar(HistoricoEnvio ef) {
        dao.save(ef);
    }

    @Override
    public void eliminar(HistoricoEnvio ef) {
        dao.delete(ef);
    }

    @Override
    public HistoricoEnvio encontrar(HistoricoEnvio ef) {
       return dao.findById(ef.getIdhistoricoenvio()).orElse(null);
    }

    @Override
    public List<HistoricoEnvio> buscaCurp(String termino) {
        return dao.buscaCurp(termino);
    }

    @Override
    public List<HistoricoEnvio> buscaNombreCompleto(String termino) {
        return dao.buscaNombreCompleto(termino);
    }
    
}
