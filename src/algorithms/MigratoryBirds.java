package algorithms;

import java.io.*;
import java.util.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result14 {

    /*
     * Complete the 'migratoryBirds' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int migratoryBirds(List<Integer> arr) {
        List<Integer> elementos = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));
        int bigger = elementos.get(0), index = 0;
        for (int i = 0; i < arr.size(); i++) {
            switch (arr.get(i)) {
                case 1:
                    elementos.set(1, elementos.get(1) + 1);
                    break;
                case 2:
                    elementos.set(2, elementos.get(2) + 1);
                    break;
                case 3:
                    elementos.set(3, elementos.get(3) + 1);
                    break;
                case 4:
                    elementos.set(4, elementos.get(4) + 1);
                    break;
                case 5:
                    elementos.set(5, elementos.get(5) + 1);
                    break;
            }
        }

        for (int j = 1; j < elementos.size(); j++) {
            if (bigger < elementos.get(j)) {
                bigger = elementos.get(j);
                index = j;
            }

        }

        return index;
    }

}

public class MigratoryBirds {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result14.migratoryBirds(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
