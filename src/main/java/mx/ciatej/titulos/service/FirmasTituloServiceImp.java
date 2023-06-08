/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.FirmasTituloDAO;
import mx.ciatej.titulos.domain.FirmasTitulo;
import mx.ciatej.titulos.domain.Titulo;
import mx.ciatej.titulos.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crojo
 */
@Service
public class FirmasTituloServiceImp implements FirmasTitulloService {
    
    @Autowired
    private FirmasTituloDAO dao;

    @Override
    public List<FirmasTitulo> listar() {
        return (List<FirmasTitulo>) dao.findAll();
    }

    @Override
    public void guardar(FirmasTitulo ft) {
        dao.save(ft);
    }

    @Override
    public void eliminar(FirmasTitulo ft) {
        dao.delete(ft);
    }

    @Override
    public FirmasTitulo encontrar(FirmasTitulo ft) {
        return dao.findById(ft.getIdfirmatitulo()).orElse(null);
    }

    @Override
    public List<FirmasTitulo> encontrarFirmas(Long id) {
        //return (List<FirmasTitulo>) dao.buscarFirmasTitulo(id);
        return null;
    }

    @Override
    public FirmasTitulo encontrarUsuarioTitulo(Titulo titulo, Usuario usuario) {
       return dao.findByTituloAndUsuario(titulo, usuario);
    }

      
    
    
}
