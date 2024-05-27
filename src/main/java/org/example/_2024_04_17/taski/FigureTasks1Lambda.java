package org.example._2024_04_17.taski;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.CharSetUtils.count;
import static org.example._2024_04_17.taski.Color.RED;
import static org.example._2024_04_17.taski.Color.WHITE;


public class FigureTasks1Lambda {

    // ****************** Basic Tasks ******************

    /**
     * //     * 1. Напишите метод для подсчета всех кругов заданного цвета в списке фигур.
     * //
     */
    public static int countCirclesOfColor(List<Figure> figures, Color color) {
        return (int) figures.stream()
                .filter(figure -> figure instanceof Circle && ((Circle) figure).getColor().equals(color))
                .peek(System.out::println)
                .count();
    }

    /**
     * 2. Напишите метод для нахождения прямоугольника с максимальной площадью.
     */
    public static Rectangle findRectangleWithMaxArea(List<Figure> figures) {

        Rectangle maxRechtangle = (Rectangle) figures.stream()
                .filter(figure -> figure instanceof Rectangle)
                .max((figure1, figure2) -> (((Rectangle) figure1).getA() * ((Rectangle) figure1).getB()) -
                        (((Rectangle) figure2).getA() * ((Rectangle) figure2).getB())).get();
        return maxRechtangle;

    }

    /**
     * 3. Напишите метод для вывода всех треугольников, у которых все стороны равны.
     */
    public static void printEquilateralTriangles(List<Figure> figures) {

        figures.stream()
                .filter(figure -> figure instanceof Triangle
                        && ((Triangle) figure).getA() == ((Triangle) figure).getB()
                        && ((Triangle) figure).getB() == ((Triangle) figure).getC())
                .peek(System.out::println)
                .toList();
    }

    /**
     * 4. Напишите метод для нахождения суммы радиусов всех кругов определенного цвета.
     */
    public static int sumOfRadiiForColor(List<Figure> figures, Color color) {

        return figures.stream()
                .filter(figure -> figure instanceof Circle
                        && ((Circle) figure).getColor().equals(color))
                .mapToInt(figure -> ((Circle) figure).getRadius())
                .sum();
    }

    /**
     * 5. Напишите метод для определения, есть ли в списке фигур прямоугольник и треугольник одинакового цвета.
     */
    public static boolean hasRectangleAndTriangleOfSameColor(List<Figure> figures) {

        Set<Color> colors = figures.stream()
                .filter(figure -> figure instanceof Rectangle)
                .map(figure -> ((Rectangle) figure).getColor())
                .collect(Collectors.toSet());
        return figures.stream()
                .filter(figure -> figure instanceof Triangle)
                .anyMatch(figura -> colors.contains(((Triangle) figura).getColor()));
    }

    // ****************** Intermediate Tasks ******************

    /**
     * 6. Напишите метод для нахождения круга с минимальным радиусом среди кругов заданного цвета.
     */
    public static Circle findCircleWithMinRadiusOfColor(List<Figure> figures, Color color) {

        Circle min = (Circle) figures.stream()
                .filter(figure -> figure instanceof Circle && color.equals(((Circle) figure).getColor()))
                .min((circle1, circle2) -> ((Circle) circle2).getRadius() - ((Circle) circle1).getRadius()).get();
        return min;

    }

    /**
     * 7. Напишите метод для подсчета треугольников, у которых хотя бы одна сторона больше заданного значения.
     */
    public static int countTrianglesWithSideGreaterThan(List<Figure> figures, int length) {

        return (int) figures.stream()
                .filter(figure -> figure instanceof Triangle && ((Triangle) figure).getA() > length
                        || figure instanceof Triangle && ((Triangle) figure).getB() > length
                        || figure instanceof Triangle && ((Triangle) figure).getC() > length)
                .peek(System.out::println)
                .count();
    }

    /**
     * 9. Напишите метод для нахождения всех кругов, у которых радиус равен любой из сторон любого треугольника.
     */
    public static List<Circle> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {

        List<Figure> circles = figures.stream()
                .filter(figure -> figure instanceof Circle)
                .toList();

        int storona = figures.stream()
                .filter(figure -> figure instanceof Triangle)
                .mapToInt(el -> (int) ((Triangle) el).getA())
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Not found"));

        List<Circle> ciclesWithRad = circles.stream()
                .filter(figure -> ((Circle) figure).getRadius() == storona)
                .map(figure -> (Circle) figure)
                .toList();
        return ciclesWithRad;

    }

    // ****************** Upper Intermediate Tasks ******************

