package org.example._2024_04_17.taski;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;


public class FigureTasks {

    // ****************** Basic Tasks ******************

    /**
     * 1. Напишите метод для подсчета всех кругов заданного цвета в списке фигур.
     */
    public static int countCirclesOfColor(List<Figure> figures, Color color) {
        int count = 0;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                if (circle.getColor() == color) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 2. Напишите метод для нахождения прямоугольника с максимальной площадью.
     */
    public static Rectangle findRectangleWithMaxArea(List<Figure> figures) {
        Rectangle maxArea = null;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                if (maxArea == null) {
                    maxArea = rectangle;
                } else if (rectangle.getA() * rectangle.getB() > maxArea.getB() * maxArea.getA())
                    maxArea = rectangle;
            }
        }
        return maxArea;
    }

    /**
     * 3. Напишите метод для вывода всех треугольников, у которых все стороны равны.
     */
    public static void printEquilateralTriangles(List<Figure> figures) {
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (triangle.getA() == triangle.getB() && triangle.getB() == triangle.getC())
                    System.out.println("равносторонний треугольник: " + triangle);
            }
        }

    }

    /**
     * 4. Напишите метод для нахождения суммы радиусов всех кругов определенного цвета.
     */
    public static int sumOfRadiiForColor(List<Figure> figures, Color color) {
        int sumRadius = 0;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                if (circle.getColor() == color) {
                    sumRadius += circle.getRadius();
                }
            }

        }
        return sumRadius;
    }

    /**
     * 5. Напишите метод для определения, есть ли в списке фигур прямоугольник и треугольник одинакового цвета.
     */
    public static boolean hasRectangleAndTriangleOfSameColor(List<Figure> figures) {
        boolean identicalColor = false;
//        Enum colorRectangle = null;
//        Enum colorTriangle = null;
        List<Enum> colorRectangles = new ArrayList<>();
        List<Enum> colorTriangles = new ArrayList<>();
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Rectangle) {
                Rectangle rectangle = (Rectangle) figure;
                colorRectangles.add(((Rectangle) figure).getColor());
//                if (colorRectangle == null) {
//                    colorRectangle = rectangle.getColor();
//                }
            } else if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                colorTriangles.add(((Triangle) figure).getColor());
            }
        }
        for (int i = 0; i < colorRectangles.size(); i++) {
            for (int j = 0; j < colorTriangles.size(); j++) {
                if (colorTriangles.get(i) == colorRectangles.get(j)) {
                    identicalColor = true;
                    break;
                }
            }
            break;
        }
        return identicalColor;
    }

    // ****************** Intermediate Tasks ******************

    /**
     * 6. Напишите метод для нахождения круга с минимальным радиусом среди кругов заданного цвета.
     */
    public static Circle findCircleWithMinRadiusOfColor(List<Figure> figures, Color color) {
        Circle minRadius = null;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                if (circle.getColor() == color) {
                    if (minRadius == null) {
                        minRadius = circle;
                    } else if (minRadius.getRadius() > circle.getRadius()) {
                        minRadius = circle;
                    }
                }
            }
        }
        return minRadius;
    }

    /**
     * 7. Напишите метод для подсчета треугольников, у которых хотя бы одна сторона больше заданного значения.
     */
    public static int countTrianglesWithSideGreaterThan(List<Figure> figures, int length) {
        int countTriangles = 0;
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Triangle) {
                Triangle triangle = (Triangle) figure;
                if (triangle.getA() > length || triangle.getB() > length || triangle.getC() > length)
                    countTriangles++;
            }
        }
        return countTriangles;
    }

    /**
     * 9. Напишите метод для нахождения всех кругов, у которых радиус равен любой из сторон любого треугольника.
     */
    public static List<Circle> findCirclesWithRadiusEqualToTriangleSide(List<Figure> figures) {
        Triangle triangle = null;
        List<Circle> circles = new ArrayList<>();
        List<Circle> circles1 = new ArrayList<>();
        for (int i = 0; i < figures.size(); i++) {
            Figure figure = figures.get(i);
            if (figure instanceof Circle) {
                Circle circle = (Circle) figure;
                circles.add((Circle) figure);
            } else if (figure instanceof Triangle) {
                triangle = (Triangle) figure;
            }
        }
        for (int i = 0; i < circles.size(); i++) {
            if (triangle.getA() == circles.get(i).getRadius() ||
                    triangle.getB() == circles.get(i).getRadius() ||
                    triangle.getC() == circles.get(i).getRadius()) {
                circles1.add(circles.get(i));
            }
        }
        return circles1;
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
}