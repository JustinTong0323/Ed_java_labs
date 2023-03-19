import java.util.ArrayList;
import java.util.Arrays;

public class VideoStore {
    private final ArrayList<Video> videoInventory;

    public VideoStore() {
        videoInventory = new ArrayList<>();
    }

    public boolean addVideo(String title) {
        for (Video video : videoInventory) {
            if (video.getTitle().equals(title)) {
                System.out.println(title + " is already in stock.");
                return false;
            }
        }
        videoInventory.add(new Video(title));
        return true;
    }

    public Video getVideo(String title) {
        for (Video video : videoInventory) {
            if (video.getTitle().equals(title)) {
                return video;
            }
        }
        System.out.println("Sorry, cannot find the requested video in the catalogue");
        return null;
    }

    public boolean checkOutVideo(String title) {
        Video video = getVideo(title);
        if (video != null) {
            return video.checkOut();
        } else {
            return false;
        }
    }

    public boolean returnVideo(Video video) {
        if (videoInventory.contains(video)) {
            return video.returnToStore();
        } else {
            System.out.println("Sorry, this video did not come from this store");
            return false;
        }
    }

    public void rateVideo(Video video, int rating) {
        video.addRating(rating);
    }

    public double getAverageRatingForVideo(Video video) {
        return video.getAverageRating();
    }

    public Video[] getCheckedOut() {
        ArrayList<Video> checkedOutVideos = new ArrayList<>();
        for (Video video : videoInventory) {
            if (video.isCheckedOut()) {
                checkedOutVideos.add(video);
            }
        }
        return checkedOutVideos.toArray(new Video[0]);
    }

    public Video mostPopular() {
        Video mostPopularVideo = null;
        double highestRating = 0.0;
        for (Video video : videoInventory) {
            double averageRating = video.getAverageRating();
            if (averageRating > highestRating) {
                mostPopularVideo = video;
                highestRating = averageRating;
            }
        }
        return mostPopularVideo;
    }
}
