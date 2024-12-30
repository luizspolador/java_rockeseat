package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();
    private List<Autor> autores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public Biblioteca() {
    }

    public void adicionaLivros(Livro... livros) {
        this.livros.addAll(Arrays.asList(livros));
    }

    public void adicionaAutores(Autor... autores) {
        this.autores.addAll(Arrays.asList(autores));
    }

    public void adicionaClientes(Cliente... clientes) {
        this.clientes.addAll(Arrays.asList(clientes));
    }

    public void mostrarLivrosDisponiveis() {
        System.out.println("Livros disponíveis: ");
        for (Livro livro : livros) {
            if (livro.isDisponivel()) {
                System.out.println(
                        "ID " + livro.getId_livro() +
                                ", Título: " + livro.getTitulo() +
                                ", Autor: " + livro.getAutor() +
                                ", Disponibilidade: " + livro.isDisponivel() +
                                ", Data cadastro: " + livro.getDataCadastro() +
                                ", Data atualização: " + livro.getDataAtualizacao());
            }
        }
    }

    public Livro encontrarLivroPorId(Integer id) {
        for (Livro livro : livros) {
            if (livro.getId_livro().equals(id)) {
                return livro;
            }
        }
        return null;
    }

    // Método para listar todos os clientes -- NÃO UTILIZADO NO SISTEMA
//    public void listarClientes() {
//        System.out.println("Clientes cadastrados: ");
//        for (Cliente cliente : clientes) {
//            System.out.println("ID: " + cliente.getId_cliente() + ", Nome: " + cliente.getNome() + ", Email: " + cliente.getEmail());
//        }
//    }

    // Método para associar um empréstimo a um cliente
    public void associarEmprestimo(Cliente cliente, Livro livro) {
        if (livro.isDisponivel()) {
            Emprestimo emprestimo = new Emprestimo(livro, LocalDate.now());
            cliente.adicionarEmprestimo(emprestimo);
            livro.marcarIndisponivel();
            System.out.println("Empréstimo realizado com sucesso para o cliente " + cliente.getNome());
        } else {
            System.out.println("O livro " + livro.getTitulo() + " não está disponível para empréstimo.");
        }
    }

    // Método para visualizar os empréstimos de um cliente
    public void mostrarEmprestimosCliente(Cliente cliente) {
        System.out.println("Empréstimos do cliente " + cliente.getNome() + ": ");
        for (Emprestimo emprestimo : cliente.getEmprestimos()) {
            System.out.println("Livro: " + emprestimo.getLivro().getTitulo() + ", Data do Empréstimo: " + emprestimo.getDataEmprestimo());
        }
    }

    public Cliente encontrarClientePorNome(String nome) {
        for (Cliente cliente : clientes) {
            if (cliente.getNome().equalsIgnoreCase(nome)) {
                return cliente;
            }
        }
        return null;
    }
}
