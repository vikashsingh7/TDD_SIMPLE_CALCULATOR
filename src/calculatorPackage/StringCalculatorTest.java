package calculatorPackage;

import org.junit.Test;
import static org.junit.Assert.*;

public class StringCalculatorTest {

    @Test
    public void shouldReturnZeroOnEmptyString(){
        assertEquals(0,StringCalculator.add(""));
    }
}
