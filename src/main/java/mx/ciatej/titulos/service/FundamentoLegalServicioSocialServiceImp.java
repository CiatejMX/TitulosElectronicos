/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.FundamentoLegalServicioSocialDAO;
import mx.ciatej.titulos.domain.FundamentoLegalServicioSocial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FundamentoLegalServicioSocialServiceImp implements FundamentoLegalServicioSocialService {
    
    @Autowired
    private FundamentoLegalServicioSocialDAO dao; 

    @Override
    public List<FundamentoLegalServicioSocial> listar() {
         return (List<FundamentoLegalServicioSocial>) dao.findAll();
    }

    @Override
    public void guardar(FundamentoLegalServicioSocial fl) {
        dao.save(fl);
    }

    @Override
    public void eliminar(FundamentoLegalServicioSocial fl) {
        dao.delete(fl);
    }

    @Override
    public FundamentoLegalServicioSocial encontrar(FundamentoLegalServicioSocial fl) {
        return dao.findById(fl.getId_fundamento_legal_servicio_social()).orElse(null);
    }

    @Override
    public FundamentoLegalServicioSocial encontrarId(Long Id) {
        return dao.encuentraID(Id);
    }
    
}
