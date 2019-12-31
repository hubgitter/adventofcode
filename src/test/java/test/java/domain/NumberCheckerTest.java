package test.java.domain;

import main.java.domain.NumberChecker;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumberCheckerTest {
    @Test
    public void testPart1Spec(){

        assertEquals(new NumberChecker().isValidPassword(11111L, false),true);
        assertEquals(new NumberChecker().isValidPassword(2234500L,false),false);
        assertEquals(new NumberChecker().isValidPassword(123789L,false),false);


    }

    @Test
    public void testPart2Spec(){

        assertEquals(new NumberChecker().isValidPassword(112233L,true),true);
        assertEquals(new NumberChecker().isValidPassword(123444L,true),false);
        assertEquals(new NumberChecker().isValidPassword(111122L,true),true);
    }

    @Test
    public void testGetCodes(){

        assertEquals(new NumberChecker().getCodes(1L,2L,2L),
                Arrays.asList(Arrays.asList(1L,2L),Arrays.asList(2L,1L)));
    }
}
