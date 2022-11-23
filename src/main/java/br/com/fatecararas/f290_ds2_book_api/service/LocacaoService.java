package br.com.fatecararas.f290_ds2_book_api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;
import br.com.fatecararas.f290_ds2_book_api.repository.LocacaoRepository;

@Service
public class LocacaoService implements ILocacaoService{

    @Autowired
    private LocacaoRepository repository;

    @Override
    public List<Locacao> buscarLocacoesPorEmail(String email) {        
        return repository.findByEmail(email);
    }
    
}
