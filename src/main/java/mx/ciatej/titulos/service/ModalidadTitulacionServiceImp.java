
package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.ModalidadTitulacionDAO;
import mx.ciatej.titulos.domain.ModalidadTitulacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ModalidadTitulacionServiceImp implements ModalidadTitulacionService{
    @Autowired
    private ModalidadTitulacionDAO dao;

    @Override
    public List<ModalidadTitulacion> listar() {
        return (List<ModalidadTitulacion>) dao.findAll();
    }

    @Override
    public void guardar(ModalidadTitulacion mt) {
       dao.save(mt);
    }

    @Override
    public void eliminar(ModalidadTitulacion mt) {
        dao.delete(mt);
    }

    @Override
    public ModalidadTitulacion encontrar(ModalidadTitulacion mt) {
         return dao.findById(mt.getId_modalidad_titulacion()).orElse(null);
    }

    @Override
    public ModalidadTitulacion encontrarId(Long ID) {
       
        
        return dao.encuentraID(ID);
    }
    
    
}
