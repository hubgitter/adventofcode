package test.java.maths;

import main.java.transform.CollectionTransformer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathsTest {

    @Test
    public void testFuelCalculationsMatchSpecification(){
        assertEquals(CollectionTransformer.addLongs(Arrays.asList(1L,2L)),3L);
    }
}
