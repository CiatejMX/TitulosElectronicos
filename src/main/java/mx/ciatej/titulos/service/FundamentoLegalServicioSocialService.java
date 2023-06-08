/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.FundamentoLegalServicioSocial;

/**
 *
 * @author crojo
 */
public interface FundamentoLegalServicioSocialService {
    
    public List<FundamentoLegalServicioSocial> listar();
    
    public void guardar(FundamentoLegalServicioSocial fl);
    
    public void eliminar(FundamentoLegalServicioSocial fl);
    
    public FundamentoLegalServicioSocial encontrar(FundamentoLegalServicioSocial fl);
    
    public FundamentoLegalServicioSocial encontrarId(Long Id);
    
}
