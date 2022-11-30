package br.com.fatecararas.f290_ds2_book_api.model.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Locacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String aluno;
    private String email;
    private LocalDate dataLocacao;
    @Column(columnDefinition = "boolean default false")
    private Boolean devolvido = false;

    @ManyToOne
    @JoinColumn(name = "id_livro")
    private Livro livro;

    public Locacao() {
    }

    public Long getId() {
        return id;
    }
    public Locacao setId(Long id) {
        this.id = id;
        return this;
    }
    public String getAluno() {
        return aluno;
    }
    public Locacao setAluno(String aluno) {
        this.aluno = aluno;
        return this;
    }
    public String getEmail() {
        return email;
    }
    public Locacao setEmail(String email) {
        this.email = email;
        return this;
    }
    public Livro getLivro() {
        return livro;
    }
    public Locacao setLivro(Livro livro) {
        this.livro = livro;
        return this;
    }
    public LocalDate getDataLocacao() {
        return dataLocacao;
    }
    public Locacao setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
        return this;
    }
    public Boolean getDevolvido() {
        return devolvido;
    }
    public Locacao setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Locacao other = (Locacao) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Locacao [id=" + id + ", aluno=" + aluno + ", email=" + email + ", dataLocacao=" + dataLocacao
                + ", devolvido=" + devolvido + ", livro=" + livro + "]";
    }

}
