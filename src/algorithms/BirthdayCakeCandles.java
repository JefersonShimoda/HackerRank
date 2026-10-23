package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result5 {

    /*
     * Complete the 'birthdayCakeCandles' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY candles as parameter.
     */

    public static int birthdayCakeCandles(List<Integer> candles) {
//        int next = 0;
//        int total = 0, bigger = 0;
//        int start = candles.get(0);
//        for (int i = 0; i < candles.size(); i++ ){
//            if (i < candles.size() -1) {
//                next = (i + 1);
//            }
//            if (start <= candles.get(next)) {
//                bigger = candles.get(next);
//            }
//        }
//        for ( int j = 0; j < candles.size(); j++) {
//            if (candles.get(j) == bigger) {
//                total = total + 1;
//            }
//        }
//
//        return total;

        int bigger = 0;
        int total = 0;

        for (int i = 0; i < candles.size(); i++) {
            if (i == 0) {
                bigger = candles.get(i);
            } else if (candles.get(i) > bigger) {
                bigger = candles.get(i);
                total = 0;
            }

            if (bigger == candles.get(i)) {
                total = total + 1;
            }
        }

        return total;
    }

}

public class BirthdayCakeCandles {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int candlesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> candles = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result5.birthdayCakeCandles(candles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * A quantidade de velas de maior número
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * primeiro o numero de elementos, em seguida os elementos em int
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * só separar a vale de maior idade
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */