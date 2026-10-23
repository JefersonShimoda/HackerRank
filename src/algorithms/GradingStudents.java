package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result7 {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {

        for (int i = 0; i < grades.size(); i++) {
            if (!(grades.get(i) < 38)) {
                int mod = grades.get(i) % 5;
                if (mod >= 3) {
                    int diff5 = 5 - mod;
                    grades.set(i, grades.get(i)+diff5);
                }
            }
        }

    return grades;
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine().replaceAll("\\s+$", "");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result7.gradingStudents(grades);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * A nota com arredondamento, seguindo as regras
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * as notas como inteiro
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * vê o proximo numero multiplo de 5 e se a diferença é menor que 3
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * encontrar o mod, e a partir dai difinir a diferença
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */