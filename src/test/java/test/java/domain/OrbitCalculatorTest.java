package test.java.domain;

import main.java.domain.Orbit;
import main.java.domain.OrbitCalculator;
import main.java.io.FileReader;
import org.junit.jupiter.api.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OrbitCalculatorTest {

    @Test
    public void testSumOfAllOrbits()throws Exception {
        List<String> lines = FileReader.getLines("./src/test/resources/Orbits1.csv");
        List<Orbit> orbits = lines.stream().map(s -> new Orbit(s)).collect(Collectors.toList());
        assertEquals(42, new OrbitCalculator(orbits).calculateSumOfAllOrbits());


    }

    @Test
    public void testMinimumDistance()throws Exception {
        List<String> lines = FileReader.getLines("./src/test/resources/Orbits2.csv");
        List<Orbit> orbits = lines.stream().map(s -> new Orbit(s)).collect(Collectors.toList());
        assertEquals(4, new OrbitCalculator(orbits).calculateMinDistance("YOU","SAN"));

    }


}
