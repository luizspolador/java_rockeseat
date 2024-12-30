package modelo;

import java.time.LocalDate;

public class Livro {
    private Integer id_livro;
    private String titulo;
    private Autor autor;
    private boolean disponivel;
    private LocalDate dataCadastro;
    private LocalDate dataAtualizacao;

    public Livro(Integer id_livro, String titulo, Autor autor, boolean disponivel, LocalDate dataCadastro, LocalDate dataAtualizacao) {
        this.id_livro = id_livro;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = disponivel;
        this.dataCadastro = dataCadastro;
        this.dataAtualizacao = dataAtualizacao;
    }


    public boolean validarDisponibilidade() {
        return this.disponivel;
    }

    public void marcarIndisponivel() {
        this.disponivel = false;
    }


    public Integer getId_livro() {
        return id_livro;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public LocalDate getDataAtualizacao() {
        return dataAtualizacao;
    }
}
