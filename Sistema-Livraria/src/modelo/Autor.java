package modelo;

import java.time.LocalDate;

public class Autor {
    private Integer id_autor;
    private String nome;
    private LocalDate dataNascimento;

    public Autor(Integer id_autor, String nome, LocalDate dataNascimento) {
        this.id_autor = id_autor;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    public Integer getId_autor() {
        return id_autor;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
}
