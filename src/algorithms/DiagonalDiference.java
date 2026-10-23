package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result1 {

    /*
     * Complete the 'diagonalDifference' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY arr as parameter.
     */

    public static int diagonalDifference(List<List<Integer>> arr) {
        int tamanho = arr.size();
        int pDiagonal = 0, sDiagonal = 0;
        int i = 0;
        while (i < tamanho) {
            int j = tamanho - 1;

            pDiagonal = pDiagonal + arr.get(i).get(i);
            sDiagonal = sDiagonal + arr.get(i).get(j - i);

            i++;
        }
        return Math.abs(pDiagonal - sDiagonal);
    }

}

public class DiagonalDiference {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result1.diagonalDifference(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

//        Qual objetivo?
//        Somar os valores de determinadas posições na matriz
//
//        Foi necessário dividir em duas variáveis: a primeira soma os valores conforme
//        a iteração avança; a segunda percorre o array de trás para frente, usando o
//        tamanho do array menos 1 e decrementando a cada iteração.
