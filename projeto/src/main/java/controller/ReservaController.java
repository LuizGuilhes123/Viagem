package controller;

import jakarta.validation.Valid;
import model.Reserva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ReservaService;

import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<Reserva> createReserva(@Valid  @RequestBody Reserva reserva) {
        Reserva newReserva = reservaService.save(reserva);
        return new ResponseEntity<>(newReserva, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Reserva>> getAllReservas() {
        List<Reserva> reservas = reservaService.findAll();
        return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reserva> getReservaById(@Valid @PathVariable Long id) {
        Reserva reserva = reservaService.findById(id);
        if (reserva == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reserva, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reserva> updateReserva(@Valid @PathVariable Long id, @RequestBody Reserva reserva) {
        Reserva existingReserva = reservaService.findById(id);
        if (existingReserva == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingReserva.setDataReserva(reserva.getDataReserva());
        existingReserva.setUsuario(reserva.getUsuario());
        existingReserva.setViagem(reserva.getViagem());
        existingReserva.setStatus(reserva.getStatus());
        Reserva updatedReserva = reservaService.save(existingReserva);
        return new ResponseEntity<>(updatedReserva, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReserva(@Valid @PathVariable Long id) {
        reservaService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
