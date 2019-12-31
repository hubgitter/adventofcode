package test.java.domain;

import main.java.domain.Computer;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComputerTest {


    @Test
    public void day2part1Introduction() {
        List<Long> memory = Arrays.asList(1L, 9L, 10L, 3L, 2L, 3L, 11L, 0L, 99L, 30L, 40L, 50L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(3500L,9L,10L,70L,
                2L,3L,11L,0L,
                99L,
                30L,40L,50L),computer.getMemoryAsList());
    }
    @Test
    public void day2part1SmallProgram1() {
        List<Long> memory = Arrays.asList(1L,0L,0L,0L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        Collection<Long> x = computer.getMemoryAsList();
        assertEquals(Arrays.asList(2L,0L,0L,0L,99L), x);
    }
    @Test
    public void day2part1SmallProgram2() {
        List<Long> memory = Arrays.asList(2L,3L,0L,3L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(2L,3L,0L,6L,99L),computer.getMemoryAsList());
    }
    @Test
    public void tday2part1SmallProgram3() {
        List<Long> memory = Arrays.asList(2L,4L,4L,5L,99L,0L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(2L,4L,4L,5L,99L,9801L),computer.getMemoryAsList());
    }
    @Test
    public void day2part1SmallProgram4() {
        List<Long> memory = Arrays.asList(1L,1L,1L,4L,99L,5L,6L,0L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(30L,1L,1L,4L,2L,5L,6L,0L,99L), computer.getMemoryAsList());
    }
    @Test
    public void testExecution6() {
        List<Long> memory = Arrays.asList(1002L,4L,3L,4L,33L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(1002L,4L,3L,4L,99L), computer.getMemoryAsList());
    }
    @Test
    public void testExecution7() {
        List<Long> memory = Arrays.asList( 3L,2L,50L);
        Computer computer = new Computer(memory, Collections.singletonList(9L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,2L,9L), computer.getMemoryAsList());
    }

    @Test
    public void testExecutionPositionEqual8Output1() {
        List<Long> memory = Arrays.asList( 3L,9L,8L,9L,10L,9L,4L,9L,99L,-1L,8L);
        Computer computer = new Computer(memory, Collections.singletonList(8L));
        computer.execute();
        assertEquals(Arrays.asList(  3L,9L,8L,9L,10L,9L,4L,9L,99L,1L,8L), computer.getMemoryAsList());
    }
    @Test
    public void testExecutionPositionNotEqual8Output0() {
        List<Long> memory = Arrays.asList( 3L,9L,8L,9L,10L,9L,4L,9L,99L,-1L,8L);
        Computer computer = new Computer(memory, Collections.singletonList(7L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,9L,8L,9L,10L,9L,4L,9L,99L,0L,8L), computer.getMemoryAsList());
    }

    @Test
    public void testExecutionPositionLessThan8Output1() {
        List<Long> memory = Arrays.asList( 3L,9L,7L,9L,10L,9L,4L,9L,99L,-1L,8L);
        Computer computer = new Computer(memory, Collections.singletonList(7L));
        computer.execute();
        assertEquals(Arrays.asList(  3L,9L,7L,9L,10L,9L,4L,9L,99L,1L,8L), computer.getMemoryAsList());
    }

    @Test
    public void testExecutionPositionGreaterOrEqualTo8Output0() {
        List<Long> memory = Arrays.asList( 3L,9L,7L,9L,10L,9L,4L,9L,99L,-1L,8L);
        Computer computer = new Computer(memory, Collections.singletonList(8L));
        computer.execute();
        assertEquals(Arrays.asList(  3L,9L,7L,9L,10L,9L,4L,9L,99L,0L,8L), computer.getMemoryAsList());
    }
    @Test
    public void testImmediateExecutionEqual8Output1() {
        List<Long> memory = Arrays.asList(3L,3L,1108L,-1L,8L,3L,4L,3L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(8L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,3L,1108L,1L,8L,3L,4L,3L,99L), computer.getMemoryAsList());
    }
    @Test
    public void testImmediateExecutionNotEqual8Output0() {
        List<Long> memory = Arrays.asList(3L,3L,1108L,-1L,8L,3L,4L,3L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(7L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,3L,1108L,0L,8L,3L,4L,3L,99L), computer.getMemoryAsList());
    }
    @Test
    public void testExecutionImmediateLessThan8Output1() {
        List<Long> memory = Arrays.asList(3L,3L,1107L,-1L,8L,3L,4L,3L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(6L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,3L,1107L,1L,8L,3L,4L,3L,99L), computer.getMemoryAsList());
    }

    @Test
    public void testExecutionImmediateNotLessThan8Output0() {
        List<Long> memory = Arrays.asList(3L,3L,1107L,-1L,8L,3L,4L,3L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(9L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,3L,1107L,0L,8L,3L,4L,3L,99L), computer.getMemoryAsList());
    }
    @Test
    public void testExecutionPositionInputZeroOutputZero() {
        List<Long> memory = Arrays.asList(3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,-1L,0L,1L,9L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,0L,0L,1L,9L), computer.getMemoryAsList());
    }
    @Test
    public void testExecutionPositionInputNotZeroOutputOne() {
        List<Long> memory = Arrays.asList(3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,-1L,0L,1L,9L);
        Computer computer = new Computer(memory, Collections.singletonList(30L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,30L,1L,1L,9L), computer.getMemoryAsList());
    }
    @Test
    public void testExecution13() {
        List<Long> memory = Arrays.asList(3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,-1L,0L,1L,9L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList( 3L,12L,6L,12L,15L,1L,13L,14L,13L,4L,13L,99L,0L,0L,1L,9L), computer.getMemoryAsList());
    }
    @Test
    public void testExecution14() {
        List<Long> memory = Arrays.asList(3L,3L,1105L,-1L,9L,1101L,0L,0L,12L,4L,12L,99L,1L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(3L,3L,1105L,0L,9L,1101L,0L,0L,12L,4L,12L,99L,0L), computer.getMemoryAsList());
    }
    @Test
    public void testExecution15() {
        List<Long> memory = Arrays.asList(3L,21L,1008L,21L,8L,20L,1005L,20L,22L,107L,8L,21L,20L,1006L,20L,31L,
                1106L,0L,36L,98L,0L,0L,1002L,21L,125L,20L,4L,20L,1105L,1L,46L,104L,
                999L,1105L,1L,46L,1101L,1000L,1L,20L,4L,20L,1105L,1L,46L,98L,99L);
        Computer computer = new Computer(memory, Collections.singletonList(0L));
        computer.execute();
        assertEquals(Arrays.asList(  3L,21L,1008L,21L,8L,20L,1005L,20L,22L,107L,8L,21L,20L,1006L,20L,31L,
                1106L,0L,36L,98L,0L,0L,1002L,21L,125L,20L,4L,20L,1105L,1L,46L,104L,
                999L,1105L,1L,46L,1101L,1000L,1L,20L,4L,20L,1105L,1L,46L,98L,99L), computer.getMemoryAsList());
    }
}

