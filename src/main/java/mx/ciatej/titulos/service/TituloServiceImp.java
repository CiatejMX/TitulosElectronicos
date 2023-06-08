package mx.ciatej.titulos.service;

import java.util.List;
import mx.ciatej.titulos.dao.TituloDAO;
import mx.ciatej.titulos.domain.Titulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TituloServiceImp implements TituloService {
    
     @Autowired
    private TituloDAO dao;

    @Override
    public List<Titulo> listar() {
         return (List<Titulo>) dao.findAll();
    }

    @Override
    public void guardar(Titulo tit) {
        dao.save(tit);
    }

    @Override
    public void eliminar(Titulo tit) {
        dao.delete(tit);
    }

    @Override
    public Titulo encontrar(Titulo tit) {
        return dao.findById(tit.getIdtitulo()).orElse(null);
    }

    @Override
    public List<Titulo> buscaNombre(String termino) {
        return  dao.buscaNombre(termino);
    }

    @Override
    public List<Titulo> buscaCurp(String termino) {
         return  dao.buscaCurp(termino);
    }

    @Override
    public List<Titulo> buscaNombreCompleto(String termino) {
        return  dao.buscaNombreCompleto(termino);
    }
    
    
    
}
