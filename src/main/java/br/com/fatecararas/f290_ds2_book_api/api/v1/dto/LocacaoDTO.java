package br.com.fatecararas.f290_ds2_book_api.api.v1.dto;

import java.time.LocalDate;

public class LocacaoDTO {

    private Long id;
    private String aluno;
    private String email;
    private LocalDate dataLocacao;
    private Boolean devolvido;

    public LocacaoDTO() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAluno() {
        return aluno;
    }
    public void setAluno(String aluno) {
        this.aluno = aluno;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public LocalDate getDataLocacao() {
        return dataLocacao;
    }
    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }
    public Boolean getDevolvido() {
        return devolvido;
    }
    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
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
        LocacaoDTO other = (LocacaoDTO) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
    
}
