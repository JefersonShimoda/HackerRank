package algorithms;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

class Result19 {

    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int countE = 0, tempValley = 0, countTotal = 0;
        for (int i = 0; i < steps; i++) {
            if (path.charAt(i) == 'U') {
                countE++;

                if (tempValley == 1) {
                    countTotal++;
                    tempValley = 0;
                }

            } else {
                countE--;

                if (countE == -1) {
                    tempValley++;

                }
            }
        }
        return countTotal;
    }
}

public class CountingValleys {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result19.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
