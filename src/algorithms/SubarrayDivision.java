package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result12 {

    /*
     * Complete the 'birthday' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY s
     *  2. INTEGER d
     *  3. INTEGER m
     */

    public static int birthday(List<Integer> s, int d, int m) {
        int lenght = s.size(), elements = 0, count = 0;

         if ((d >= 1 && d <= 31) && (m >= 1 && m <= 12)) {
             for (int i = 0; i <= lenght - m; i++) {
                 elements = 0;
                 for (int j = i; j < i + m; j++) {
                     elements = elements + s.get(j);
                 }
                 if (elements == d) {
                     count++;
                 }
             }
         }
         return count;
    }
}

public class SubarrayDivision {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> s = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int d = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        int result = Result12.birthday(s, d, m);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 * i → define onde começa o segmento.
 * j → percorre os elementos desse segmento.
 * m → define quantos elementos serão somados.
 * elements → guarda a soma do segmento atual.
 * count → conta quantos segmentos têm soma d.
 * o primeiro for move uma janela pela lista, e o segundo soma os m elementos daquela janela.
 */