package test.java.exercises;

import main.java.domain.Computer;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day9SensorBoost {

    private static final Logger LOGGER = LogManager.getLogger(Day9SensorBoost.class);

    @Test
    public void part1() throws Exception {
        List<Long> digits = getDigits();
        Computer computer = new Computer(digits, Collections.singletonList(1L));
        Long x = computer.execute();
        assertEquals(2870072642L,x );
    }

    @Test
    public void part2() throws Exception {
        List<Long> digits = getDigits();
        Computer computer = new Computer(digits, Collections.singletonList(2L));
        Long x = computer.execute();
        assertEquals(58534L,x );
    }
    private List<Long> getDigits() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day9SensorBoost.class);
        final String delimiter = ",";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }
}
