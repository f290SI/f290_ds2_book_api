package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.DevolucaoDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LocacaoDTO;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

public interface ILocacaoService {
    
    public List<LocacaoDTO> buscarTodas();

    public void baixarLocacao(String isbn, DevolucaoDTO dto);

    public Locacao buscarPorIsbn(String isbn);
}
