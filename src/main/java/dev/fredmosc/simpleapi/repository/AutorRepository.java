package dev.fredmosc.simpleapi.repository;

import dev.fredmosc.simpleapi.domain.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByNomeStartingWith(String name);
}
