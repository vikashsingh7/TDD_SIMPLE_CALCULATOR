package calculatorPackage;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String numbers){

        String[] numberArray;
        if(numbers.isEmpty()){
            return 0;
        }
        else if(numbers.contains("\n")){
            numbers = replaceSymbolsFromString(numbers,"\n",",");
        }
        else if(numbers.contains(" ")){
            numbers = replaceSymbolsFromString(numbers," ","");
        }
        else if(!numbers.contains(",")){
            try{
                return Integer.parseInt(numbers);
            }
            catch(Exception e){
                System.out.println("Some Other Symbol Present");
            }
        }
        numberArray = splitNumbers(numbers,",");
        return add(numberArray);
    }

    private static String replaceSymbolsFromString(String text, String fromSymbol, String toSymbol){
        if(text.contains(fromSymbol)){
            text = text.replaceAll(fromSymbol, toSymbol);
        }
        return text;
    }

    private static int add(String textArray[]){
        int result=0;
        for (String item: textArray) {
            if(!item.isEmpty()) {
                result += Integer.parseInt(item);
            }
        }
        return result;
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split(divider);
    }
}
