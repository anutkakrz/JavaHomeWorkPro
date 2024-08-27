package org.example.fig;

import junit.framework.TestCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GeometricServiceTest extends TestCase {

    @Test
    public void findPerfectSquaresTest() {
        Square square = new Square(1,1);
        Square rectangle = new Square(1,2);
        Triangle triangle = GeometricFactory.generateValidTriangle();
        Line line = new Line(5);

        List<Geometric> geometrics = new ArrayList<>();
        geometrics.add(triangle);
        geometrics.add(line);
        geometrics.add(square);
        geometrics.add(rectangle);

        Square actualSq = new GeometricService().findPerfectSquares(geometrics).get(0);
        assertEquals(square, actualSq);
    }

    @ParameterizedTest
    @MethodSource("Geometrics")
    public void findPerfectSquaresParamTest(List<Geometric> geometrics, List<Square> expectedList) {


        List<Square> actualSq = new GeometricService().findPerfectSquares(geometrics);
        assertEquals(expectedList, actualSq);
    }

    static Stream<Arguments> Geometrics() {
        return Stream.of(
                Arguments.of(List.of
                        (new Square(1,1), new Square(1,2),new Square(2,2)),
                        List.of(new Square(1,1), new Square(2,2))),
                Arguments.of(List.of(new Circle(2), new Triangle(2,5,8), new Square(5,5)),
                        List.of(new Square(5,5)))
        );
    }

@ParameterizedTest
@MethodSource("Circles")
    public void testFindCirclesInMinMaxRadiusRange(List<Geometric> geometrics,double minRadius, double maxRadius, List<Circle> expectedList) {
    Assertions.assertEquals(expectedList,new GeometricService().findCirclesInMinMaxRadiusRange(geometrics, minRadius, maxRadius));
    }

    static Stream<Arguments> Circles() {
        return Stream.of(Arguments.of(
                List.of(new Circle(5.0),new Circle(2.0),new Circle(9.0)), 5.0,9.0,
                List.of(new Circle(5.0),new Circle(9.0))),
                Arguments.of(List.of(new Square(2.0,5.0),new Circle(9.0)), 5.0,9.0,
                        List.of(new Circle(9.0)))
        );
    }

    @ParameterizedTest
    @MethodSource("Lines")
    public void testFindLinesLongerThanLength(List<Geometric> geometrics, double length, List<Line> expectedList) {
        Assertions.assertEquals(expectedList,new GeometricService().findLinesLongerThanLength(geometrics, length));
    }
    static Stream<Arguments> Lines() {
        return Stream.of(
                Arguments.of(List.of(new Square(2.0,6.5), new Triangle(2.0,4.0,5.0),new Line(5.0)),
                        3.0,
                        List.of(new Line(5.0)),
                        Arguments.of(List.of(new Line(5.0),new Line(8.5)),7.0,List.of(8.5)))
        );
    }

//    public void testFindTrianglesWithLargerInscribedCircleThanAverage() {
//    }

    @ParameterizedTest
    @MethodSource("Types")
    public void testCountByType(List<Geometric> geometrics, Class<? extends Geometric> type, Long expectedCount) {
        Assertions.assertEquals(expectedCount,new GeometricService().countByType(geometrics, type));
    }

    static Stream<Arguments> Types() {
        return Stream.of(
                Arguments.of(List.of(new Circle(5.0), new Square(2.0,4.0), new Circle(2.0)),
                         Circle.class, 2L),
                Arguments.of(List.of(new Triangle(5.0,5.0,5.0), new Square(2.0,4.0), new Circle(2)),
                        Triangle.class, 1L),
        Arguments.of(List.of(new Circle(5.0), new Square(2.0,4.0), new Circle(2.0)),
                Triangle.class, 0L));
    }

    @ParameterizedTest
    @MethodSource("Geometrics2")
    public void testFindSquaresAndCirclesInRange(List<Geometric> geometries, double minValue, double maxValue, List<Geometric> expectedList) {
        Assertions.assertEquals(expectedList,new GeometricService().findSquaresAndCirclesInRange(geometries, minValue, maxValue));
    }

    static Stream<Arguments> Geometrics2() {
        return Stream.of(
                Arguments.of(List.of(new Circle(5.0), new Square(2.0,4.0), new Circle(2.0)),
                        2.0,10.0,List.of(new Circle(5.0))),
                Arguments.of(List.of(new Circle(5.0), new Square(4.0,4.0), new Circle(2.0)),
                        2.0,10.0,List.of(new Circle(5.0),new Square(4.0,4.0)))

        );
    }
}