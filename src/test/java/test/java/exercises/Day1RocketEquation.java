package test.java.exercises;

import main.java.domain.FuelCalculator;
import main.java.io.ResourceLocator;
import main.java.transform.CollectionTransformer;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static main.java.transform.CollectionTransformer.stringStreamToIntegerStream;
import static main.java.transform.CollectionTransformer.stringStreamToLongStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day1RocketEquation {

    @Test
    public void part1CalculateFuelRequirements() throws Exception {
        List<Integer> fuels  = getInputMasses().map(FuelCalculator::getFuel).collect(Collectors.toList());
        Integer sum = CollectionTransformer.addIntegers(fuels);
        assertEquals(3305301, sum);
    }

    @Test
    public void part2IncludeFuelForFuel()  throws Exception{
        List<Integer> fuels  = getInputMasses().map(FuelCalculator::getFuelRecursive).collect(Collectors.toList());
        Integer sum = CollectionTransformer.addIntegers(fuels);
        assertEquals(4955106, sum);
    }

    private Stream<Integer> getInputMasses() throws Exception{
        String exerciseInput = ResourceLocator.getExerciseInputFile(Day1RocketEquation.class);
        Stream<String> lines = Files.lines(Paths.get(exerciseInput));
        return stringStreamToIntegerStream(lines);
    }
}
