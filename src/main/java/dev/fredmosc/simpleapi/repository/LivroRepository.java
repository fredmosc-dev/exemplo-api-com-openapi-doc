package dev.fredmosc.simpleapi.repository;

import dev.fredmosc.simpleapi.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByTituloStartsWith(String titulo);
}
