package br.com.fatecararas.f290_ds2_book_api.api.v1.dto;

public class DevolucaoDTO {
    
    private String isbn;
    private Boolean devolvido;

    public DevolucaoDTO() {
    }

    public DevolucaoDTO(String isbn, Boolean devolvido) {
        this.isbn = isbn;
        
        this.devolvido = devolvido;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Boolean getDevolvido() {
        return devolvido;
    }

    public void setDevolvido(Boolean devolvido) {
        this.devolvido = devolvido;
    }

}
