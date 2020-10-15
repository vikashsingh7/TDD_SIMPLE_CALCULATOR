package calculatorPackage;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String numbers){
        if(numbers.isEmpty()){
            return 0;
        }
        else{
            return fetchNumbersFromString(numbers);
        }
    }

    public static int fetchNumbersFromString(String text){
        if(text.contains(" ")){
            text = text.replaceAll(" ","");
        }
        return Integer.parseInt(text);
    }
}
