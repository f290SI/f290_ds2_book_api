package br.com.fatecararas.f290_ds2_book_api.api.v1.dto;

import javax.validation.constraints.NotEmpty;

import br.com.fatecararas.f290_ds2_book_api.model.entity.Livro;

public class LivroDTO {
    private Long id;

    @NotEmpty
    private String titulo;
    @NotEmpty
    private String autor;
    @NotEmpty
    private String isbn;

    public LivroDTO() {
    }

    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.autor = livro.getAutor();
        this.titulo = livro.getTitulo();
        this.isbn = livro.getIsbn();
    }

    public LivroDTO(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
    }
    
    public Long getId() {
        return id;
    }

    public LivroDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public LivroDTO setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public String getAutor() {
        return autor;
    }

    public LivroDTO setAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public LivroDTO setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
        LivroDTO other = (LivroDTO) obj;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        } else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "LivroDTO [id=" + id + ", titulo=" + titulo + ", autor=" + autor + ", isbn=" + isbn + "]";
    }
    
}
