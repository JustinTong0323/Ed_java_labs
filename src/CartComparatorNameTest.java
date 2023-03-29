import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CartComparatorNameTest {

    private static final String COMPARE_EXPECTED_SIGNATURE = "public int CartComparatorName.compare(ShoppingCart,ShoppingCart)";

    private CartComparatorName m_cmp;

    @BeforeEach
    public void setUp() {
        m_cmp = new CartComparatorName();
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
    public void testCompareNSignature() {
        checkSignature(m_cmp, COMPARE_EXPECTED_SIGNATURE, "compare", ShoppingCart.class, ShoppingCart.class);
    }

    @Test
    public void testCompareNExtension() {
        Type[] t = m_cmp.getClass().getGenericInterfaces();

        // expected length of zero
        assertEquals(0, t.length, "Unexpected number of interfaces implemented.");

        // expected to extend CartComparator
        assertEquals("CartComparator", m_cmp.getClass().getSuperclass().getName(), "Unexpected superclass.");
    }

    @Test
    public void testCompareNSingleNull() {
        ShoppingCart cartA = new ShoppingCart("testCartA");
        ShoppingCart cartB = new ShoppingCart("testCartB");

        assertTrue(m_cmp.compare(null, cartB) > 0, "Positive return value expected if first parameter is null.");
        assertTrue(m_cmp.compare(cartA, null) < 0, "Negative return value expected if second parameter is null.");

    }

    @Test
    public void testCompareNBothNull() {
        assertTrue(m_cmp.compare(null, null) == 0, "Zero return value expected if both parameters are null.");
    }

    @Test
    public void testCompareNAverageSameName() {
        // avg 41.33..
        ShoppingCart cartA = new ShoppingCart("testCart");
        cartA.addItem(40.0);
        cartA.addItem(46.0);
        cartA.addItem(38.0);
        // avg 21.66..
        ShoppingCart cartB = new ShoppingCart("testCart");
        cartB.addItem(23.0);
        cartB.addItem(32.0);
        cartB.addItem(10.0);

        assertTrue(m_cmp.compare(cartA, cartB) > 0,
                "Positive return value expected if first parameter has larger average and same name.");
        assertTrue(m_cmp.compare(cartB, cartA) < 0,
                "Negative return value expected if second parameter has larger average and same name.");
    }

    @Test
    public void testCompareNAverageEqualSameName() {
        // avg 20
        ShoppingCart cartA = new ShoppingCart("testCart");
        cartA.addItem(10);
        cartA.addItem(20);
        cartA.addItem(30);
        // avg 20
        ShoppingCart cartB = new ShoppingCart("testCart");
        cartB.addItem(10);
        cartB.addItem(20);
        cartB.addItem(30);
        cartB.addItem(20);

        assertTrue(m_cmp.compare(cartA, cartB) == 0,
                "Zero return value expected if both parameters have the same average and same name.");
    }

    @Test
    public void testCompareNNameSameAverage() {
        // avg 20
        ShoppingCart cartA = new ShoppingCart("testCartA");
        cartA.addItem(10);
        cartA.addItem(20);
        cartA.addItem(30);
        // avg 20
        ShoppingCart cartB = new ShoppingCart("testCartB");
        cartB.addItem(10);
        cartB.addItem(20);
        cartB.addItem(30);
        cartB.addItem(20);

        assertTrue(m_cmp.compare(cartA, cartB) < 0,
                "Negative return value expected if first parameter is lexicographically smaller.");
        assertTrue(m_cmp.compare(cartB, cartA) > 0,
                "Positive return value expected if second parameter is lexicographically smaller.");
    }
}
