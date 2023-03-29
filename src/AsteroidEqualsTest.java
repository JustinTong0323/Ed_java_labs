import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AsteroidEqualsTest {

    private static final double DIST = -3400.12;
    private static final double THETA = 300.59;
    private static final double PHI = -29.34;
    private static final int SPEED = -403;
    private static final SizeCategory SIZE = SizeCategory.LARGE;

    private static final double DELTA = 0.001;

    private Asteroid m_rockA;
    private Asteroid m_rockB;

    @BeforeEach
    public void setUp() {
        m_rockA = new Asteroid(DIST, THETA, PHI, SPEED, SIZE);
        m_rockB = new Asteroid(-9730.6, -14.46, 233.29, 371, SizeCategory.MEDIUM);
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

    @Test
    public void testEqualsSameInstance() {
        assertTrue(m_rockA.equals(m_rockA),
                "True return value expected if compared to same object instance.");
    }

    @Test
    public void testEqualsInvalidType() {
        assertFalse(m_rockA.equals(new ArrayList<>()),
                "False return value expected if compared to object of invalid type.");
    }

    @Test
    public void testEqualsNull() {
        assertFalse(m_rockA.equals(null),
                "False return value expected if compared to null.");
    }

    private void setupEqualAsteroids() {
        setPrivateField(m_rockA, m_rockA.getClass(), "distance", DIST);
        setPrivateField(m_rockB, m_rockB.getClass(), "distance", DIST);
        setPrivateField(m_rockA, m_rockA.getClass(), "theta", THETA);
        setPrivateField(m_rockB, m_rockB.getClass(), "theta", THETA);
        setPrivateField(m_rockA, m_rockA.getClass(), "phi", PHI);
        setPrivateField(m_rockB, m_rockB.getClass(), "phi", PHI);
        setPrivateField(m_rockA, m_rockA.getClass(), "speed", SPEED);
        setPrivateField(m_rockB, m_rockB.getClass(), "speed", SPEED);
        setPrivateField(m_rockA, m_rockA.getClass(), "size", SIZE);
        setPrivateField(m_rockB, m_rockB.getClass(), "size", SIZE);
    }

    private void checkEquality(String field, Object valueA, Object valueB,
                               String test, boolean expected) {

        setPrivateField(m_rockA, m_rockB.getClass(), field, valueA);
        setPrivateField(m_rockA, m_rockB.getClass(), field, valueB);

        if (expected) {
            assertTrue(m_rockA.equals(m_rockB) && m_rockB.equals(m_rockA),
                    "True return value expected for " + test + ".");
        } else {
            assertTrue(!m_rockA.equals(m_rockB) && !m_rockB.equals(m_rockA),
                    "False return value expected for " + test + ".");
        }
    }

    @Test
    public void testEqualsDistance() {
        setupEqualAsteroids();
        checkEquality("distance", DIST, DIST, "same distance", true);
        checkEquality("distance", DIST, DIST + 10, "different distance", false);
    }

    @Test
    public void testEqualsTheta() {
        setupEqualAsteroids();
        checkEquality("theta", THETA, THETA, "same theta", true);
        checkEquality("theta", THETA, THETA - 10.23, "different theta", false);
    }

    @Test
    public void testEqualsPhi() {
        setupEqualAsteroids();
        checkEquality("phi", PHI, PHI, "same phi", true);
        checkEquality("phi", PHI, PHI * -1, "different phi", false);
    }

    @Test
    public void testEqualsSpeed() {
        setupEqualAsteroids();
        checkEquality("speed", SPEED, SPEED, "same speed", true);
        checkEquality("speed", SPEED, SPEED + 300, "different speed", false);
    }

    @Test
    public void testEqualsSize() {
        setupEqualAsteroids();
        checkEquality("size", SIZE, SIZE, "same size", true);
        checkEquality("size", SIZE, SizeCategory.SMALL, "different size", false);
    }

    @Test
    public void testCtorSizeNull() {
        assertThrows(NullPointerException.class, () -> {
            new Asteroid(DIST, THETA, PHI, SPEED, null);
        });
    }

    @Test
    public void testCtor() {
        double dist = (double) getPrivateField(m_rockA, m_rockA.getClass(), "distance");
        assertEquals(DIST, dist, DELTA, "Distance value not as expected.");

        double theta = (double) getPrivateField(m_rockA, m_rockA.getClass(), "theta");
        assertEquals(THETA, theta, DELTA, "Theta value not as expected.");

        double phi = (double) getPrivateField(m_rockA, m_rockA.getClass(), "phi");
        assertEquals(PHI, phi, DELTA, "Phi value not as expected.");

        int speed = (int) getPrivateField(m_rockA, m_rockA.getClass(), "speed");
        assertEquals(SPEED, speed, "Speed value not as expected.");

        SizeCategory size = (SizeCategory) getPrivateField(m_rockA, m_rockA.getClass(), "size");
        assertEquals(SIZE, size, "Size value not as expected.");
    }

    @Test
    public void testGetDistance() {
        double dist = m_rockA.getDistance();
        assertEquals(DIST, dist, DELTA, "Distance value not as expected.");
    }

    @Test
    public void testGetTheta() {
        double theta = m_rockA.getTheta();
        assertEquals(THETA, theta, DELTA, "Theta value not as expected.");
    }

    @Test
    public void testGetPhi() {
        double phi = m_rockA.getPhi();
        assertEquals(PHI, phi, DELTA, "Phi value not as expected.");
    }

    @Test
    public void testGetSpeed() {
        int speed = m_rockA.getSpeed();
        assertEquals(SPEED, speed, "Speed value not as expected.");
    }

    @Test
    public void testGetSize() {
        SizeCategory size = m_rockA.getSize();
        assertEquals(SIZE, size, "Size value not as expected.");
    }
}
