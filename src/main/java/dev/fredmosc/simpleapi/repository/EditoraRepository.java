package dev.fredmosc.simpleapi.repository;

import dev.fredmosc.simpleapi.domain.Editora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EditoraRepository extends JpaRepository<Editora, Long> {
    List<Editora> findByNomeStartingWith(String name);
}
