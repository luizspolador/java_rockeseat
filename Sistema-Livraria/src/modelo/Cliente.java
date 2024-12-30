package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id_cliente;
    private String nome;
    private LocalDate dataNascimento;
    private String email;
    private List<Emprestimo> emprestimos;

    public Cliente(Integer id_cliente, String nome, LocalDate dataNascimento, String email) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.emprestimos = new ArrayList<>();
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public String getNome() {
        return nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        this.emprestimos.add(emprestimo);
    }
}
