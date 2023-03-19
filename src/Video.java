import java.util.ArrayList;

public class Video {
    private final String title;
    private final ArrayList<Integer> ratings;
    private double averageRating = 0.0;
    private boolean checkedOut = false;

    public Video(String title) {
        this.title = title;
        this.ratings = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }


    public boolean addRating(int rating) {
        if (1 <= rating && rating <= 5) {
            ratings.add(rating);
            averageRating = ratings.stream().mapToInt(Integer::intValue).average().orElse(0.0);
            return true;
        } else {
            System.out.println(rating + " should be between 1 and 5.");
            return false;
        }
    }

    public double getAverageRating() {
        return averageRating;
    }

    public boolean checkOut() {
        if (checkedOut) {
            System.out.println(this + " is already checked out.");
            return false;
        } else {
            checkedOut = true;
            return true;
        }
    }

    public boolean returnToStore() {
        if (!checkedOut) {
            System.out.println(this + " is not checked out.");
            return false;
        } else {
            checkedOut = false;
            return true;
        }
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    @Override
    public String toString() {
        return String.format("Video[title=\"%s\", checkedOut=%s]", getTitle(), isCheckedOut());
    }

}
