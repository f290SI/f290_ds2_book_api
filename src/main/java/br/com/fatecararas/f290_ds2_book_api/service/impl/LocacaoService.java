package br.com.fatecararas.f290_ds2_book_api.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.DevolucaoDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LivroDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LocacaoDTO;
import br.com.fatecararas.f290_ds2_book_api.exceptions.ObjectNotFoundException;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;
import br.com.fatecararas.f290_ds2_book_api.repository.LocacaoRepository;
import br.com.fatecararas.f290_ds2_book_api.service.ILocacaoService;

@Service
public class LocacaoService implements ILocacaoService {

    @Autowired
    private LocacaoRepository repository;
    @Autowired
    ModelMapper modelMapper;

    public Locacao salvar(Locacao locacao) {
        return repository.save(locacao);
    }

    // @Override
    // public List<Locacao> buscarLocacoesPorEmail(String email) {
    //     return repository.findByEmail(email);
    // }

    @Override
    public List<LocacaoDTO> buscarTodas() {

        List<LocacaoDTO> locacoes = repository.findAll()
                .stream()
                .map(l -> {
                    LocacaoDTO locacaoDTO = modelMapper.map(l, LocacaoDTO.class);
                    LivroDTO livroDTO = modelMapper.map(l.getLivro(), LivroDTO.class);
                    locacaoDTO.setLivroDTO(livroDTO);
                    return locacaoDTO;
                })
                .collect(Collectors.toList());

        if (locacoes.isEmpty()) {
            throw new ObjectNotFoundException("Ainda não há locações.");
        }

        return locacoes;
    }

    @Override
    public Locacao buscarPorIsbn(String isbn) {
        Locacao entity = repository.findByIsbn(isbn);

        if (Objects.isNull(entity)) {
            throw new ObjectNotFoundException(String.format("Locação não encontrada. ISBN: %s.", isbn));
        }
        
        return entity;
    }

    @Override
    public void baixarLocacao(String isbn, DevolucaoDTO dto) {
        Locacao entity = buscarPorIsbn(isbn);
        entity.setDevolvido(dto.getDevolvido());
        repository.save(entity);
    }

}
