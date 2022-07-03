package br.com.alexandredvlp.stationOneBackend.service;

import br.com.alexandredvlp.stationOneBackend.entity.Filme;
import br.com.alexandredvlp.stationOneBackend.repository.FIlmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class FilmeService {

    @Autowired
    private FIlmeRepository fIlmeRepository;

    public List<Filme> findAll() {
        return fIlmeRepository.findAll();
    }

    public Optional<Filme> findById(Long id) {
        return fIlmeRepository.findById(id);
    }

    public Filme save(Filme filme) {
        return fIlmeRepository.save(filme);
    }

    public void delete(Long id) {
        fIlmeRepository.deleteById(id);
    }

}
