package test.java.exercises;

import main.java.domain.Computer;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day2OpCodes {

    @Test
    public void part1() throws Exception {

        Computer computer = new Computer(getCodes(), Collections.singletonList(0L));
        computer.setNounAndVerb(12L,2L);
        computer.execute();
        assertEquals(4090689L, computer.getPosition0());
    }


    @Test
    public void part2() throws Exception{
        Long noun = 0L;
        Long verb = 0L;
        for (int i=0; i<100;++i) {
            for (int j=0; j< 100; ++j) {
                List<Long> codes = getCodes();
                Computer computer = new Computer(codes, Collections.singletonList(1L));
                computer.setNounAndVerb(new Long(i), new Long(j));
                computer.execute();
                Collection<Long> memory = computer.getMemoryAsList();
                Long result = new ArrayList<>(memory).get(0);
                if (result == 19690720) {
                    noun = computer.getNoun();
                    verb = computer.getVerb();
                }
            }
        }
        assertEquals(77L, noun);
        assertEquals(33L, verb);
        assertEquals(7733L, 100 * noun + verb);

    }

    private List<Long> getCodes() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day2OpCodes.class);
        final String delimiter = ",";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }




}
