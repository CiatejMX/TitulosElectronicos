
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.Titulo;

public interface TituloService {
    
    public List<Titulo> listar();
    
    public void guardar(Titulo tit);
    
    public void eliminar(Titulo tit);
    
    public Titulo encontrar(Titulo tit);
    
    public List<Titulo> buscaNombre(String termino);
    
    public List<Titulo> buscaCurp(String termino);
    
    public List<Titulo> buscaNombreCompleto(String termino);
    
}
