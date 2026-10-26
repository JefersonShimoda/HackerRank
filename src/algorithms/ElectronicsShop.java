package algorithms;

import java.io.*;
import java.util.*;

public class ElectronicsShop {

    /*
     * Complete the getMoneySpent function below.
     */
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int lastValue = 0;

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                int total = keyboards[i] + drives[j];
                if (total == b) {
                    return b;
                } else if (b > total && b - total < b - lastValue) {
                    lastValue = total;
                }
            }
        }

        return lastValue > 0 ? lastValue : -1;

//        /*
//         * Write your code here.
//         */
//        ArrayList<Integer> totals = new ArrayList<>();
//        ArrayList<Integer> falta = new ArrayList<>();
//        int increase = 0;
//        int index = 0;
//        int count = 0;
//        for (int i = 0; i < keyboards.length; i++) {
//            for (int j = 0; j < drives.length; j++) {
//                totals.add(keyboards[i] + drives[j]);
//            }
//        }
//        for (int i = 0; i < totals.size(); i++) {
//            if (totals.get(i) == b) {
//                return b;
//            } else {
//                falta.add(totals.get(i) - b);
//            }
//        }
//        for (int i = 0; i < falta.size(); i++) {
//            if (i == 0) {
//                if (falta.get(i) < 0) {
//                    increase = falta.get(i);
//                } else {
//                    count++;
//                }
//
//            } else {
//                if (falta.get(i) > increase) {
//                    if (falta.get(i) < 0) {
//                        increase = falta.get(i);
//                        index = i;
//                    } else {
//                        count++;
//                    }
//                }
//            }
//        }
//
//        if (count == totals.size()) {
//            return -1;
//        }
//
//        return totals.get(index);
    }


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] bnm = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int b = Integer.parseInt(bnm[0]);

        int n = Integer.parseInt(bnm[1]);

        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];

        String[] keyboardsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int keyboardsItr = 0; keyboardsItr < n; keyboardsItr++) {
            int keyboardsItem = Integer.parseInt(keyboardsItems[keyboardsItr]);
            keyboards[keyboardsItr] = keyboardsItem;
        }

        int[] drives = new int[m];

        String[] drivesItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        for (int drivesItr = 0; drivesItr < m; drivesItr++) {
            int drivesItem = Integer.parseInt(drivesItems[drivesItr]);
            drives[drivesItr] = drivesItem;
        }

        /*
         * The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
         */

        int moneySpent = getMoneySpent(keyboards, drives, b);

        bufferedWriter.write(String.valueOf(moneySpent));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
