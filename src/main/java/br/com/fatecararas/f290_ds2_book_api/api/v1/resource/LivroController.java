package br.com.fatecararas.f290_ds2_book_api.api.v1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;
import br.com.fatecararas.f290_ds2_book_api.service.LivroService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    @Autowired
    private LivroService service;
    
    @ApiOperation("Retorna todos livro cadastrados.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Livros recuperados com sucesso."),
        @ApiResponse(code = 404, message = "Nenhum livro cadastrado.")
    })
    @GetMapping("/todos")
    public ResponseEntity<?> findAll() {
        List<Livro> livros = service.buscarTodos();

        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(livros);
    }

    @ApiOperation("Retorna um livro cadastrado com base em seu ID.")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Livro recuperado com sucesso."),
        @ApiResponse(code = 404, message = "Livro não localizado.")
    })
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Livro findById(@PathVariable("id") Long id) {
        Livro livro = service.buscarPorId(id);
        return livro;
    }

    //TODO: Criar os demais métodos para o gerenciamento de livros da API. [ criar, apagar e atualizar ] com a documentação implementada.

}
