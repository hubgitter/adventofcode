package test.java.exercises;

import main.java.domain.Computer;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day5SunnyWithAsteroids {



    @Test
    public void part1() throws Exception {
        Computer computer = new Computer(getCodes(), Collections.singletonList(1L));
        computer.addInput(1L);
        Long x = computer.execute();
        assertEquals(x, 10987514L);

    }
    @Test
    public void part2() throws Exception {

        Computer computer = new Computer(getCodes(), Collections.singletonList(5L));
        Long x = computer.execute();
        assertEquals(14195011L, x);

    }

    private List<Long> getCodes() throws Exception{

        List<String> lineItems = Arrays.asList(getLines().get(0).split(","));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }

    private List<String> getLines() throws Exception{
        final String EXERCISE_INPUT = ResourceLocator.getExerciseInputFile(Day5SunnyWithAsteroids.class);
        try( Stream<String> lines = Files.lines(Paths.get(EXERCISE_INPUT))){
            return lines.collect(Collectors.toList());
        }
    }


}
