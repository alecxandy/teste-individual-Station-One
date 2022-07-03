package br.com.alexandredvlp.stationOneBackend.repository;

import br.com.alexandredvlp.stationOneBackend.entity.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FIlmeRepository extends JpaRepository<Filme, Long> {
}
