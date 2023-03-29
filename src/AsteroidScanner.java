import java.util.*;

public class AsteroidScanner {
    public static Set<Asteroid> deduplicate(List<Asteroid> data) {
        HashSet<Asteroid> deduplicatedData = new HashSet<>();
        int counter = 0;
        for (Asteroid datum : data) {
            if (datum == null) {
                continue;
            }
            if (!deduplicatedData.add(datum)) {
                counter++;
            }
        }
        System.out.printf("%d duplicate asteroids found.%n",counter);
        return deduplicatedData;
    }

    public static void main(String[] args) {
        List<Asteroid> data = new ArrayList<>();
        data.add(new Asteroid(-9684.59,270.82,-132.84,551,SizeCategory.MEDIUM));
        data.add(new Asteroid(15303.82,-138.47,166.58,-639,SizeCategory.LARGE));
        data.add(new Asteroid(1952.42,106.64,94.28,-173,SizeCategory.LARGE));
        data.add(new Asteroid(15303.82,-138.47,166.58,-639,SizeCategory.LARGE));
        data.add(new Asteroid(2732.31,273.07,358.68,-284,SizeCategory.LARGE));
        data.add(new Asteroid(-13568.4,272.63,-236.04,-669,SizeCategory.SMALL));
        data.add(new Asteroid(-9730.6,-14.46,233.29,371,SizeCategory.MEDIUM));
        data.add(new Asteroid(-4486.87,-77.56,-317.61,686,SizeCategory.LARGE));
        data.add(new Asteroid(-4486.87,-77.56,-317.61,686,SizeCategory.LARGE));
        data.add(new Asteroid(-7199.88,-247.91,275.97,-730,SizeCategory.SMALL));
        data.add(new Asteroid(2684.32,-164.67,97.95,998,SizeCategory.LARGE));
        data.add(new Asteroid( 9666.93,339.71,336.86,-959,SizeCategory.MEDIUM));
        data.add(new Asteroid(-9730.6,-14.46,233.29,371,SizeCategory.MEDIUM));
        HashSet<Asteroid> set = (HashSet<Asteroid>) deduplicate(data);
        System.out.println(Arrays.toString(set.toArray()));

    }
}
