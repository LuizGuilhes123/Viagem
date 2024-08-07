package service;

import model.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DestinoRepository;

import java.util.List;

@Service
public class DestinoService {

    @Autowired
    private DestinoRepository destinoRepository;

    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    public Destino findById(Long id) {
        return destinoRepository.findById(id).orElse(null);
    }

    public Destino save(Destino destino) {
        return destinoRepository.save(destino);
    }

    public void deleteById(Long id) {
        destinoRepository.deleteById(id);
    }
}
