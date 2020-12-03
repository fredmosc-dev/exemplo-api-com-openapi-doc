package dev.fredmosc.simpleapi.controller;

import dev.fredmosc.simpleapi.domain.Editora;
import dev.fredmosc.simpleapi.services.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/editoras")
public class EditoraController {

    private final EditoraService editoraService;

    @Autowired
    public EditoraController(EditoraService editoraService) {
        this.editoraService = editoraService;
    }

    @GetMapping
    // editoras/?name=qualquer coisa
    public ResponseEntity<List<Editora>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(editoraService.findAll());
        }

        return ResponseEntity.ok(editoraService.findByName(name));
    }

    // /editoras/1
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Editora>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(editoraService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Editora> save(@Valid @RequestBody Editora editora) {
        return ResponseEntity.ok(editoraService.save(editora));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Editora> update(@RequestBody Editora editora) {
        return ResponseEntity.ok(editoraService.update(editora));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        editoraService.delete(id);
        return ResponseEntity.ok(null);
    }
}
