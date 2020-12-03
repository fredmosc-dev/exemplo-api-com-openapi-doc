package dev.fredmosc.simpleapi.services;

import dev.fredmosc.simpleapi.domain.Autor;
import dev.fredmosc.simpleapi.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    private final AutorRepository autorRepository;

    @Autowired
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public Autor save(Autor autor) {
        String[] s = autor.getNome().split(" ");
        autor.setNomeCatalogo(autor.getNome().split(" ")[s.length - 1].toUpperCase() + ", " + String.join(" ", Arrays.copyOf(s, s.length - 1)));
        return autorRepository.save(autor);
    }

    public List<Autor> findAll() {
        return autorRepository.findAll();
    }

    public Optional<Autor> findById(Long id) {
        return autorRepository.findById(id);
    }

    public List<Autor> findByName(String name) {
        return autorRepository.findByNomeStartingWith(name);
    }

    public Autor update(Autor autor) {
        Autor autorSalva = new Autor();
        if (autor.getId() != null) {
            autorSalva = this.save(autor);
        }
        return autorSalva;
    }

    public void delete(Long id) {
        autorRepository.deleteById(id);
    }
}
