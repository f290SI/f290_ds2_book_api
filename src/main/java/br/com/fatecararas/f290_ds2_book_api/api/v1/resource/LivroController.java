package br.com.fatecararas.f290_ds2_book_api.api.v1.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;
import br.com.fatecararas.f290_ds2_book_api.service.LivroService;

@RestController
@RequestMapping("/api/v1/livro")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/todos")
    public ResponseEntity<?> findAll() {
        List<Livro> livros = service.buscarTodos();

        if (livros.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().body(livros);
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    public Livro findById(@PathVariable("id") Long id) {
        Livro livro = service.buscarPorId(id);
        return livro;
    }

    @PostMapping("/post")
    public ResponseEntity<Void> helloPost() {
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
