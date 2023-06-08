/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.RolesDAO;
import mx.ciatej.titulos.domain.Roles;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImp implements  RolesService{
    @Autowired 
    private RolesDAO dao;
    
    @Override
    public List<Roles> listar() {
        return (List<Roles>)dao.findAll();
    }

    @Override
    public void guardar(Roles r) {
       dao.save(r);
    }

    @Override
    public void eliminar(Roles r) {
      dao.delete(r);
    }

    @Override
    public Roles encontrar(Roles r) {
      return dao.findById(r.getId() ).orElse(null);
    }
   @Override
   public List<Roles> listarroles( Long usr ){
       
       return dao.findByIdusuario(usr);
       
   }

    @Override
    public Roles encuentraUsuarioRol(Long id, String nombre) {
        return dao.findByIdusuarioAndNombre(id,nombre);
    }
    
}
