
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.domain.ModalidadTitulacion;


public interface ModalidadTitulacionService {
    public List<ModalidadTitulacion> listar();
    
    public void guardar(ModalidadTitulacion mt);
    
    public void eliminar(ModalidadTitulacion mt);
    
    public ModalidadTitulacion encontrar(ModalidadTitulacion mt);
    
    public ModalidadTitulacion encontrarId (Long ID);
}