    /**
     * 11. Напишите метод для нахождения треугольника, у которого разница между
     * максимальной и минимальной сторонами минимальна среди всех треугольников.
     */
    public static Triangle findTriangleWithSmallestSideDifference(List<Figure> figures) {
        int min = 0;
        int max = 0;
        int x = 999999999;
        Triangle finfMe = null;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (triangle.getA() < triangle.getB() && triangle.getA() < triangle.getB()) {
                    min = triangle.getA();
                    if (triangle.getB() > triangle.getC()) {
                        max = triangle.getB();
                    } else max = triangle.getC();
                } else if (triangle.getB() < triangle.getC() && triangle.getB() < triangle.getA()) {
                    min = triangle.getB();
                    if (triangle.getA() > triangle.getC()) {
                        max = triangle.getA();
                    } else max = triangle.getC();
                } else if (triangle.getC() < triangle.getB() && triangle.getC() < triangle.getA()) {
                    min = triangle.getC();
                    if (triangle.getA() > triangle.getB()) {
                        max = triangle.getA();
                    } else max = triangle.getB();
                }
                if ((max - min) < x) {
                    x = max - min;
                    finfMe = triangle;
                }
            }
        }
        return finfMe;
    }

    /**
     * 12. Напишите метод для вывода всех фигур, у которых хотя бы один параметр
     * (цвет, радиус, сторона) совпадает с аналогичным параметром другой фигуры.
     */
//    public static void printFiguresWithAtLeastOneMatchingParameter(List<Figure> figures) {
//        List<Figure> figures1 = new ArrayList<>();
//        List<Circle> circles = new ArrayList<>();
//        List<Rectangle> rectangles = new ArrayList<>();
//        List<Triangle> triangles = new ArrayList<>();
//        for (int i = 0; i < figures.size(); i++) {
//            Figure figure = figures.get(i);
//            if (figure instanceof Circle) {
//                Circle circle = (Circle) figure;
//                circles.add(circle);
//            } else if (figure instanceof Rectangle) {
//                Rectangle rectangle = (Rectangle) figure;
//                rectangles.add(rectangle);
//            } else if (figure instanceof Triangle) {
//                Triangle triangle = (Triangle) figure;
//                triangles.add(triangle);
//            }
//        }
//
//                    if ( == rectangles.get(j).getColor() ||
//                            circles.get().getColor() == triangles.get(k).getColor()) {
//                        figures1.add(circles.get(i));
//                    }
//                    if (rectangles.get(j).getColor() == triangles.get(k).getColor() ||
//                            rectangles.get(j).getColor() == circles.get(i).getColor() ||
//                            rectangles.get(j).getA() == triangles.get(k).getA() ||
//                            rectangles.get(j).getB() == triangles.get(k).getB()) {
//                        figures1.add(rectangles.get(j));
//                    }
//                    if (triangles.get(k).getColor() == rectangles.get(j).getColor() ||
//                            triangles.get(k).getColor() == circles.get(i).getColor() ||
//                            rectangles.get(j).getA() == triangles.get(k).getA() ||
//                            rectangles.get(j).getB() == triangles.get(k).getB()) {
//                        figures1.add(triangles.get(k));
//

