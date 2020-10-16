package calculatorPackage;

import customException.InvalidNumberException;

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
            try{
                return add(numberArray);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        return -1;  //Return -1 in case any Exception Occurs
    }

//    private static String replaceSymbolsFromString(String text, String fromSymbol, String toSymbol){
//        if(text.contains(fromSymbol)){
//            text = text.replaceAll(fromSymbol, toSymbol);
//        }
//        return text;
//    }

    private static int add(String textArray[]) throws InvalidNumberException {
        int result=0;
        for (String item: textArray) {
            if(!item.isEmpty()) {
                if(item.contains("-")){
                    String negativeNumber = item.substring(item.indexOf('-'));
                    throw new InvalidNumberException("Negatives Not Allowed: " + negativeNumber);
                }
                result += Integer.parseInt(item);
            }
        }
        return result;
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split("[\n" + divider + "]");
    }
}
