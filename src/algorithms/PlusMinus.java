package algorithms;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.toList;

class Result2 {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) throws IOException {
        float size = arr.size();
        float negativo = 0, neutro = 0, positivo = 0;

        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 0; i < size; i++) {
            if (arr.get(i) > 0) {
                positivo = positivo + 1;
            } else if (arr.get(i) < 0) {
                negativo = negativo + 1;
            } else {
                neutro++;
            }
        }

        String percentualPositivo = formatarValor(positivo, size);
        String percentualNeutro = formatarValor(neutro, size);
        String percentualNegativo = formatarValor(negativo, size);

        List<String> result = List.of(percentualPositivo, percentualNegativo, percentualNeutro);

        for(String value : result){

            bufferedWriter.write(value);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
    }

    private static String formatarValor(float valor, float size) {
        DecimalFormat formatador = new DecimalFormat("0.000000");
        return formatador.format(valor / size);
    }

}

public class PlusMinus {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result2.plusMinus(arr);

        bufferedReader.close();
    }
}


//O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
//O percentual
//Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
//primeiro o tamanho do array em seguida os elementos
//Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
//Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
//O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
//Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
//Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.