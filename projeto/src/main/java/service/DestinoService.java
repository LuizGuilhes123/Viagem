package service;

import model.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.DestinoRepository;

import java.util.List;

@Service
public class DestinoService {

    private final DestinoRepository destinoRepository;

    @Autowired
    public DestinoService(DestinoRepository destinoRepository) {
        this.destinoRepository = destinoRepository;
    }

    public Destino save(Destino destino) {
        return destinoRepository.save(destino);
    }

    public List<Destino> findAll() {
        return destinoRepository.findAll();
    }

    public Destino update(Long id, Destino destinoAtualizado) {
        Destino destinoExistente = findById(id);
        if (destinoExistente != null) {
            destinoExistente.setNome(destinoAtualizado.getNome());
            destinoExistente.setDescricao(destinoAtualizado.getDescricao());
            destinoExistente.setLocalizacao(destinoAtualizado.getLocalizacao());
            destinoExistente.setPreco(destinoAtualizado.getPreco());
            return destinoRepository.save(destinoExistente);
        }
        return null;
    }

    public void deleteById(Long id) {
        destinoRepository.deleteById(id);
    }

    public Destino findById(Long id) {
        return destinoRepository.findById(id).orElse(null);
    }
}
