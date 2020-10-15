package calculatorPackage;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }

    @Test
    public void shouldReturnNumberOnSingleDigit(){
        assertEquals(7, StringCalculator.add("7"));
        assertEquals(789, StringCalculator.add("7 8 9"));
        assertEquals(789, StringCalculator.add("789"));
    }

    @Test
    public void shouldAddNumbersIfDelimiterPresent(){
        assertEquals(50, StringCalculator.add("10,40"));
        assertEquals(100, StringCalculator.add("1,99"));
    }

    @Test
    public void shouldHandleUnknownAmountOfNumbers(){
        assertEquals(999999999, StringCalculator.add("999999999"));
        assertEquals(999999999, StringCalculator.add("931531511,68468488"));
        assertEquals(444, StringCalculator.add("93,68,99,151,33"));
        assertEquals(7100, StringCalculator.add("9,37,6,87,6873,6,8,14,60"));
        assertEquals(98683, StringCalculator.add("9,37,6,87,6873,6,8,14,60,45,4,23,2345,34,3434,85667,6,22,3"));
    }

}
