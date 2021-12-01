import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class PointsTest {

    private final ByteArrayOutputStream outContent;

    public PointsTest() {
        outContent = new ByteArrayOutputStream();
        PrintStream tempOut = new PrintStream(outContent);
        System.setOut(tempOut);
    }

    @AfterAll
    public static void restoreStream() {
        System.setOut(System.out);
    }

    @ParameterizedTest
    @MethodSource
    void testNaturalSort(String[] args, String expected) throws FileNotFoundException {
        PointsClient app = new PointsClient();
        app.main(args);
        assertTrue(outContent.toString().contains(expected));
        outContent.reset();
    }

    @ParameterizedTest
    @MethodSource
    void testYSort(String[] args, String expected) throws FileNotFoundException {
        PointsClient app = new PointsClient();
        app.main(args);
        assertTrue(outContent.toString().contains(expected));
        outContent.reset();
    }

    @ParameterizedTest
    @MethodSource
    void testOriginSort(String[] args, String expected) throws FileNotFoundException {
        PointsClient app = new PointsClient();
        app.main(args);
        assertTrue(outContent.toString().contains(expected));
        outContent.reset();
    }


    private static Stream<Arguments> testNaturalSort() {
        return Stream.of(
                Arguments.of(new String[]{"points.txt",""},"PointEx[x=2,y=7], PointEx[x=3,y=3], PointEx[x=8,y=6]")
        );
    }

    private static Stream<Arguments> testYSort() {
        return Stream.of(
                Arguments.of(new String[]{"points.txt","y"},"PointEx[x=3,y=3], PointEx[x=8,y=6], PointEx[x=2,y=7]")
        );
    }

    private static Stream<Arguments> testOriginSort() {
        return Stream.of(
                Arguments.of(new String[]{"points.txt","origin"},"PointEx[x=3,y=3], PointEx[x=2,y=7], PointEx[x=8,y=6]")
        );
    }


}