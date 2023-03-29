import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

public class AsteroidScannerTest {

    private static final double DELTA = 0.001;

    private List<Asteroid> data;
    private List<Asteroid> uniqueData;

    private boolean stdCapStarted;
    private OutputStream tmpStdOut;
    private PrintStream originalStdOut;

    private void stdCaptureStart() {
        if (stdCapStarted)
            throw new RuntimeException("Capture needs to be stopped before it can be started");

        stdCapStarted = true;
        tmpStdOut = new ByteArrayOutputStream();
        originalStdOut = System.out;
        System.setOut(new PrintStream(tmpStdOut));
    }

    private void stdCaptureStop() {
        if (!stdCapStarted)
            throw new RuntimeException("Capture needs to be started before it can be stopped");

        stdCapStarted = false;
        System.setOut(originalStdOut);
        originalStdOut = null;
        tmpStdOut = null;
    }

    private String getCapturedStdOut() {
        if (tmpStdOut == null)
            throw new RuntimeException("Nothing captured.");

        return tmpStdOut.toString();
    }

    private Object getPrivateField(Object getObj, Class<?> c, String fieldName) {
        try {
            Field f = c.getDeclaredField(fieldName);
            f.setAccessible(true);
            return f.get(getObj);
        } catch (Exception e) {
            System.out.println("Error retrieving private int field " + fieldName + ": " + e);
            return null;
        }
    }

    private void setPrivateField(Object setObj, Class<?> c, String fieldName, Object value) {
        try {
            Field f = c.getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(setObj, value);
        } catch (Exception e) {
            System.out.println("Error setting private field " + fieldName + ": " + e);
        }
    }

    @BeforeEach
    public void setUp() {
        Asteroid rockA = new Asteroid(-9684.59, 270.82, -132.84, 551, SizeCategory.MEDIUM);
        Asteroid rockB = new Asteroid(15303.82, -138.47, 166.58, -639, SizeCategory.LARGE);
        Asteroid rockC = new Asteroid(1952.42, 106.64, 94.28, -173, SizeCategory.LARGE);
        Asteroid rockD = new Asteroid(-7199.88, -247.91, 275.97, -730, SizeCategory.SMALL);
        Asteroid rockE = new Asteroid(9666.93, 339.71, 336.86, -959, SizeCategory.MEDIUM);

        data = List.of(rockA, rockA, rockB, rockC, rockA, rockE, rockD, rockE);
        uniqueData = List.of(rockA, rockB, rockC, rockD, rockE);
    }

    @Test
    public void testDeduplicateNull() {
        assertThrows(NullPointerException.class, () -> {
            AsteroidScanner.deduplicate(null);
        });
    }

    @Test
    public void testDeduplicateFilter() {
        Set<Asteroid> result = AsteroidScanner.deduplicate(data);

        assertEquals(uniqueData.size(), result.size(), "Set does not have expected size.");

        for (Asteroid rock : uniqueData) {
            assertTrue(result.contains(rock), "Set does not contain expected results.");
        }
    }

    @Test
    public void testCtorNoConsoleOut() {
        String EXPECTED = "3 duplicate asteroids found.";

        stdCaptureStart();
        try {
            try {
                AsteroidScanner.deduplicate(data);
            } catch (Exception e) {
                System.err.println("Error executing deduplicate" +
                        " for console output check:" + e);
            }
            assertEquals(EXPECTED, getCapturedStdOut().trim(), "Console output not as expected.");
        } finally {
            stdCaptureStop();
        }
    }
}
