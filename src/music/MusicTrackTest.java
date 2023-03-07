package music;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;


public class MusicTrackTest {

    @Test
    public void testMusicTrack() {
        MusicTrack musicTrack = new MusicTrack("artist1", "title1");
        assertEquals("artist1", musicTrack.getArtist());
        assertEquals("title1", musicTrack.getTitle());
        assertEquals("title1 | artist1", musicTrack.toString());
    }

}
