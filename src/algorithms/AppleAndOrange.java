package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result8 {

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int appleInHome = 0, orangeInHome = 0, m = apples.size(), n = oranges.size();

//            List<Integer> eachApple = new ArrayList<>();
        for (int i = 0; i < m; i++) {
//                eachApple.add(a + apples.get(i));
            if (estaNoRange(s, t, a + apples.get(i))) {
                appleInHome++;
            }
        }

//            List<Integer> eachOrange = new ArrayList<>();
        for (int i = 0; i < n; i++) {
//                eachOrange.add(b + oranges.get(i));
            if (estaNoRange(s, t, b + oranges.get(i))) {
                orangeInHome++;
            }
        }


        bufferedWriter.write(String.valueOf(appleInHome));
        bufferedWriter.newLine();
        bufferedWriter.write(String.valueOf(orangeInHome));

        bufferedWriter.close();
    }

    public static boolean estaNoRange(int s, int t, int posicao) {
        return posicao >= s && posicao <= t;
    }
}

public class AppleAndOrange {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int s = Integer.parseInt(firstMultipleInput[0]);

        int t = Integer.parseInt(firstMultipleInput[1]);

        String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int a = Integer.parseInt(secondMultipleInput[0]);

        int b = Integer.parseInt(secondMultipleInput[1]);

        String[] thirdMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(thirdMultipleInput[0]);

        int n = Integer.parseInt(thirdMultipleInput[1]);

        List<Integer> apples = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> oranges = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        Result8.countApplesAndOranges(s, t, a, b, apples, oranges);

        bufferedReader.close();
    }
}
