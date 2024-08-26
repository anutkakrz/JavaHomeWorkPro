package org.example.fig;//package org.example._2024_08_26.fig;
//
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.EnumSource;
//import org.junit.jupiter.params.provider.MethodSource;
//import org.junit.jupiter.params.provider.ValueSource;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//class GeometricServiceTest {
//
//    @ParameterizedTest
//    @ValueSource(doubles = {10.0, 20.0, 30.0})
//    void testFindCirclesInRange(double radius) {
//
//    }
//
//    @ParameterizedTest
//    @EnumSource(GeometricType.class)
//    void testCountByType(GeometricType type) {
//
//    }
//
//    enum GeometricType {
//        SQUARE(Square.class),
//        CIRCLE(Circle.class),
//        TRIANGLE(Triangle.class),
//        LINE(Line.class);
//
//        private final Class<? extends Geometric> geometricClass;
//
//        GeometricType(Class<? extends Geometric> geometricClass) {
//            this.geometricClass = geometricClass;
//        }
//
//        public Class<? extends Geometric> getGeometricClass() {
//            return geometricClass;
//        }
//    }
//
//    @ParameterizedTest
//    @MethodSource("triangleRadiusDataProvider")
//    void testFindTrianglesWithLargerInscribedCircleThanAverage(List<Geometric> geometries) {
//
//    }
//
//    static Stream<List<Geometric>> triangleRadiusDataProvider() {
//        return Stream.of(
//
//        );
//    }
//}