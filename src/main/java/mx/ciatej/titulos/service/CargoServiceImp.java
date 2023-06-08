package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.CargoDAO;
import mx.ciatej.titulos.domain.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImp implements CargoService {
    
    @Autowired
    private CargoDAO dao;

    @Override
    public List<Cargo> listar() {
         return (List<Cargo>) dao.findAll();
    }

    @Override
    public void guardar(Cargo ef) {
            dao.save(ef);
    }

    @Override
    public void eliminar(Cargo ef) {
            dao.delete(ef);
    }

    @Override
    public Cargo encontrar(Cargo ef) {
        return dao.findById(ef.getId_cargo()).orElse(null);
    }
    
}
