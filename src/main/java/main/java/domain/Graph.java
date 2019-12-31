package main.java.domain;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    public Graph(List<Move> moves){
        this.points = getPoints(moves);
    }

    public List<Point> getPoints() {
        return points;
    }

    private List<Point> points;

    private List<Point> getPoints(List<Move> moves){
        Map<Point, List<Move>>  map = new HashMap<>();
        List<Point> points = new ArrayList<>();
        List<Move> cmoves = new ArrayList<>();
        Point point = new Point(0,0);
        for (Move move: moves) {
            cmoves.add(move);
            List<Point> newPoints = move.getPoints(point);
            if (!newPoints.isEmpty()) {
                points.addAll(newPoints);
                point = newPoints.get(newPoints.size()-1);
                map.put(point,cmoves);
            }
        }
        return points;
    }


    public Integer getDistanceToPoint(Point point){
        return points.indexOf(point) + 1;
    }


}
