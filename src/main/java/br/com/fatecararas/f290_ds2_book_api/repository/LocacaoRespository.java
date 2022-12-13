package br.com.fatecararas.f290_ds2_book_api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Locacao;

@Repository
public interface LocacaoRespository extends JpaRepository<Locacao, Long> {

    @Query(value =  "select * from locacao lc inner join livro l on l.id = lc.id_livro where lc.aluno = :aluno or l.isbn = :isbn", nativeQuery = true)
    public List<Locacao> findByIsbnOrName(@Param("isbn") String isbn, @Param("aluno") String aluno);
}
