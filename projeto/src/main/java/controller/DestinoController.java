package controller;

import jakarta.validation.Valid;
import model.Destino;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.DestinoService;

import java.util.List;

@RestController
@RequestMapping("/api/destinos")
public class DestinoController {

    @Autowired
    private DestinoService destinoService;

    @PostMapping
    public ResponseEntity<Destino> createDestino(@Valid  @RequestBody Destino destino) {
        Destino newDestino = destinoService.save(destino);
        return new ResponseEntity<>(newDestino, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Destino>> getAllDestinos() {
        List<Destino> destinos = destinoService.findAll();
        return new ResponseEntity<>(destinos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Destino> getDestinoById(@Valid @PathVariable Long id) {
        Destino destino = destinoService.findById(id);
        if (destino == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destino, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Destino> updateDestino(@Valid @PathVariable Long id, @RequestBody Destino destino) {
        Destino existingDestino = destinoService.findById(id);
        if (existingDestino == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingDestino.setNome(destino.getNome());
        existingDestino.setDescricao(destino.getDescricao());
        existingDestino.setLocalizacao(destino.getLocalizacao());
        existingDestino.setPreco(destino.getPreco());
        Destino updatedDestino = destinoService.save(existingDestino);
        return new ResponseEntity<>(updatedDestino, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDestino(@Valid @PathVariable Long id) {
        destinoService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
