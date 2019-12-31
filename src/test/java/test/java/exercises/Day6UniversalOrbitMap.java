package test.java.exercises;

import main.java.domain.Orbit;
import main.java.domain.OrbitCalculator;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

public class Day6UniversalOrbitMap{

    @Test
    public void part1() throws Exception {
        int audits = new OrbitCalculator(getOrbits()).calculateSumOfAllOrbits();
    }

    @Test
    public void part2() throws Exception {

        int audits = new OrbitCalculator(getOrbits()).calculateMinDistance("YOU","SAN");
    }

    private List<Orbit> getOrbits() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day6UniversalOrbitMap.class);

        List <String> lines = FileReader.getLines(exerciseInput);
        return lines.stream().map(s->new Orbit(s)).collect(Collectors.toList());
    }


}
