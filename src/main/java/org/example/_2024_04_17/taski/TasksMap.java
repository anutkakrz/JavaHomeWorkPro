package org.example._2024_04_17.taski;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.chrono.JapaneseEra.values;

public class TasksMap {

    //    Count circles of a given color:
    public static Map<Color, Integer> countCirclesOfColor(List<Figure> figures) {
        Map<Color, Integer> colorCount = new HashMap<>();
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                Integer count = 0;
                colorCount.put(circle.getColor(), colorCount.getOrDefault(circle.getColor(), 0) + 1);

            }
        }
        return colorCount;
    }

//    Map<Color, Integer> colorCount = new HashMap<>();
//    for (Figure figure : figures) {
//        if (figure instanceof Circle) {
//            Circle circle = (Circle) figure;
//            colorCount.put(circle.getColor(), colorCount.getOrDefault(circle.getColor(), 0) + 1);
//        }
//    }
//    return colorCount;

    //Sum of radii for circles of a certain color:
    public static Map<Color, Integer> sumOfRadiiForColor(List<Figure> figures) {
        Map<Color, Integer> radiusSum = new HashMap<>();
        Integer sumRadius = 0;
        for (Figure figure : figures) {
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                radiusSum.put(circle.getColor(), radiusSum.getOrDefault(circle.getColor(), 0) + circle.getRadius());
            }
        }
        return radiusSum;
    }

    //Find the rectangle with the largest diagonal to perimeter ratio:
    public static Map<Rectangle, Double> findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        Map<Rectangle, Double> rectangleRatios = new HashMap<>();
        Double maxRatio = 0.00;
        for (Figure figure : figures) {
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                if (((Math.sqrt(Math.pow(rectangle.getA(), 2) + Math.pow(rectangle.getB(), 2))
                        / 2 * (rectangle.getA() + rectangle.getB())) > maxRatio)) {
                    maxRatio = ((Math.sqrt(Math.pow(rectangle.getA(), 2) + Math.pow(rectangle.getB(), 2))
                            / 2 * (rectangle.getA() + rectangle.getB())));
                    rectangleRatios.clear();
                    rectangleRatios.put(rectangle, maxRatio);
                }
            }
        }
        return rectangleRatios;
    }

    //Find circles with radius equal to any triangle side:
    public static Map<Circle, Boolean> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {
        Map<Circle, Boolean> circlesWithRadiusEqualToTriangleSide = new HashMap<>();
        List<Triangle> triangles = new ArrayList<>();
        List<Circle> circles = new ArrayList<>();
        Boolean radiusEqualToTriangleSide = false;

        for (Figure figure : figures) {
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                triangles.add(triangle);
            } else if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                circles.add(circle);
            }
        }
        for (int i = 0; i < triangles.size(); i++) {
            for (int j = 0; j < circles.size(); j++) {
                if (circles.get(j).getRadius() == triangles.get(i).getA() ||
                        circles.get(j).getRadius() == triangles.get(i).getB() ||
                        circles.get(j).getRadius() == triangles.get(i).getC()) {
                    radiusEqualToTriangleSide = true;
                    circlesWithRadiusEqualToTriangleSide.put(circles.get(j), radiusEqualToTriangleSide);
                }
            }
        }
        return circlesWithRadiusEqualToTriangleSide;
    }

    //Determine if there's a rectangle and triangle of the same color:
    public static Map<String, Boolean> hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
        Map<String,Boolean> figureMap = new HashMap<>();
        List<Rectangle> rectangles = new ArrayList<>();
        List<Triangle> triangles = new ArrayList<>();
        Boolean sameColor = false;
        for (Figure figure : figures){
            if (figure instanceof Rectangle){
                Rectangle rectangle = (Rectangle) figure;
                rectangles.add(rectangle);
            } else  if (figure instanceof Triangle){
                Triangle triangle = (Triangle) figure;
                triangles.add(triangle);
            }
        }
        for (int i = 0; i < rectangles.size(); i++) {
            for (int j = 0; j < triangles.size(); j++) {
                if (rectangles.get(i).getColor()==triangles.get(j).getColor()){
                    sameColor = true;
                    figureMap.put(String.valueOf(rectangles.get(i).getColor()),sameColor);
                }
            }

        }return figureMap;
    }
}

