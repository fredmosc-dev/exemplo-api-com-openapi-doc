package dev.fredmosc.simpleapi.controller;

import dev.fredmosc.simpleapi.domain.Autor;
import dev.fredmosc.simpleapi.services.AutorService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/autores")
@Tag(name = "autores", description = "Gerencia autores de livros")
public class AutorController {

    private final AutorService autorService;

    @Autowired
    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    @Operation(description = "Lista todos os autores dos livros")
    @ApiResponse(responseCode = "200", description = "Devolve um array com todos os autores")
    public ResponseEntity<List<Autor>> findAll(@RequestParam(required = false) String name) {
        if (name == null) {
            return ResponseEntity.ok(autorService.findAll());
        }

        return ResponseEntity.ok(autorService.findByName(name));
    }

    @GetMapping("/{id}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Encontrado autor", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = Autor.class))}),
            @ApiResponse(responseCode = "400", description = "Id inválido para autor", content = @Content),
            @ApiResponse(responseCode = "404", description = "Autor não encontrado", content = @Content) })
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
