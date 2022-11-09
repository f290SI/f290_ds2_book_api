package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LivroDTO;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;

public interface ILivroService {
    
    List<LivroDTO> buscarTodos();

    LivroDTO buscarPorId(Long id);

    //TODO: Incluir as assinaturas dos metodos a serem implementados pelo Service.

    Livro salvar(Livro livro);
}
