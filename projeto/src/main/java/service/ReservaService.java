package service;

import model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservaRepository;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    @Autowired
    public ReservaService(ReservaRepository reservaRepository) {
        this.reservaRepository = reservaRepository;
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    public Reserva update(Long id, Reserva reservaAtualizada) {
        Reserva reservaExistente = findById(id);
        if (reservaExistente != null) {
            reservaExistente.setDataReserva(reservaAtualizada.getDataReserva());
            reservaExistente.setUsuario(reservaAtualizada.getUsuario());
            reservaExistente.setViagem(reservaAtualizada.getViagem());
            reservaExistente.setStatus(reservaAtualizada.getStatus());
            return reservaRepository.save(reservaExistente);
        }
        return null;
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    public Reserva findById(Long id) {
        return reservaRepository.findById(id).orElse(null);
    }
}
