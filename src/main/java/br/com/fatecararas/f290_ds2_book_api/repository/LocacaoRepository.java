package br.com.fatecararas.f290_ds2_book_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

@Repository
public interface LocacaoRepository extends JpaRepository<Locacao, Long> {

    // @Query(value = "SELECT * FROM LOCACAO lc INNER JOIN livro l ON l.id = lc.id_livro WHERE lc.email = :email", nativeQuery = true)
    // public List<Locacao> buscarLocacaoPorEmail(@Param(value = "email") String email);

    //TODO: Implementar busca
    // public List<Locacao> buscarLocacoesPorIsbnOuNome(String isbn, String aluno);
    
    @Query("SELECT lc FROM Locacao lc INNER JOIN lc.livro l WHERE lc.email = :email")
    public List<Locacao> findByEmail(@Param(value = "email") String email);
    
}
