package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LivroDTO;
import br.com.fatecararas.f290_ds2_book_api.exceptions.BusinessException;
import br.com.fatecararas.f290_ds2_book_api.exceptions.ObjectNotFoundException;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;
import br.com.fatecararas.f290_ds2_book_api.repository.LivroRepository;

@Service
public class LivroService implements ILivroService {

    @Autowired
    private LivroRepository repository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<LivroDTO> buscarTodos() {
        List<Livro> livros = repository.findAll();

        return livros.stream()
                .map(livro -> modelMapper.map(livro, LivroDTO.class))
                .collect(Collectors.toList());

    }

    @Override
    public LivroDTO buscarPorId(Long id) {
        return repository.findById(id)
                .map(livro -> modelMapper.map(livro, LivroDTO.class))
                .orElseThrow(() -> new ObjectNotFoundException(String
                        .format("Livro não localizado. ID: %s", id)));
    }

    @Override
    public Livro salvar(Livro livro) {
        if (repository.existsByIsbn(livro.getIsbn())) {
            throw new BusinessException("Isbn já cadastrado.");
        }
        return repository.save(livro);
    }

    // TODO: Criar os metodos necessários para o gerenciamento de livros [ criar,
    // apagar e atualizar ]

}
