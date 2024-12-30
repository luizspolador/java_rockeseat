package modelo;

import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private LocalDate dataEmprestimo;

    public Emprestimo(Livro livro, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }
}
