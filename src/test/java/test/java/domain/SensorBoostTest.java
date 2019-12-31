package test.java.domain;

import main.java.domain.Computer;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;
import test.java.exercises.Day9SensorBoost;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SensorBoostTest {

    @Test
    public void test1() {
        List<Long> codes = Arrays.asList(109L, 1L, 204L, -1L, 1001L, 100L, 1L, 100L, 1008L, 100L, 16L, 101L, 1006L, 101L, 0L, 99L);
        Computer computer = new Computer(codes, Collections.emptyList());
        Long result = computer.execute();
        assertEquals(99L, result);
        assertEquals(codes, computer.getOutput());
    }

    @Test
    public void test2() {
        List<Long> codes = Arrays.asList(1102L,34915192L,34915192L,7L,4L,7L,99L,0L);
        Computer computer = new Computer(codes, Collections.emptyList());
        assertEquals(1219070632396864L, computer.execute());
    }
    @Test
    public void test3() {
        List<Long> codes = Arrays.asList(104L,1125899906842624L,99L);
        Computer computer = new Computer(codes, Collections.emptyList());
        assertEquals(1125899906842624L, computer.execute());
    }

    @Test
    public void step1() throws Exception{
        Computer computer = new Computer(getDigits(), Collections.singletonList(1L));
        computer.tick();
        Long result = 34463338L*34463338L;
        assertEquals(result,computer.getMemoryAsList().get(63));
        assertEquals(4, computer.getBase());
        computer.tick();
        Map<Long,Long> map = computer.getMemoryAsMap();
        assertEquals(0, map.get(63L));
        assertEquals(8L, computer.getBase());
        computer.tick();
    }

    private List<Long> getDigits() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day9SensorBoost.class);
        final String delimiter = ",";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }
}
