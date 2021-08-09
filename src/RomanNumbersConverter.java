public class RomanNumbersConverter {
    public static int getArabicNumber(String romanNumber){
        switch (romanNumber){
            case "I":{
                return 1;
            }
            case "II":{
                return 2;
            }
            case "III":{
                return 3;
            }
            case "IV":{
                return 4;
            }
            case "V":{
                return 5;
            }
            case "VI":{
                return 6;
            }
            case "VII":{
                return 7;
            }
            case "VIII":{
                return 8;
            }
            case "IX":{
                return 9;
            }
            case "X":{
                return 10;
            }
            default:{
                return -1;
            }
        }
    }

    public static String getRomanNumber(int arabicNumber){
        String[] romanNumbers = new String[]{
                "-", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
                "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX",
                "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L",
                "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };

        if (arabicNumber > 0 && arabicNumber <= 100){
            return romanNumbers[arabicNumber];
        } else {
            return "";
        }
    }
}
