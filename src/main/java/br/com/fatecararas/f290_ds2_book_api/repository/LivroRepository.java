package br.com.fatecararas.f290_ds2_book_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    boolean existsByIsbn(String isbn);
}
