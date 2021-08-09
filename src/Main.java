import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        System.out.print("Введите операцию: ");
        try {
            input = reader.readLine().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        InputAnalyzer inputAnalyzer = new InputAnalyzer(input);

        if (inputAnalyzer.status.equals("OK")){
            System.out.println("Результат операции = " + inputAnalyzer.resultOfOperation);
        } else {
            throw new Exception(inputAnalyzer.status);
        }

    }
}
