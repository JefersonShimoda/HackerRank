package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result17 {

    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        ArrayList<String> isPair = new ArrayList<>();
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!used[i]) {
                int element = ar.get(i);
                for (int j = i + 1; j < n; j++) {
                    if (!used[j]) {
                        if (element == ar.get(j)) {
                            isPair.add(String.valueOf(i) + "," + String.valueOf(j) + ": " + ar.get(j));
                            used[i] = true;
                            used[j] = true;
                            break;
                        }
                    }

                }
            }

        }

        return isPair.size();
    }
}

public class SalesByMatch {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result17.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
