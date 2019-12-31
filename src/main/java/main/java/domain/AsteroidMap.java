package main.java.domain;

import java.awt.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class AsteroidMap {

    private Set<Point> points = new HashSet<>();
    private Map<Point,Integer> sightings  = new HashMap<>();

    public AsteroidMap(){

    }
    public AsteroidMap(List<String> lines){
        for (int i=0;i<lines.size();i++){
            String s = lines.get(i);
            for (int j = 0; j < s.length(); j++){
                char c = s.charAt(j);
                if (c == '#'){
                    points.add(new Point(j,i));
                }
            }
        }
        for(Point point: points){
            Set<Double> angles = new HashSet<>();
            for (Point anotherPoint: points){
                if (!point.equals(anotherPoint)){

                    angles.add(calculateAngle(point, anotherPoint));
                }
            }
            sightings.put(point, angles.size());
        }
    }

    public Integer getNumberOfPoints(){
        return points.size();
    }



    public Integer getBiggestVantagePointSize(){

        return Collections.max(sightings.entrySet(), Map.Entry.comparingByValue()).getValue();

    }
    public Point getVantagePoint(){
        return Collections.max(sightings.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    public SortedMap<Double,Point> getVaporiseDistances(Point point){
        SortedMap<Double,SortedMap<Double,Point>> vaporiseDistances = new TreeMap<>();
        for (Point otherPoint: points){
            if (!otherPoint.equals(point)) {
                Double angle = calculateAngle(point, otherPoint);
                Double distance = calculateDistance(point, otherPoint);
                if (vaporiseDistances.containsKey(angle)) {
                    SortedMap<Double, Point> pointsAtAngle = vaporiseDistances.get(angle);
                    pointsAtAngle.put(distance, otherPoint);
                    vaporiseDistances.put(angle, pointsAtAngle);
                } else {
                    SortedMap<Double, Point> pointsAtAngle = new TreeMap<>();
                    pointsAtAngle.put(distance, otherPoint);
                    vaporiseDistances.put(angle, pointsAtAngle);
                }
            }
        }
        SortedMap<Double,Point> pointSequence = new TreeMap<>();
        for (Map.Entry<Double, SortedMap<Double,Point>> pointMapAtAngle: vaporiseDistances.entrySet()) {
            Double angle = pointMapAtAngle.getKey();
            SortedMap<Double,Point> pointDistanceMap = pointMapAtAngle.getValue();
            int i=0;
            for (Map.Entry<Double,Point> pointDistancePair: pointDistanceMap.entrySet()) {
                Double weighting = angle + 500 * i++;
                Point nextPoint = pointDistancePair.getValue();
                pointSequence.put(weighting, nextPoint);
            }
        }

        return pointSequence;
    }


    public double calculateAngle(Point a, Point b){

        double angle =  Math.toDegrees(Math.atan2(b.y - a.y, b.x-a.x));
        angle = angle +90;
        if (angle > 360) {
            angle = angle -360;
        }
        if (angle < 0){
            angle = angle + 360;
        }
        return angle;
    }

    public double calculateDistance(Point a, Point b) {
        double xsq = Math.pow((b.x - a.x), 2);
        double ysq = Math.pow((b.y - a.y), 2);
        double distance =  Math.sqrt(xsq + ysq);
        return distance;
    }

}



