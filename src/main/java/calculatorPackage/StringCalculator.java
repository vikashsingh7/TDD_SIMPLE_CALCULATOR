package calculatorPackage;

import org.apache.commons.lang3.StringUtils;
import customException.InvalidNumberException;

public class StringCalculator {

    static int CALLED_COUNT = 0;
    public static int add(String numbers){

        CALLED_COUNT++;
        String[] numberArray;
        String delimiter = ","; //Setting Comma as the Default Delimiter unless user changes it.
        if(numbers.isEmpty()){
            return 0;
        }
        else{
            numbers = numbers.replaceAll(" ","");   //Replacing Blank Spaces
            if(numbers.startsWith("//")){
                int totalDelimiters = StringUtils.countMatches(numbers, "[");
                for(int i=0;i<totalDelimiters;i++){
                    delimiter += numbers.substring(numbers.indexOf('[')+1,numbers.indexOf(']'));
                    numbers = numbers.substring(numbers.indexOf("]")+1);
                }
                if(delimiter.length()==1 || totalDelimiters == 0){
                    delimiter = Character.toString(numbers.charAt(2));
                }
                numbers = numbers.substring(numbers.indexOf("\n")+1);
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

    private static int add(String[] textArray) throws InvalidNumberException {
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
                else if(Integer.parseInt(item)>1000){
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

    public int getCalledCount(){
        return CALLED_COUNT;
    }

    private static String[] splitNumbers(String text, String divider){
        return text.split("[\n" + divider + "]");
    }
}
