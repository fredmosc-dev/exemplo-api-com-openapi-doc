package dev.fredmosc.simpleapi.services;

import dev.fredmosc.simpleapi.domain.Categoria;
import dev.fredmosc.simpleapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria save(Categoria categoria) {
        System.out.println("Realizando regra de negocio 1");
        Categoria categoriaSalva = categoriaRepository.save(categoria);
        System.out.println("Realizando regra de negocio 2");
        return categoriaSalva;
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Long id) {
        return categoriaRepository.findById(id);
    }

    public List<Categoria> findByName(String name) {
        return categoriaRepository.findByNameStartingWith(name);
    }

    public Categoria update(Categoria categoria) {
        Categoria categoriaSalva = new Categoria();
        if (categoria.getId() != null) {
            categoriaSalva = this.save(categoria);
        }
        return categoriaSalva;
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }
}
