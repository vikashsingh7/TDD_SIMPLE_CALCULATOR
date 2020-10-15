package calculatorPackage;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        else if(numbers.contains(",")){
            String[] numberArray = splitNumbers(numbers,",");
            int result=0;
            for (String item: numberArray) {
                result += Integer.parseInt(item);
            }
            return result;
        }
        else{
            return fetchNumbersFromString(numbers);
        }
    }

    private static int fetchNumbersFromString(String text){
        if(text.contains(" ")){
            text = text.replaceAll(" ","");
        }
        return Integer.parseInt(text);
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split(divider);
    }
}