//        }
//        System.out.println("фигуры в которых совпали значения по любому из парамет");
//    }
//    public static boolean isMatch (List<Circle> circles, List<Rectangle> rectangles, List<Triangle> )
//
//    // Helper method to determine if two figures have at least one matching parameter
//    private static boolean figuresMatch(Figure a, Figure b) {
//        return false;
//    }

    /**
     * 13. Напишите метод для нахождения кругов, у которых радиус больше суммы сторон любого треугольника в списке.
     */
    public static List<Circle> findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(List<Figure> figures) {
        int summaStoron = 0;
        List<Circle> circles = new ArrayList<>();
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                summaStoron = triangle.getA() + triangle.getB() + triangle.getC();
            } else if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                if (circle.getRadius() > summaStoron) {
                    circles.add(circle);
                }
            }
        }
        return circles;
    }

    // ****************** Advanced Tasks ******************

    /**
     * 16. Напишите метод для нахождения круга, который можно вписать в
     * наибольшее количество треугольников, учитывая их углы и стороны.
     */
    public static Circle findCircleThatFitsMostTriangles(List<Figure> figures) {
        return null;
    }


    /**
     * 19. Напишите метод для определения треугольника с наименьшим углом, вписывающимся в заданный круг.
     */
    public static Triangle findSmallestAngleTriangleInCircle(Circle circle, List<Figure> figures) {
        return null;
    }

    // ****************** Expert Tasks ******************

    /**
     * 21. Напишите метод для определения круга,
     * у которого соотношение площади к радиусу является наименьшим среди всех кругов.
     */
    public static Circle findCircleWithSmallestAreaToRadiusRatio(List<Figure> figures) {
        double min = 999999999;
        Circle circleMin = null;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                if (circle.getRadius() * Math.PI < min) { // площадь = PI*r  в квадрате. соотнощение: делим площ.на радиус. Сокращение
                    min = (circle.getRadius() * Math.PI);
                    circleMin = circle;
                }
            }
        }
        return circleMin;
    }

    /**
     * 23. Напишите метод для определения, можно ли составить
     * из треугольников полигон без промежутков и наружных выступов.
     */
    public static boolean canFormClosedPolygonFromTriangles(List<Figure> figures) {
        return true;
    }

    /**
     * 24. Напишите метод для определения прямоугольника с наибольшим отношением диагонали к периметру.
     */
    public static Rectangle findRectangleWithLargestDiagonalToPerimeterRatio(List<Figure> figures) {
        int maxRatio = 0;
        Rectangle rectangleMaxRatio = null;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                if ((Math.sqrt(Math.pow(rectangle.getA(), 2) + Math.pow(rectangle.getB(), 2))
                        / 2 * (rectangle.getA() + rectangle.getB())) > maxRatio) {
                    rectangleMaxRatio = rectangle;
                }
            }

        }
        return rectangleMaxRatio;
    }

    /**
     * 25. Напишите метод для нахождения всех комбинаций фигур,
     * которые могут быть соединены таким образом, чтобы их общая площадь была равна заданному значению.
     */
    public static List<List<Figure>> findFigureCombinationsMatchingArea(List<Figure> figures, int targetArea) {
        return null;
    }

    public static void main(String[] args) {
        List<Figure> figures = FigureGenerator.generateFigures();
//        System.out.println(figures);
//        System.out.println(FigureTasks1Lambda.countCirclesOfColor(figures, RED)); //1
//        System.out.println("Прямоугольник с максимальной площадью: "+FigureTasks1Lambda.findRectangleWithMaxArea(figures)); //2
//        FigureTasks1Lambda.printEquilateralTriangles(figures); //3
//        System.out.println("Сумма радиусов всех окружностей, заданного цвета: " +
//                FigureTasks1Lambda.sumOfRadiiForColor(figures, Color.BLACK) + " \n"); //4
//        System.out.println("Наличие треугольника и прямоугольника одного цвета: " +
//                FigureTasks.hasRectangleAndTriangleOfSameColor(figures)+" \n"); //5
//        System.out.println("круг с минимальным радиусом среди кругов заданного цвета: " +
//                FigureTasks1Lambda.findCircleWithMinRadiusOfColor(figures, WHITE) + " \n"); //6
//        System.out.println("кол-во треугольников у которых, хотя бы одна сторона больше заданного значения: "+
//                FigureTasks1Lambda.countTrianglesWithSideGreaterThan (figures,15)+" \n"); //7
        System.out.println("круги у которых радиус равен любой из сторон треугольника: "+
                FigureTasks.findCirclesWithRadiusEqualToTriangleSide(figures)+" \n"); //9
//        System.out.println("Треугольник у которого разница между максимальной стороной и минимальной стороной" +
//                " - минимальна: " +FigureTasks.findTriangleWithSmallestSideDifference(figures)+" \n");
////        FigureTasks.printFiguresWithAtLeastOneMatchingParameter(figures);
//        System.out.println("Круги у которых радиус больше, чем сумма сторон треугольника: "
//                +FigureTasks.findCirclesWithRadiusGreaterThanSumOfAnyTriangleSides(figures)+" \n");
//        System.out.println("круг с наименьшим соотношением площади к радиусу: "
//        +FigureTasks.findCircleWithSmallestAreaToRadiusRatio(figures)+" \n");
//        System.out.println("Прямоугольник с наибольшим соотношением диагонали к периметру: "+
//                FigureTasks.findRectangleWithLargestDiagonalToPerimeterRatio(figures)+" \n");
//        System.out.println("кол-во кругов по цветам: "+TasksMap.countCirclesOfColor(figures)+" \n");
//        System.out.println("Суммы радиусов по цветам: "+TasksMap.sumOfRadiiForColor(figures)+" \n");
//        System.out.println("Прямоугольник с максимальным соотношением диагонали к периметру: "+
//                TasksMap.findRectangleWithLargestDiagonalToPerimeterRatio(figures)+" \n");
//        System.out.println("Круги радиус который совпадает с любой из сторон треугольников: "+
//                TasksMap.findCirclesWithRadiusEqualToTriangleSide(figures)+" \n");
//        System.out.println("совпадение цветов у треугольников и прямоугольников: "+
//                TasksMap.hasRectangleAndTriangleOfSameColor(figures)+" \n");
    }
}