package algorithms;

import java.io.*;
import java.util.Arrays;


class Result3 {

    /*
     * Complete the 'staircase' function below.
     *
     * The function accepts INTEGER n as parameter.
     */

    public static void staircase(int n) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                char[] arrayDeAs = new char[n - i - 1];
                Arrays.fill(arrayDeAs, ' ');
                String espacos = new String(arrayDeAs);
                bufferedWriter.write(j == 0 ? espacos + "#" : "#");
                if (i == j) {
                    bufferedWriter.newLine();

                }
            }
        }
        bufferedWriter.close();
    }
}

public class Staircase {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        Result3.staircase(n);

        bufferedReader.close();
    }
}

/**
 * O que preciso fazer? — Defina exatamente qual resposta o problema pede.
 * inserir um caractere #, logo apos, dois um acima do outro e assim sucessivamente
 * #
 * ##
 * ###
 * ####
 * #####
 * ######
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * um unico variavel inteiro, que definira o tamanho da escada
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 **/