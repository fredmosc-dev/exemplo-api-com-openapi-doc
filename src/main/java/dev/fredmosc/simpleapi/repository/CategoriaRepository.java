package dev.fredmosc.simpleapi.repository;

import dev.fredmosc.simpleapi.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    List<Categoria> findByNameStartingWith(String name); // select * from categorias where name = ?;
}
