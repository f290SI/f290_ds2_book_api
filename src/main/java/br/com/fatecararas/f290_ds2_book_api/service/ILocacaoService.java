package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.DevolucaoDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LocacaoDTO;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

public interface ILocacaoService {
    
    // public List<Locacao> buscarLocacoesPorEmail(String email);

    public List<LocacaoDTO> buscarTodas();

    public Locacao buscarPorIsbn(String isbn);

    public void baixarLocacao(String isbn, DevolucaoDTO dto);
}
