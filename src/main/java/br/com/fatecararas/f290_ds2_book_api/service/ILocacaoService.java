package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

public interface ILocacaoService {
    
    public List<Locacao> buscarLocacoesPorEmail(String email);
}
