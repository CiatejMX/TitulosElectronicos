/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.TipoEstudioAntecedenteDAO;
import mx.ciatej.titulos.domain.TipoEstudioAntecedente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author crojo
 */
@Service
public class TipoEstudioAntecedenteServiceImp implements TipoEstudioAntecedenteService {
    
    @Autowired
    private TipoEstudioAntecedenteDAO dao ;

    @Override
    public List<TipoEstudioAntecedente> listar() {
         return (List<TipoEstudioAntecedente>) dao.findAll();
    }

    @Override
    public void guardar(TipoEstudioAntecedente TipoEstudio) {
        dao.save(TipoEstudio);
    }

    @Override
    public void eliminar(TipoEstudioAntecedente TipoEstudio) {
        dao.delete(TipoEstudio);
    }

    @Override
    public TipoEstudioAntecedente encontrar(TipoEstudioAntecedente TipoEstudio) {
        return dao.findById(TipoEstudio.getId_tipo_estudio_antecedente()).orElse(null);
    }

    @Override
    public TipoEstudioAntecedente encontrarId(Long Id) {
        return dao.encuentraID(Id);
    }
    
}
