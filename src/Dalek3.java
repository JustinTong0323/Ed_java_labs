import java.util.ArrayList;
import java.util.Arrays;

public class Dalek3 {
    private ArrayList<String> sayings = new ArrayList<>();
    public void setSayings(String[] sayings) {
        this.sayings.addAll(Arrays.asList(sayings));
    }
    public void speak() {
        int n = sayings.size();
        if (n > 0) {
            System.out.println(sayings.get((int) (Math.random() * n)));
        } else {
            System.out.println("No utterances installed!");
        }
    }
    public void addSaying(String saying) {
        this.sayings.add(saying);
    }

    public static void main(String[] args) {
        Dalek2 d1 = new Dalek2();
        String[] u1 = {"Exterminate, Exterminate!", "I obey!",
                "Exterminate, annihilate, DESTROY!", "You cannot escape.",
                "Daleks do not feel fear.", "The Daleks must survive!"};
        d1.setSayings(u1);

        System.out.println("\nDalek d1 says: ");
        for (int i = 0; i < 10; i++) {
            d1.speak();
        }

        System.out.println("\nDalek d2 says: ");
        Dalek2 d2 = new Dalek2();
        String[] u2 = {"I obey!"};
        d2.setSayings(u2);

        for (int i = 0; i < 10; i++) {
            d2.speak();
        }
    }

}
