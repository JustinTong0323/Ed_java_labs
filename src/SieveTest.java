import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

/**
 * Test Sieve behaves as expected
 * 
 */
public class SieveTest {

    /**
     * Temporarily captures the output to the standard output stream, then
     * restores the standard output stream once complete.
     * 
     * Note: the implementation details of this function are advanced. If you
     * don't understand it just now, don't worry.
     * 
     * @param args
     *            arguments to pass to main function of class to be tested
     * @return output result of calling main function of class to be tested
     */
    private String captureOutputOfMain(String[] args) {
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        try {
            Sieve.main(args);
        }
        finally {
            System.setOut(originalOut);
        }
        return outputStream.toString().trim();
    }
    
    @Test
    public void testCallingMain() {
        // Call Sieve.main() and check the output is as expected.
        String result = captureOutputOfMain(null);
        assertEquals("2 3 5 7 11 13 17 19", result);
    }
}
