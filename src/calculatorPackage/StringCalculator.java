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
        boolean negativeFlag = false;
        StringBuilder negativeNumber = new StringBuilder();
        for (String item: textArray) {
            if(!item.isEmpty()) {
                if(item.contains("-")){
                    negativeFlag = true;
                    negativeNumber.append(item.substring(item.indexOf('-'))).append(",");
                    continue;
                }
                result += Integer.parseInt(item);
            }
        }
        if(negativeFlag){
            throw new InvalidNumberException("Negatives Not Allowed: " + negativeNumber.toString().replaceFirst(".$",""));
        }
        return result;
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split("[\n" + divider + "]");
    }
}
