package test.java.exercises;


import main.java.domain.Move;
import main.java.io.FileReader;
import org.junit.jupiter.api.Disabled;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Math.abs;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Day3ManhattanDistance {
    private static final String EXERCISE_INPUT = main.java.io.ResourceLocator.getExerciseInputFile(Day3ManhattanDistance.class);
    private static final String DELIMITER = ",";

    @Disabled("Disabled until runs faster")
    public void part1() throws Exception {
        List<Move> moves1 = getMoves(0);
        List<Move> moves2 = getMoves(1);
        main.java.domain.Graph graph1 = new main.java.domain.Graph(moves1);
        main.java.domain.Graph filtered = new main.java.domain.Graph(moves1);
        main.java.domain.Graph graph2 = new main.java.domain.Graph(moves2);
        filtered.getPoints().retainAll(graph2.getPoints());
        Map<java.awt.Point, Integer> manhattanDistances =
                filtered.getPoints().stream().collect(java.util.stream.Collectors.toMap(java.util.function.Function.identity(), p->abs(p.x) + abs(p.y)));
        Optional<Map.Entry<java.awt.Point,Integer>> nearestEntry = manhattanDistances
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue));
        Integer lowest = nearestEntry.get().getValue();
        assertEquals(232,lowest);


        Map<Point, Integer> totalDistances =
                filtered.getPoints().stream().collect(Collectors.toMap(Function.identity(), p->
                        graph1.getDistanceToPoint(p) + graph2.getDistanceToPoint(p)));

        Optional<Map.Entry<Point,Integer>> lowestTotalEntry = totalDistances
                .entrySet()
                .stream()
                .min(Comparator.comparingInt(Map.Entry::getValue));

        Integer lowestTotal = lowestTotalEntry.get().getValue();
        assertEquals(6084, lowestTotal);

    }

    private List<Move> getMoves(Integer n) throws  Exception{
        List<String> lines = FileReader.getLines(EXERCISE_INPUT);
        List<String> line1Items = Arrays.asList(lines.get(n).split(DELIMITER));
        return line1Items.stream().map(Move::new).collect(Collectors.toList());
    }


}
