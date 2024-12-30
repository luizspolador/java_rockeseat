package principal;

import modelo.Autor;
import modelo.Biblioteca;
import modelo.Cliente;
import modelo.Livro;

import java.time.LocalDate;
import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Criação de autores
        Autor autor = new Autor(21, "João", LocalDate.of(2024, 02, 16));
        Autor autor01 = new Autor(23, "Mariana", LocalDate.of(2024, 04, 11));
        Autor autor02 = new Autor(27, "Felipe", LocalDate.of(203, 01, 23));

        // Criação de livros
        Livro livro01 = new Livro(1, "Titulo01", autor, true, LocalDate.now(), LocalDate.of(2010, 6, 12));
        Livro livro02 = new Livro(2, "Titulo02", autor01, true, LocalDate.now(), LocalDate.of(2021, 2, 18));
        Livro livro03 = new Livro(3, "Titulo04", autor01, true, LocalDate.now(), LocalDate.of(2024, 1, 30));
        Livro livro04 = new Livro(4, "Titulo05", autor, false, LocalDate.now(), LocalDate.of(2005, 7, 20));
        Livro livro05 = new Livro(5, "Titulo06", autor02, false, LocalDate.now(), LocalDate.of(1999, 9, 5));

        // Criação de clientes
        Cliente cliente1 = new Cliente(1, "Carlos", LocalDate.of(1990, 5, 15), "carlos@gmail.com");
        Cliente cliente2 = new Cliente(2, "Ana", LocalDate.of(1992, 7, 20), "ana@gmail.com");

        // Criação da biblioteca
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.adicionaAutores(autor, autor01, autor02);
        biblioteca.adicionaLivros(livro01, livro02, livro03, livro04, livro05);
        biblioteca.adicionaClientes(cliente1, cliente2);

        String resposta;

        do {
            // Mostrar livros disponíveis
            System.out.println("Gostaria de ver os livros disponíveis?");
            resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")) {
                biblioteca.mostrarLivrosDisponiveis();
                System.out.println("Escolha o id do livro desejado: ");
                Integer id_escolhido = sc.nextInt();
                sc.nextLine(); // Consumir a nova linha

                Livro livroEscolhido = biblioteca.encontrarLivroPorId(id_escolhido);

                if (livroEscolhido != null && livroEscolhido.validarDisponibilidade()) {
                    // Solicitar o cliente para emprestar o livro
                    System.out.println("Informe o nome do cliente que fará o empréstimo: ");
                    String nomeCliente = sc.nextLine().trim();

                    Cliente cliente = biblioteca.encontrarClientePorNome(nomeCliente);
                    if (cliente != null) {
                        biblioteca.associarEmprestimo(cliente, livroEscolhido);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                } else if (livroEscolhido != null) {
                    System.out.println("O livro '" + livroEscolhido.getTitulo() + "' já está indisponível.");
                } else {
                    System.out.println("Livro não encontrado.");
                }
            }

            // Consultar os empréstimos de um cliente
            System.out.println("Deseja consultar os empréstimos de um cliente? (S/N)");
            resposta = sc.nextLine().trim();

            if (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim")) {
                System.out.println("Informe o nome do cliente: ");
                String nomeCliente = sc.nextLine().trim();

                Cliente cliente = biblioteca.encontrarClientePorNome(nomeCliente);
                if (cliente != null) {
                    biblioteca.mostrarEmprestimosCliente(cliente);
                } else {
                    System.out.println("Cliente não encontrado.");
                }
            }

        } while (resposta.equalsIgnoreCase("S") || resposta.equalsIgnoreCase("Sim"));

        System.out.println("Fim da aplicação");

        sc.close();
    }
}
