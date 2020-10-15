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
}
