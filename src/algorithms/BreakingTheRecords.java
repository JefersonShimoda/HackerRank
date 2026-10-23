package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result11 {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
        // Write your code here
        int highScore = 0, lowScore = 0, countLow = 0, countHigh = 0;
        for (int i = 0; i < scores.size(); i++) {
            if (i == 0) {
                highScore = scores.get(i);
                lowScore = scores.get(i);
            } else {
                if (scores.get(i) > highScore) {
                    highScore = scores.get(i);
                    countHigh = countHigh + 1;
                } else if (scores.get(i) < lowScore) {
                    lowScore = scores.get(i);
                    countLow = countLow + 1;
                }
            }
        }

        return List.of(countHigh, countLow);
    }

}

public class BreakingTheRecords {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result11.breakingRecords(scores);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}


/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * quantas vezes o recorde foi superado no maior score e no menor.
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * primeiro o tamanho do array, em seguida os elementos que são o score de cada jogo
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * ver quantas vezes o maior número é superado e o mesmo com menor
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */
