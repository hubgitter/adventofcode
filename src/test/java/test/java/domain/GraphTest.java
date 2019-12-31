package test.java.domain;

import main.java.domain.Graph;
import main.java.domain.Move;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTest {

    @Test
    public void testGetPointsForUpmove() {
        Move move1 = new Move("U3");
        Move move2 = new Move("R3");
        Graph graph = new Graph(Arrays.asList(move1, move2));
        List<Point> points = graph.getPoints();
        assertEquals(6, points.size());
        assertEquals(asList(
                new Point(0, 1),
                new Point(0, 2),
                new Point(0, 3),
                new Point(1, 3),
                new Point(2, 3),
                new Point(3, 3)
        ), points);
    }

    @Test
    public void testGetDistanceToPoint() {
        assertEquals(
                new Graph(Arrays.asList(new Move("U3"), new Move("R2")))
                        .getDistanceToPoint(new Point(2, 3)), 5);
    }


}
