package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.entidadFederativa;

public interface entidadFederativaService {
    
    public List<entidadFederativa> listarEF();
    
    public void guardar(entidadFederativa ef);
    
    public void eliminar(entidadFederativa ef);
    
    public entidadFederativa encontrarEF(entidadFederativa ef);
    
    public entidadFederativa encontrarId(Long Id);
    
    
}
