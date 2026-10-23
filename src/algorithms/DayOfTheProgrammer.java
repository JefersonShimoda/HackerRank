package algorithms;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result15 {

    /*
     * Complete the 'dayOfProgrammer' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER year as parameter.
     */

    public static String dayOfProgrammer(int year) {
        // Write your code here
        boolean isBissexto = false;
        int days = 256;
        if (year >= 1700 && year <= 1917) {
            if (year % 4 == 0) {
                isBissexto = true;
            }
        } else if (year == 1918) {
            days = days + 13;
        } else {
            if (year % 400 == 0 || (year % 4 ==0 && year % 100 > 0)) {
                isBissexto = true;
            }
        }
        int day = days - (isBissexto ? 244 : 243);
        return (day + ".09." + year);
    }

}

public class DayOfTheProgrammer {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result15.dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
