package main.java.domain;

import java.awt.Point;
import java.util.*;

public class Move {
    public Move(String directions){
        this.type = directions.substring(0,1);
        this.size = Integer.parseInt(directions.substring(1));
    }

    private int size;
    private String type;

    public List<Point> getPoints(Point point){
        Point currentPoint = point;
        List<Point> points = new ArrayList<>();

        for(int i=0; i<size; i++){
            if (type.equals("R")) {
                currentPoint = new Point(currentPoint.x + 1, currentPoint.y);
            }
            else if(type.equals("L")) {
                currentPoint = new Point(currentPoint.x - 1, currentPoint.y);
            }
            else if(type.equals("U")) {
                currentPoint = new Point(currentPoint.x, currentPoint.y + 1);
            }
            else if(type.equals("D")) {
                currentPoint = new Point(currentPoint.x, currentPoint.y - 1);
            }
            points.add(currentPoint);
        }
        return points;
    }
}
