package music;

public class Favourites {
    private static final int MAX = 5;
    private int counter = 0;
    private MusicTrack[] favouriteMusicTracks = new MusicTrack[MAX];
    public void addTrack(String artist, String title) {
        MusicTrack mt = new MusicTrack(artist, title);
        if (counter >= 5) {
            System.out.println("Sorry, can't add: " + mt +"\n");
        } else {
            this.favouriteMusicTracks[counter] = mt;
        }
        counter++;
    }
    public void showFavourites() {
        for (MusicTrack mt: favouriteMusicTracks) {
            if (mt != null) {
                System.out.println(mt);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Favourites favourites = new Favourites();
        favourites.addTrack("Fun", "Some Nights");
        favourites.addTrack("Oliver Tank", "Help You Breathe");
        favourites.addTrack("Horse Feathers", "Fit Against the Country");
        favourites.addTrack("Emile Sande", "Country House");
        favourites.addTrack("Fun", "Walking the Dog");
        favourites.addTrack("Porcelain Raft", "Put Me To Sleep");
        favourites.showFavourites();
    }
}
