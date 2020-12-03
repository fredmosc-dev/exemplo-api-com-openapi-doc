package dev.fredmosc.simpleapi.services;

import dev.fredmosc.simpleapi.domain.Livro;
import dev.fredmosc.simpleapi.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    @Autowired
    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Optional<Livro> findById(Long id) {
        return livroRepository.findById(id);
    }

    public List<Livro> findByTitulo(String titulo) {
        return livroRepository.findByTituloStartsWith(titulo);
    }

    public Livro update(Livro livro) {
        Livro livroSalva = new Livro();
        if (livro.getId() != null) {
            livroSalva = this.save(livro);
        }
        return livroSalva;
    }

    public void delete(Long id) {
        livroRepository.deleteById(id);
    }
}
