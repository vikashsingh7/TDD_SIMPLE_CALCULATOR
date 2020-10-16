package calculatorPackage;

import java.util.ArrayList;

public class StringCalculator {

    public static int add(String numbers){

        String[] numberArray;
        String delimiter = ","; //Setting Comma as the Default Delimiter unless user changes it.
        if(numbers.isEmpty()){
            return 0;
        }
        if(numbers.contains("\n")){
            numbers = replaceSymbolsFromString(numbers,"\n",delimiter);
        }
        if(numbers.contains(" ")){
            numbers = replaceSymbolsFromString(numbers," ","");
        }
        if(numbers.startsWith("//")){
            delimiter = Character.toString(numbers.charAt(2));
            numbers = numbers.substring(4);
        }
        if(!numbers.contains(delimiter)){
            try{
                return Integer.parseInt(numbers);
            }
            catch(Exception e){
                System.out.println("Some Other Symbol Present");
            }
        }
        numberArray = splitNumbers(numbers,delimiter);
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
