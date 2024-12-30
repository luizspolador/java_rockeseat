import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Maps {
    public static void main(String[] args) {
        Map<String, String> estadoBrasileiro = new HashMap<>();
        estadoBrasileiro.put("SP", "SAO PAULO");
        estadoBrasileiro.put("RJ", "RIO DE JANEIRO");
        estadoBrasileiro.put("PR", "PARANA");
        estadoBrasileiro.put("SC", "SANTA CATARINA");
        estadoBrasileiro.put("RS", "RIO GRANDE DO SUL");

        Iterator<String> ufs = estadoBrasileiro.keySet().iterator();
        while (ufs.hasNext()){
            String key = ufs.next();
            String value = estadoBrasileiro.get(key);
            System.out.println("Sigla: " + key + ", Estado: " + value);
        }
    }
}
