package br.com.alexandredvlp.stationOneBackend.controller;

import br.com.alexandredvlp.stationOneBackend.entity.Filme;
import br.com.alexandredvlp.stationOneBackend.service.FilmeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filme")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    //listar
    @GetMapping("/listar")
    public ResponseEntity<List<Filme>> findAll() {
        return ResponseEntity.ok().body(filmeService.findAll());
    }

    //listar por id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Filme>> findById(@PathVariable Long id) {
        Optional<Filme> optionalFilme = filmeService.findById(id);
        if (optionalFilme.isPresent()) {
            return ResponseEntity.ok().body(filmeService.findById(id));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //salvar
    @PostMapping("/salvar")
    public ResponseEntity<Filme> save(@RequestBody Filme filme) {
        return ResponseEntity.status(HttpStatus.CREATED).body(filmeService.save(filme));
    }

    //atualizar
    @PutMapping("/update")
    public ResponseEntity<Filme> update(@RequestBody Filme filme) {
        Optional<Filme> optionalFilme = filmeService.findById(filme.getId());
        if (optionalFilme.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(filmeService.save(filme));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    //deletar por id
    @DeleteMapping("/{id}")
    public ResponseEntity<Filme> delete(@PathVariable Long id) {
        Optional<Filme> optionalFilme = filmeService.findById(id);
        if (optionalFilme.isPresent()) { //isEmplty a partir do java 11
            filmeService.delete(optionalFilme.get().getId());
            return ResponseEntity.status(HttpStatus.OK).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
