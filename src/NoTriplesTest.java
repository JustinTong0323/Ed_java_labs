import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class NoTriplesTest {

    @Test
    public void testNoTriples() {
        // Too short
        assertTrue(NoTriples.noTriples(new int[] { 5 }));
        assertTrue(NoTriples.noTriples(new int[] { 5, 5 }));

        // Contains triples
        assertFalse(NoTriples.noTriples(new int[] { 5, 5, 5 }));
        assertFalse(NoTriples.noTriples(new int[] { 1, 1, 2, 2, 2, 1 }));
        assertFalse(NoTriples.noTriples(new int[] { 1, 1, 1, 2, 2, 2, 1 }));

        // Does not contain triples
        assertTrue(NoTriples.noTriples(new int[] { 1, 1, 2, 2, 1 }));
    }

}
