package test.java.exercises;

import main.java.domain.AsteroidMap;
import main.java.domain.Computer;
import main.java.domain.Orbit;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day10MonitoringStation {

    private static final Logger LOGGER = LogManager.getLogger(Day10MonitoringStation.class);

    @Test
    public void part1() throws Exception {
        List<String> lines = getLines();
        AsteroidMap asteroidMap = new AsteroidMap(lines);

        assertEquals(397, asteroidMap.getNumberOfPoints());
        assertEquals(329, asteroidMap.getBiggestVantagePointSize());

    }

    @Test
    public void part2() throws Exception {
        List<String> lines = getLines();
        AsteroidMap asteroidMap = new AsteroidMap(lines);

        Point vantagePoint = asteroidMap.getVantagePoint();
        assertEquals(new Point(25,31),vantagePoint);
        SortedMap<Double,Point> vaporiseDistances = asteroidMap.getVaporiseDistances(vantagePoint);
        List<Point> valueList = new ArrayList(vaporiseDistances.values());
        assertEquals(396, valueList.size());
        Point point1 = valueList.get(199);
        assertEquals(new Point(5,12), point1);
        assertEquals(512, point1.x*100 + point1.y);

    }

    private List<String> getLines() throws Exception{
        final String exerciseInput = ResourceLocator.getExerciseInputFile(Day10MonitoringStation.class);

       return FileReader.getLines(exerciseInput);
    }
}
