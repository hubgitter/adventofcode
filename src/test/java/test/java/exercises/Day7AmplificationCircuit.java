package test.java.exercises;

import main.java.domain.AmplifiedComputerPhase;
import main.java.domain.ComputerPhase;
import main.java.domain.NumberChecker;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day7AmplificationCircuit {




    @Test
    public void part1() throws Exception {
        List<List<Long>> phaseSettings = new NumberChecker().getCodes(0L,4L,5L);
        Map<List<Long>, Long> results = new HashMap<>();
        for(List<Long> phaseSetting: phaseSettings){
           ComputerPhase computerPhase = new ComputerPhase(getCodes(), phaseSetting);
            results.put(phaseSetting,computerPhase.getResult());
        }
        Long highestSignalValue = results.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        assertEquals(46014L, highestSignalValue);

    }


    @Test
    public void part2() throws Exception {

        List<List<Long>> phaseSettings = new NumberChecker().getCodes(5L,9L,5L);
        Map<List<Long>, Long> results = new HashMap<>();
        for(List<Long> phaseSetting: phaseSettings){
            AmplifiedComputerPhase computerPhase = new AmplifiedComputerPhase(getCodes(), phaseSetting);
            results.put(phaseSetting,computerPhase.getResult());
        }
        Long highestSignalValue = results.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();
        assertEquals(19581200L, highestSignalValue);

    }

    private List<Long> getCodes() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day7AmplificationCircuit.class);
        final String delimiter = ",";
        List<String> lines = FileReader.getLines(exerciseInput);
        List<String> lineItems = Arrays.asList(lines.get(0).split(delimiter));
        return lineItems.stream().map(Long::parseLong).collect(Collectors.toList());
    }

}
