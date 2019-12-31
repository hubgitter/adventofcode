package test.java.domain;

import main.java.domain.ComputerPhase;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerPhaseTest {
    @Test
    public void testExecution1() {
        List<Long> phaseSetting = Arrays.asList(4L,3L,2L,1L,0L);
        List<Long> memory = Arrays.asList(3L,15L,3L,16L,1002L,16L,10L,16L,1L,16L,15L,15L,4L,15L,99L,0L,0L);
        ComputerPhase computerPhase = new ComputerPhase(memory, phaseSetting);
        assertEquals(43210L, computerPhase.getResult());
    }
    @Test
    public void testExecution2() {
        List<Long> phaseSetting = Arrays.asList(0L,1L,2L,3L,4L);
        List<Long> memory =
                Arrays.asList(
                        3L,23L,3L,24L,1002L,24L,10L,24L,1002L,23L,-1L,23L,101L,5L,23L,23L,1L,24L,23L,23L,4L,23L,99L,0L,0L);
        ComputerPhase computerPhase = new ComputerPhase(memory, phaseSetting);
        assertEquals(54321L, computerPhase.getResult());
    }
    @Test
    public void testExecution3() {
        List<Long> phaseSetting = Arrays.asList(1L,0L,4L,3L,2L);
        List<Long> memory =
                Arrays.asList(
                        3L,31L,3L,32L,1002L,32L,10L,32L,1001L,31L,-2L,31L,1007L,31L,0L,33L,
                        1002L,33L,7L,33L,1L,33L,31L,31L,1L,32L,31L,31L,4L,31L,99L,0L,0L,0L);
        ComputerPhase computerPhase = new ComputerPhase(memory, phaseSetting);
        assertEquals(65210L, computerPhase.getResult());
    }

}
