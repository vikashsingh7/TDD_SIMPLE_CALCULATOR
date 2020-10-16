package calculatorPackage;

import java.util.ArrayList;
import java.util.Arrays;

public class StringCalculator {

    public static int add(String numbers){

        String[] numberArray;
        String delimiter = ","; //Setting Comma as the Default Delimiter unless user changes it.
        if(numbers.isEmpty()){
            return 0;
        }
        else{
            numbers = numbers.replaceAll(" ","");   //Replacing Blank Spaces
            if(numbers.startsWith("//")){
                delimiter = Character.toString(numbers.charAt(2));
                numbers = numbers.substring(4);
            }
            numberArray = splitNumbers(numbers,delimiter);
            return add(numberArray);
        }
    }

//    private static String replaceSymbolsFromString(String text, String fromSymbol, String toSymbol){
//        if(text.contains(fromSymbol)){
//            text = text.replaceAll(fromSymbol, toSymbol);
//        }
//        return text;
//    }

    private static int add(String textArray[]){
        int result=0;
        for (String item: textArray) {
            if(!item.isEmpty()) {
                try {
                    result += Integer.parseInt(item);
                }
                catch (Exception e){
                    System.out.println("Illegal Symbol Present!");
                }
            }
        }
        return result;
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split("[\n" + divider + "]");
    }
}
