package dev.fredmosc.simpleapi.controller;

import dev.fredmosc.simpleapi.domain.Livro;
import dev.fredmosc.simpleapi.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
public class LivroController {

    private final LivroService livroService;

    @Autowired
    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping
    public ResponseEntity<List<Livro>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(livroService.findAll());
        }

        return ResponseEntity.ok(livroService.findByTitulo(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Livro>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(livroService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Livro> save(@Valid @RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.save(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@RequestBody Livro livro) {
        return ResponseEntity.ok(livroService.update(livro));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.ok(null);
    }
}
