package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result10 {

    /*
     * Complete the 'getTotalX' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER_ARRAY b
     */

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        List<Integer> candidatos = new ArrayList<>();
        List<Integer> multiplos = new ArrayList<>();
        int biggerA = 0, minnorB = 0;

        for (int i = 0; i < a.size(); i++) {
            if (i == 0) {
                biggerA = a.get(i);
            } else {
                if (a.get(i) > biggerA) {
                    biggerA = a.get(i);
                }
            }
        }
        for (int i = 0; i < b.size(); i++) {
            if (i == 0) {
                minnorB = b.get(i);
            } else {
                if (b.get(i) < minnorB) {
                    minnorB = b.get(i);
                }
            }
        }

        for (int i = biggerA; i <= minnorB; i++) {
            candidatos.add(i);
        }

        for (int i = 0; i < candidatos.size(); i++) {
            boolean valid = true;
            for (int j = 0; j < a.size(); j++) {
                if (candidatos.get(i) % a.get(j) != 0) {
                    valid = false;
                    break;
                }
            }
            if (valid == true){
                for (int k = 0; k < b.size(); k++) {
                    if (b.get(k) % candidatos.get(i) != 0){
                        valid = false;
                        break;
                    }
                }
            }
            if (valid == true) {
                multiplos.add(candidatos.get(i));
            }
        }
        return multiplos.size();
    }

}

public class BetweenTwoSets {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int total = Result10.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * numeros entre os array que sao divisiveis por ambos
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * tamanho do primeiro array e do segundo, em seguida os elementos do primeiro array e do segundo
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */