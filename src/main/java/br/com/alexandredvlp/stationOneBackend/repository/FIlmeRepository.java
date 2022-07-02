package br.com.alexandredvlp.stationOneBackend.repository;

import br.com.alexandredvlp.stationOneBackend.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FIlmeRepository extends JpaRepository<Filme, Long> {
}
