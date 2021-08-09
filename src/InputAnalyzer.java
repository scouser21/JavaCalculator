import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputAnalyzer {
    String input;
    int operationCode; // 0:+  1:-  2:*  3:/
    int operand1;
    int operand2;
    String status;
    String resultOfOperation;

    public InputAnalyzer(String s){
        input = s;
        status = analyzeInput();
    }

    private String analyzeInput(){
        String localInput = input;

        Pattern patternArabic = Pattern.compile("\\d{1,2}\\s[+-/*]\\s\\d{1,2}");
        Pattern patternRoman = Pattern.compile("[IVX]{1,4}\\s[+-/*]\\s[IVX]{1,4}");
        boolean flagArabic = false;
        boolean flagRoman = false;

        Matcher matcher = patternArabic.matcher(localInput);

        while (matcher.find()) {
            if (matcher.start()==0 && matcher.end()==localInput.length())
                flagArabic = true;
        }

        matcher = patternRoman.matcher(localInput);

        while (matcher.find()) {
            if (matcher.start()==0 && matcher.end()==localInput.length())
                flagRoman = true;
        }

        if (flagArabic || flagRoman){
            if (localInput.contains("+"))
                operationCode = 0;
            if (localInput.contains("-"))
                operationCode = 1;
            if (localInput.contains("*"))
                operationCode = 2;
            if (localInput.contains("/"))
                operationCode = 3;
        } else {
            return "Ошибка в написании команды";
        }

        localInput = localInput.replace("+", "&")
                .replace("-", "&")
                .replace("*", "&")
                .replace("/", "&");

        if (flagArabic){
            operand1 = Integer.parseInt(localInput.split("&")[0].trim());
            if (operand1 < 1 || operand1 > 10){
                return "Ошибка в первом операнде";
            }

            operand2 = Integer.parseInt(localInput.split("&")[1].trim());
            if (operand2 < 1 || operand2 > 10){
                return "Ошибка во втором операнде";
            }

            switch (operationCode){
                case 0:{
                    resultOfOperation = String.valueOf(operand1 + operand2);
                    break;
                }
                case 1:{
                    resultOfOperation = String.valueOf(operand1 - operand2);
                    break;
                }
                case 2:{
                    resultOfOperation = String.valueOf(operand1 * operand2);
                    break;
                }
                case 3:{
                    resultOfOperation = String.valueOf(operand1 / operand2);
                    break;
                }
                default:{
                    resultOfOperation = "";
                }
            }
        }

        if (flagRoman){
            operand1 = RomanNumbersConverter.getArabicNumber(localInput.split("&")[0].trim());
            if (operand1 == -1){
                return "Ошибка в первом операнде";
            }

            operand2 = RomanNumbersConverter.getArabicNumber(localInput.split("&")[1].trim());
            if (operand2 == -1){
                return "Ошибка во втором операнде";
            }

            switch (operationCode){
                case 0:{
                    resultOfOperation = RomanNumbersConverter.getRomanNumber(operand1 + operand2);
                    break;
                }
                case 1:{
                    resultOfOperation = RomanNumbersConverter.getRomanNumber(operand1 - operand2);
                    break;
                }
                case 2:{
                    resultOfOperation = RomanNumbersConverter.getRomanNumber(operand1 * operand2);
                    break;
                }
                case 3:{
                    resultOfOperation = RomanNumbersConverter.getRomanNumber(operand1 / operand2);
                    break;
                }
                default:{
                    resultOfOperation = "";
                }
            }

            if (resultOfOperation.equals("")){
                return "Результат <= 0, а введены римские цифры";
            }
        }

        return "OK";
    }
}





