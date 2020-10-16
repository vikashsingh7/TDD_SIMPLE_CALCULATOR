package calculatorTestPackage;

import calculatorPackage.StringCalculator;
import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnSingleDigit(){
        assertEquals(7, StringCalculator.add("7"));
        assertEquals(789, StringCalculator.add("7 8 9"));   // Check if the program is able to handle spaces in input
        assertEquals(789, StringCalculator.add("789"));
    }

    @Test
    public void shouldAddNumbersIfDelimiterPresent(){
        assertEquals(50, StringCalculator.add("10,40"));
        assertEquals(100, StringCalculator.add("1,99"));
    }

    @Test
    public void shouldHandleUnknownAmountOfNumbers(){
        assertEquals(444, StringCalculator.add("93,68,99,151,33"));
        assertEquals(1100, StringCalculator.add("9,37,6,87,873,6,8,14,60"));
        assertEquals(1237, StringCalculator.add("9,37,6,87,873,6,8,14,60,45,4,23,2345,34,3434,85667,6,22,3"));
    }

    @Test
    public void shouldRecognizeNewlines(){
        assertEquals(6,StringCalculator.add("1\n2,3"));
        assertEquals(597,StringCalculator.add("\n\n231\n22\n344"));

    }

    @Test
    public void shouldSupportDifferentDelimiters(){
        assertEquals(3,StringCalculator.add("//;\n1;2"));
        assertEquals(3,StringCalculator.add("//!\n1!1!1"));
    }

    @Test
    public void shouldThrowExceptionOnNegativeNumbers(){
        assertEquals(-1,StringCalculator.add("2,-145"));
        assertEquals(-1,StringCalculator.add("-142,145"));
        assertEquals(-1,StringCalculator.add("-12,-1,45"));
        assertEquals(-1,StringCalculator.add("//;\n1;-2"));
    }

    @Test
    public void shouldHandleMultipleNegativeNumbers(){
        assertEquals(-1,StringCalculator.add("-12,-1,45"));
        assertEquals(-1,StringCalculator.add("-2,-1,-5"));
        assertEquals(-1,StringCalculator.add("2,-1,-5"));
        assertEquals(-1,StringCalculator.add("//!\n-1!1!-1"));
    }

    @Test
    public void shouldReturnCalledCount(){
        StringCalculator stringCalculator = new StringCalculator();
        assertEquals(0,stringCalculator.getCalledCount());
        assertEquals(-1,StringCalculator.add("-12,-1,45"));
        assertEquals(1,stringCalculator.getCalledCount());
        assertEquals(444, StringCalculator.add("93,68,99,151,33"));
        assertEquals(1100, StringCalculator.add("9,37,6,87,873,6,8,14,60"));
        assertEquals(3,stringCalculator.getCalledCount());
    }

    @Test
    public void shouldNotAddNumbersGreaterThan1000(){
        assertEquals(0, StringCalculator.add("999999999"));
        assertEquals(0, StringCalculator.add("931531511,68468488"));
        assertEquals(68, StringCalculator.add("931531511,68"));
        assertEquals(44, StringCalculator.add("44,684684,1288,1001"));
        assertEquals(1237, StringCalculator.add("9,37,6,87,873,6,8,14,60,45,4,23,2345,34,3434,85667,6,22,3"));
    }
}
