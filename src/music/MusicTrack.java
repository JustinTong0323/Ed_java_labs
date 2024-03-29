package music;

public class MusicTrack {
    private String artist;
    private String title;

    public MusicTrack(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return title + " | " + artist;
    }
}
