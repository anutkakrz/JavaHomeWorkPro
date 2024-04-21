package org.example._2024_04_17.taski;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

import static org.example._2024_04_17.taski.Color.RED;
import static org.example._2024_04_17.taski.Color.WHITE;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();
        System.out.println(figures);
        System.out.println(FigureTasks.countCirclesOfColor(figures, RED));
        System.out.println(FigureTasks.findRectangleWithMaxArea(figures));
        FigureTasks.printEquilateralTriangles(figures);
        System.out.println("Сумма радиусов всех окружностей, заданного цвета: " +
                FigureTasks.sumOfRadiiForColor(figures, Color.BLACK));
        System.out.println("Наличие треугольника и прямоугольника одного цвета: " +
                FigureTasks.hasRectangleAndTriangleOfSameColor(figures));
        System.out.println("круг с минимальным радиусом среди кругов заданного цвета: "+
                FigureTasks.findCircleWithMinRadiusOfColor(figures, WHITE));
        System.out.println("кол-во треугольников у которых, хотя бы одна сторона больше заданного значения: "+
                FigureTasks.countTrianglesWithSideGreaterThan (figures,15));
        System.out.println("круги у которых радиус равен любой из сторон треугольника: "+
                FigureTasks.findCirclesWithRadiusEqualToTriangleSide(figures));
        System.out.println("Треугольник у которого разница между максимальной стороной и минимальной стороной" +
                " - минимальна: " +FigureTasks.findTriangleWithSmallestSideDifference(figures));
//        FigureTasks.printFiguresWithAtLeastOneMatchingParameter(figures);
        System.out.println("Круги у которых радиус больше, чем сумма сторон треугольника: "
                +FigureTasks.findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(figures));
        System.out.println("круг с наименьшим соотношением площади к радиусу: "
        +FigureTasks.findCircleWithSmallestAreaToRadiusRatio(figures));
        System.out.println("Прямоугольник с наибольшим соотношением диагонали к периметру: "+
                FigureTasks.findRectangleWithLargestDiagonalToPerimeterRatio(figures));
    }
}


@Getter
@ToString
class Figure {

}

@ToString
@AllArgsConstructor
@Getter
class Rectangle extends Figure {
    private Color color;
    private int a;
    private int b;
}

@ToString
@Getter
@AllArgsConstructor
class Triangle extends Figure {
    private Color color;
    private int a;
    private int b;
    private int c;
}

@ToString
@AllArgsConstructor
@Getter
class Circle extends Figure {
    private Color color;
    private int radius;


}

@ToString
@Getter
enum Color {
    RED, BLACK, WHITE, BLUE, GREEN, YELLOW, ORANGE, PINK, PURPLE, MULTICOLOR
}
