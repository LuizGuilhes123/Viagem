package service;

import model.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ViagemRepository;

import java.util.List;

@Service
public class ViagemService {

    private final ViagemRepository viagemRepository;

    @Autowired
    public ViagemService(ViagemRepository viagemRepository) {
        this.viagemRepository = viagemRepository;
    }

    public Viagem save(Viagem viagem) {
        return viagemRepository.save(viagem);
    }

    public List<Viagem> findAll() {
        return viagemRepository.findAll();
    }

    public Viagem update(Long id, Viagem viagemAtualizada) {
        Viagem viagemExistente = findById(id);
        if (viagemExistente != null) {
            viagemExistente.setDestino(viagemAtualizada.getDestino());
            viagemExistente.setDataInicio(viagemAtualizada.getDataInicio());
            viagemExistente.setDataFim(viagemAtualizada.getDataFim());
            return viagemRepository.save(viagemExistente);
        }
        return null;
    }

    public void deleteById(Long id) {
        viagemRepository.deleteById(id);
    }

    public Viagem findById(Long id) {
        return viagemRepository.findById(id).orElse(null);
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
        // Lógica para reservar a viagem
        return viagemRepository.save(viagem);
    }

    public List<Viagem> findByUsuarioId(Long usuarioId) {
        return viagemRepository.findByUsuarioId(usuarioId);
    }
}
