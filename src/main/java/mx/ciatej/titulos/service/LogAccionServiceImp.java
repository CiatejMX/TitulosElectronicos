/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import mx.ciatej.titulos.dao.LogAccionDAO;
import mx.ciatej.titulos.domain.LogAccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class LogAccionServiceImp implements LogAccionService {
    
    
    @Autowired
    private LogAccionDAO dao;
    @Override
    public List<LogAccion> listar() {
       return dao.findAll();
    }

    @Override
    public void guardar(LogAccion ef) {
        dao.save(ef);
    }

    @Override
    public void eliminar(LogAccion ef) {
        dao.delete(ef);
    }

    @Override
    public List<LogAccion> buscarFecha(LocalDate f,LocalDate f2) {
        ZoneId zona = ZoneId.systemDefault();
            Date fecha = Date.from(f.atStartOfDay(zona).toInstant());
            Date fecha2 = Date.from(f2.atStartOfDay(zona).toInstant());
        return dao.findByTimestamp( fecha,fecha2 );
    }

    @Override
    public List<LogAccion> buscarUsuario(String usr) {
        return dao.findByUsuario(usr);
    }

    @Override
    public List<LogAccion> buscarUrl(String url) {
        return dao.findByUrl(url);
    }
    
    @Override    
    public void log ( String url, String accion) {
               
                Authentication user = SecurityContextHolder.getContext().getAuthentication();
        
        LogAccion l = new LogAccion();
        l.setTimestamp(new Date());
        l.setUsuario(user.getName()+user.getAuthorities().toString());
        l.setData(accion);
        l.setUrl(url);
        
        dao.save(l);
           } 
    
}
