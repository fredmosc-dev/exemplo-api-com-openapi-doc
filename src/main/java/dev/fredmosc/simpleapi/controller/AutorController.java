package dev.fredmosc.simpleapi.controller;

import dev.fredmosc.simpleapi.domain.Autor;
import dev.fredmosc.simpleapi.services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<Autor>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(autorService.findAll());
        }

        return ResponseEntity.ok(autorService.findByName(name));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Autor>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(autorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Autor> save(@Valid @RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.save(autor));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Autor> update(@RequestBody Autor autor) {
        return ResponseEntity.ok(autorService.update(autor));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        autorService.delete(id);
        return ResponseEntity.ok(null);
    }
}
