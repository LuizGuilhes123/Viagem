package service;

import model.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ViagemRepository;

import java.util.List;

@Service
public class ViagemService {

    @Autowired
    private ViagemRepository viagemRepository;

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public Viagem findById(Long id) {
        return viagemRepository.findById(id).orElse(null);
    }

    public Viagem save(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public void deleteById(Long id) {
        viagemRepository.deleteById(id);
    }

    public List<Viagem> findByUsuarioId(Long usuarioId) {
        return viagemRepository.findByUsuarioId(usuarioId);
    }

    public List<Viagem> findByDestino(String destino) {
        return viagemRepository.findByDestino(destino);
    }

    public List<Viagem> findByDataInicio(String dataInicio) {
        return viagemRepository.findByDataInicio(dataInicio);
    }

    public List<Viagem> findByPreco(Double preco) {
        return viagemRepository.findByPreco(preco);
    }

    public Viagem reservaViagem(Viagem viagem) {
        if (viagem.getId()!= null) {
            throw new RuntimeException("Viagem já existe");
        }
        viagem.setStatus("RESERVADA");
        return viagemRepository.save(viagem);
    }
}