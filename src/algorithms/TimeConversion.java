package algorithms;

import java.io.*;

import static java.util.stream.Collectors.joining;

class Result6 {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
        if (s.contains("AM")) {
            String onlyNumber = s.replace("AM", "");
            String oNumber = onlyNumber.substring(0,2);
            if (oNumber.equals("12")) {
                String hour = "00";
                return onlyNumber.replace(oNumber, hour);
            }
            return onlyNumber;
        } else if (s.contains("PM")) {
            String onlyNumber = s.replace("PM", "");
            String oNumber = onlyNumber.substring(0, 2);
            String hour = String.valueOf(Integer.parseInt(oNumber) + (Integer.parseInt(oNumber) == 12 ? +0 : +12));
            return onlyNumber.replace(oNumber, hour);
        }
        return s;
    }
}

public class TimeConversion {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result6.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

/**
 * O que preciso encontrar? — Defina exatamente qual resposta o problema pede.
 * preciso encontrar o equavalente em formato 24hrs.
 * Quais são as entradas e restrições? — Saiba quais dados recebe e quais são seus limites.
 * horario em formato 12 hrs.
 * Como resolveria manualmente? — Imagine como resolveria um exemplo pequeno sem pensar em programação.
 * Qual é a solução mais simples? — Encontre uma forma direta de testar as possibilidades, mesmo que seja lenta.
 * O que posso melhorar? — Procure operações repetidas ou desnecessárias que podem ser evitadas.
 * Qual estrutura/estratégia usar? — Escolha a estrutura de dados ou técnica que torna a solução eficiente.
 * se for am retorna somente os numeros, se for pm soma 12.
 * Funciona em todos os casos? — Teste sua lógica com casos normais e extremos.
 */