import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OneTimePadDecipherTest {

    @Test
    public void testDecipher() {
        assertEquals("YOUMANAGEDIT", OneTimePadDecipher.decipher("uvufsghktdal", "WHATSTHEPASSWORD"));

        assertEquals("YOUCANDECIPHEROK", OneTimePadDecipher.decipher("wconlahzgzgleuai", "YOULLNEVERREADMYONETIMEPAD"));

        assertEquals("IS THIS SECURE", OneTimePadDecipher.decipher("sw itmn jcxyic", "KEEPMEVERYVERYSAFE"));
    }
}