package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result4 {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) throws IOException {

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        int next = 0;
        long total = 0L;
        long smaller = arr.get(0), bigger = arr.get(0);
        for (int i = 0; i < arr.size(); i++ ){
            if (i < arr.size() -1) {
                next = (i + 1);
            }
            if (bigger <= arr.get(next)) {
                bigger = arr.get(next);
            }
            if (smaller > arr.get(i)) {
                smaller = arr.get(i);
            }
            total = total + arr.get(i);
        }
        bufferedWriter.write(String.valueOf(total-bigger) + " " + String.valueOf(total-smaller));
        bufferedWriter.close();

    }

}

public class MiniMaxSum {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result4.miniMaxSum(arr);

        bufferedReader.close();
    }
}

/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * O soma de todos os elementos menores, fora o maior, e a soma de todos os elementos maiores fora o menor.
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * 5 elementos positivo
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * pegaria os 4 menos numeros e os 5 maiores  e somaria entre eles
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * descobrir o maior e o menor elemento e subtrair do total,
 * para descobrir o menor eu comparo o atual com o proximo e coloco em uma variavel caso seja menor
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */