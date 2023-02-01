import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class OneTimePadEncipherTest {

    @Test
    public void testCharToInt() {
        assertEquals(0, OneTimePadEncipher.charToInt('a'));
        assertEquals(25, OneTimePadEncipher.charToInt('z'));
        assertEquals(0, OneTimePadEncipher.charToInt('A'));
        assertEquals(25, OneTimePadEncipher.charToInt('Z'));
    }

    @Test
    public void testIntToChar() {
        assertEquals('a', OneTimePadEncipher.intToChar(0));
        assertEquals('z', OneTimePadEncipher.intToChar(25));
    }

    @Test
    public void testIsAlpha() {
        assertTrue(OneTimePadEncipher.isAlpha('A'));
        assertTrue(OneTimePadEncipher.isAlpha('Z'));
        assertTrue(OneTimePadEncipher.isAlpha('a'));
        assertTrue(OneTimePadEncipher.isAlpha('Z'));
        assertFalse(OneTimePadEncipher.isAlpha(' '));
        assertFalse(OneTimePadEncipher.isAlpha('0'));
        assertFalse(OneTimePadEncipher.isAlpha('9'));
        assertFalse(OneTimePadEncipher.isAlpha('.'));
    }

    @Test
    public void testEncipher() {
        assertEquals("eqnvz", OneTimePadEncipher.encipher("HELLO", "XMCKL"));

        assertEquals("eshygwvfltxdwwurkx", OneTimePadEncipher.encipher("SUPERSECRETMESSAGE", "MYSUPERDUPERSECRETCKEY"));

        assertEquals("sw itmn jcxyic", OneTimePadEncipher.encipher("IS THIS SECURE", "KEEPMEVERYVERYSAFE"));
    }

}
