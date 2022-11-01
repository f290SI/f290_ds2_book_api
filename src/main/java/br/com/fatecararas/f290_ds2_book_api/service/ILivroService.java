package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;

public interface ILivroService {
    
    List<Livro> buscarTodos();
}
