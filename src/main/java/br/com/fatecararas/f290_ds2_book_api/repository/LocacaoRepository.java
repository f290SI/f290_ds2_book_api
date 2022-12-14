package br.com.fatecararas.f290_ds2_book_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    @Query(value = "SELECT * FROM locacao lc "
            + "INNER JOIN livro l ON l.id = lc.id_livro " 
            + "WHERE l.isbn = :isbn AND lc.devolvido = false", nativeQuery = true)
    Locacao findByIsbn(@Param(value = "isbn") String isbn);

    @Query(value = "SELECT * FROM locacao lc WHERE lc.devolvido = false", nativeQuery = true)
    List<Locacao> findAll();

}
