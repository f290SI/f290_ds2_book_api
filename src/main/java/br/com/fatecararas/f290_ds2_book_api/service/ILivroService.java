package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;

public interface ILivroService {
    
    List<Livro> buscarTodos();

    Livro buscarPorId(Long id);

    //TODO: Incluir as assinaturas dos metodos a serem implementados pelo Service.
}
