package dev.fredmosc.simpleapi.controller;

import dev.fredmosc.simpleapi.domain.Categoria;
import dev.fredmosc.simpleapi.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    // categorias/?name=qualquer coisa
    public ResponseEntity<List<Categoria>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(categoriaService.findAll());
        }

        return ResponseEntity.ok(categoriaService.findByName(name));
    }

    // /categorias/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Categoria>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Categoria> save(@Valid @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.save(categoria));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update (@RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.update(categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        categoriaService.delete(id);
        return ResponseEntity.ok(null);
    }
}
