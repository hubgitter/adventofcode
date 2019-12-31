package test.java.domain;

import main.java.domain.AsteroidMap;
import main.java.domain.Computer;
import main.java.io.FileReader;
import main.java.io.ResourceLocator;
import org.junit.jupiter.api.Test;
import test.java.exercises.Day10MonitoringStation;
import test.java.exercises.Day9SensorBoost;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AsteroidMapTest {

    @Test
    public void testCountPoints() throws Exception {
        final List<String> lines =
                FileReader.getLines("src/test/resources/SmallAsteroidMapExample1.csv");
        AsteroidMap asteroidMap = new AsteroidMap(lines);

        assertEquals(10, asteroidMap.getNumberOfPoints());
        assertEquals(8, asteroidMap.getBiggestVantagePointSize());

    }
    @Test
    public void testPointAngles()  {
        Point point1 = new Point(8,3);
        Point point2 = new Point(8,2);
        assertEquals(0, new AsteroidMap().calculateAngle(point1,point2 ));
    }


    @Test
    public void testPointDistances()  {
        Point point1 = new Point(8,3);
        Point point2 = new Point(5,3);
        assertEquals(3.0, new AsteroidMap().calculateDistance(point2,point1));

    }

    @Test
    public void testVaporiseDistances()throws Exception {
        final List<String> lines =
                FileReader.getLines("src/test/resources/SmallVaporiseAsteroidMapExample1.csv");

        AsteroidMap asteroidMap = new AsteroidMap(lines);

        Point vantagePoint = new Point(8, 3);
        SortedMap<Double,Point> vaporiseDistances = asteroidMap.getVaporiseDistances(vantagePoint);
        List<Point> valueList = new ArrayList(vaporiseDistances.values());
        assertEquals(36, valueList.size());
        assertEquals(new Point(8,1), valueList.get(0));
        assertEquals(new Point(9,0), valueList.get(1));


    }

}

