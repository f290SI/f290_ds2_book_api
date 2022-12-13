package br.com.fatecararas.f290_ds2_book_api.api.v1.resource;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.validator.internal.util.privilegedactions.IsClassPresent;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.DevolucaoDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LivroDTO;
import br.com.fatecararas.f290_ds2_book_api.api.v1.dto.LocacaoDTO;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;
import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;
import br.com.fatecararas.f290_ds2_book_api.service.impl.LivroService;
import br.com.fatecararas.f290_ds2_book_api.service.impl.LocacaoService;

@RestController
@RequestMapping("/api/v1/livro/locacao")
public class LocacaoController {

    @Autowired
    private LocacaoService service;
    @Autowired
    private LivroService livroService;
    @Autowired
    private ModelMapper modelMapper;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<LocacaoDTO> buscarTodas() {
        return service.buscarTodas();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Locacao criar(@RequestBody @Valid LocacaoDTO dto) {

        LivroDTO livroDTO = livroService.buscarPorId(dto.getLivroDTO().getId());

        Locacao locacao = new Locacao()
                .setLivro(modelMapper.map(livroDTO, Livro.class))
                .setAluno(dto.getAluno())
                .setDataLocacao(LocalDate.now())
                .setEmail(dto.getEmail());

        return service.salvar(locacao);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/devolucao/{isbn}")
    public void baixar(@PathVariable("isbn") String isbn, @RequestBody @Valid DevolucaoDTO dto) {
        service.baixarLocacao(isbn, dto);
    }

}
