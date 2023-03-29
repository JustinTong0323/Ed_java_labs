import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class CarTest {

    private static final String COMPARETO_EXPECTED_SIGNATURE = "public int Car.compareTo(Car)";

    private Car m_carA;
    private Car m_carB;

    @BeforeEach
    public void setUp() {
        m_carA = new Car(100);
        m_carB = new Car(120);
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

    private void checkSignature(Object obj, String expectedSign, String methodName, Class<?>... parameterTypes) {
        try {
            Method m = obj.getClass().getDeclaredMethod(methodName, parameterTypes);
            assertEquals(expectedSign, m.toString(), methodName + " signature not as expected.");
        } catch (NoSuchMethodException e) {
            System.err.println("Method not found in " + obj.getClass() + ": " + e);
            e.printStackTrace();
            assertTrue(false, "Method " + methodName + " not found.");
        }
    }

    @Test
    public void testCompareToSignature() {
        checkSignature(m_carA, COMPARETO_EXPECTED_SIGNATURE, "compareTo", Car.class);
    }

    @Test
    public void testComparableInterfaceType() {
        Type[] t = m_carA.getClass().getGenericInterfaces();

        // expected length of one
        assertEquals(1, t.length, "Unexpected number of interfaces implemented.");

        // expected interface to be Comparable<Car>
        assertEquals("java.lang.Comparable<Car>", t[0].toString(), "Unexpected interface type implemented.");
    }

    @Test
    public void testCompareToNullParam() {
        assertThrows(NullPointerException.class, () -> {
            m_carA.compareTo(null);
        });
    }

    @Test
    public void testCompareToSpeed() {
        setPrivateField(m_carA, m_carA.getClass(), "speed", 50);
        setPrivateField(m_carB, m_carB.getClass(), "speed", 70);

        assertTrue(m_carB.compareTo(m_carA) > 0, "Positive return value expected if this car's speed is larger.");
        assertTrue(m_carA.compareTo(m_carB) < 0, "Negative return value expected if this car's speed is smaller.");
    }

    @Test
    public void testCompareToSameSpeed() {
        final int SPEED = 30;
        setPrivateField(m_carA, m_carA.getClass(), "speed", SPEED);
        setPrivateField(m_carB, m_carB.getClass(), "speed", SPEED);

        assertTrue(m_carA.compareTo(m_carB) == 0, "Zero return value expected if both cars have the same speed.");
    }

    @Test
    public void testCtor() {
        int speed = (int) getPrivateField(m_carA, m_carA.getClass(), "speed");
        assertEquals(0, speed, "Unexpected speed initial speed.");

        int maxSpeed = (int) getPrivateField(m_carA, m_carA.getClass(), "maxSpeed");
        assertEquals(100, maxSpeed, "Unexpected maxSpeed.");
    }

    @Test
    public void testCtorNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            Car test = new Car(-59);
        });
    }

    @Test
    public void testGetter() {
        assertEquals(0, m_carA.getSpeed(), "Unexpected speed initial speed.");

        setPrivateField(m_carA, m_carA.getClass(), "speed", 30);
        assertEquals(30, m_carA.getSpeed(), "Unexpected speed.");
    }

    private void checkGas(int delta) {
        int speedBefore = (int) getPrivateField(m_carA, m_carA.getClass(), "speed");
        m_carA.gas(delta);
        int speedAfter = (int) getPrivateField(m_carA, m_carA.getClass(), "speed");
        assertEquals(speedBefore + delta, speedAfter, "Unexpected speed after gas call.");
    }

    @Test
    public void testGas() {
        checkGas(50);
        checkGas(-50);
    }

    private void checkGasLimit(int delta, int expected) {
        setPrivateField(m_carA, m_carA.getClass(), "speed", 30);
        m_carA.gas(delta);
        int speedAfter = (int) getPrivateField(m_carA, m_carA.getClass(), "speed");
        assertEquals(expected, speedAfter, "Unexpected speed after gas call.");
    }

    @Test
    public void testGasLimits() {
        checkGasLimit(500, 100);
        checkGasLimit(-500, 0);
    }
}

