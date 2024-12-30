import java.util.HashSet;
import java.util.Set;

public class Sets {
    public static void main(String[] args) {
        Set linguagens = new HashSet(); // não permite duplicidade de valores - não imprime necessariamente na ordem
        linguagens.add("Java");
        linguagens.add("C#");
        linguagens.add("JavaScript");
        linguagens.add("Go");
        linguagens.add("Python");

        for(Object lingaguem : linguagens){
            System.out.println(lingaguem);
        }

        /*
            C#
            Java
            JavaScript
            Go
            Python
         */
    }
}
