package repository;

import model.Viagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ViagemRepository extends JpaRepository<Viagem, Long> {

    List<Viagem> findByDestino(String destino);

    List<Viagem> findByDataInicio(String dataInicio);

    List<Viagem> findByPreco(Double preco);

    List<Viagem> findByUsuarioId(Long usuarioId);
}