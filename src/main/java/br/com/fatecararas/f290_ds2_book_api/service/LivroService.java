package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_book_api.exceptions.ObjectNotFoundException;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;
import br.com.fatecararas.f290_ds2_book_api.repository.LivroRepository;

@Service
public class LivroService implements ILivroService{

    @Autowired
    private LivroRepository repository;

    @Override
    public List<Livro> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Livro buscarPorId(Long id) {
        Optional<Livro> optLivro = repository.findById(id);

        if(Boolean.FALSE.equals(optLivro.isPresent())) {
            throw new ObjectNotFoundException(String.format("Livro não localizado. ID: %s", id));
        }

        return optLivro.get();
    }
    
}
