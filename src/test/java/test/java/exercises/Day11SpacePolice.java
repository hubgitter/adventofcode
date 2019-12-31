package test.java.exercises;

import main.java.domain.Computer;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day11SpacePolice {

    @Test
    public void part1() throws Exception {
        List<Long> digits = getDigits();
        Computer computer = new Computer(digits, Collections.singletonList(1L));
        Long x = computer.execute();
    }
    private List<Long> getDigits() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day11SpacePolice.class);
        final String delimiter = ",";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }
}
