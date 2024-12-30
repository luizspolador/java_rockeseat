import java.util.ArrayList;
import java.util.List;

public class Listas {
    public static void main(String[] args) {
        List linguagens = new ArrayList();
        linguagens.add("Java");
        linguagens.add("C#");
        linguagens.add("JavaScript");
        linguagens.add("Go");

        System.out.println("Tamanho: " + linguagens.size()); // Tamanho: 4
        System.out.println("Linguagem na posição 3: " + linguagens.get(3)); // Linguagem na posição 3: Go
        System.out.println("A linguagem Java esta na posição: " + linguagens.indexOf("Java")); // A linguagem Java esta na posição: 0

//        linguagens.remove(2); // remove JavaScript
//        linguagens.remove("JavaScript"); -- outra opção de remoção

        // adicionando elemento em uma posição indicada
        linguagens.add(2, "Python");



        for (int i = 0; i < linguagens.size(); i++) {
            System.out.println(linguagens.get(i));
        }

        /*
            Resultado do for com o "remove" comentado
            Java
            C#
            Python
            JavaScript
            Go
        */

        // Outra forma de verificar os itens da lista. Traz o mesmo resultado acima
        for(Object lingaguem : linguagens){
            System.out.println(lingaguem);
        }

        // verificando se há "Java" dentro da lista
        System.out.println(linguagens.contains("Java")); // true
    }
}
