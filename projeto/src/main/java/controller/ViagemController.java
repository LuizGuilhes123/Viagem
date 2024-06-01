package controller;

import model.Viagem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.ViagemService;

import java.util.List;


@RestController
@RequestMapping("/api/viagens")
public class ViagemController {

    @Autowired
    private ViagemService viagemService;

    @PostMapping
    public ResponseEntity<Viagem> createViagem(@RequestBody Viagem viagem) {
        Viagem newViagem = viagemService.save(viagem);
        return new ResponseEntity<>(newViagem, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Viagem>> getAllViagens() {
        List<Viagem> viagens = viagemService.findAll();
        return new ResponseEntity<>(viagens, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Viagem> getViagemById(@PathVariable Long id) {
        Viagem viagem = viagemService.findById(id);
        if (viagem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(viagem, HttpStatus.OK);
    }

    @GetMapping("/destino/{destino}")
    public ResponseEntity<List<Viagem>> getViagensByDestino(@PathVariable String destino) {
        List<Viagem> viagens = viagemService.findByDestino(destino);
        return new ResponseEntity<>(viagens, HttpStatus.OK);
    }

    @GetMapping("/data-inicio/{dataInicio}")
    public ResponseEntity<List<Viagem>> getViagensByDataInicio(@PathVariable String dataInicio) {
        List<Viagem> viagens = viagemService.findByDataInicio(dataInicio);
        return new ResponseEntity<>(viagens, HttpStatus.OK);
    }

    @GetMapping("/preco/{preco}")
    public ResponseEntity<List<Viagem>> getViagensByPreco(@PathVariable Double preco) {
        List<Viagem> viagens = viagemService.findByPreco(preco);
        return new ResponseEntity<>(viagens, HttpStatus.OK);
    }

    @PostMapping("/reserva")
    public ResponseEntity<Viagem> reservaViagem(@RequestBody Viagem viagem) {
        Viagem newViagem = viagemService.reservaViagem(viagem);
        return new ResponseEntity<>(newViagem, HttpStatus.CREATED);
    }

    @GetMapping("/meus-viagens/{usuarioId}")
    public ResponseEntity<List<Viagem>> getViagensByUsuario(@PathVariable Long usuarioId) {
        List<Viagem> viagens = viagemService.findByUsuarioId(usuarioId);
        return new ResponseEntity<>(viagens, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Viagem> updateViagem(@PathVariable Long id, @RequestBody Viagem viagem) {
        Viagem existingViagem = viagemService.findById(id);
        if (existingViagem == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existingViagem.setDestino(viagem.getDestino());
        existingViagem.setDataInicio(viagem.getDataInicio());
        existingViagem.setDataFim(viagem.getDataFim());
        existingViagem.setDescricao(viagem.getDescricao());
        existingViagem.setPreco(viagem.getPreco());
        Viagem updatedViagem = viagemService.save(existingViagem);
        return new ResponseEntity<>(updatedViagem, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteViagem(@PathVariable Long id) {
        viagemService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}