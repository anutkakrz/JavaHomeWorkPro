package org.example.fig;

import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ToString
@Getter
public class GeometricService {

    public static void main(String[] args) {
        Square square = new Square(1,1);
        Square rectangle = new Square(1,2);
        Triangle triangle = GeometricFactory.generateValidTriangle();
        Line line = new Line(5);
        Circle circle = new Circle(5.0);
        Circle circle2 = new Circle(10.0);

        List<Geometric> geometrics = new ArrayList<>();

        geometrics.add(triangle);
        geometrics.add(line);
        geometrics.add(circle);
        geometrics.add(circle2);

        GeometricService geometricService = new GeometricService();
        System.out.println(geometricService.findCirclesInMinMaxRadiusRange(geometrics, 10.0, 5.0));

    }

    public List<Square> findPerfectSquares(List<Geometric> geometries) {
        return geometries.stream()
                .filter(geometric -> geometric instanceof Square)
                .map(Square.class::cast)
                .filter(side ->  side.getSideAB()== side.getSideBC())
                .toList();
    }

    public List<Circle> findCirclesInMinMaxRadiusRange(List<Geometric> geometries, double minRadius, double maxRadius) {
        return geometries.stream()
                .filter(geometric -> geometric instanceof Circle)
                .map(Circle.class::cast)
                .filter(radius -> radius.getRadius()==maxRadius || radius.getRadius()== minRadius)
                .toList();
    }



    public  List<Line> findLinesLongerThanLength(List<Geometric> geometries, double length) {

        return geometries.stream()
                .filter(geometric -> geometric instanceof Line)
                .map(Line.class::cast)
                .filter(thisLength->thisLength.getLengthL()>length).toList();
    }

//    //Метод возвращает список треугольников (класса Triangle), у которых радиус вписанного круга больше среднего радиуса всех кругов в коллекции.
//    public static List<Triangle> findTrianglesWithLargerInscribedCircleThanAverage(List<Geometric> geometries) {
//        return null;
//    }

    public static long countByType(List<Geometric> geometries, Class<? extends Geometric> type) {
        return  geometries.stream().filter(type::isInstance).count();

    }

    //Метод возвращает список всех квадратов и кругов, у которых стороны (для квадратов) или радиус (для кругов) находятся в заданном диапазоне.
    public static List<Geometric> findSquaresAndCirclesInRange(List<Geometric> geometries, double minValue, double maxValue) {
        return geometries.stream()
                .filter(geometric ->(geometric instanceof Square
                        && ((Square) geometric).getSideAB()==((Square) geometric).getSideBC()
                        && ((Square) geometric).getSideAB() > minValue
                        && ((Square)geometric).getSideAB()<maxValue)
                         || geometric instanceof Circle && ((Circle)geometric).getRadius()>minValue
                        && ((Circle)geometric).getRadius()<maxValue)
                .collect(Collectors.toList());
    }
}