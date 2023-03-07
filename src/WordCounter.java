import java.util.Collection;
import java.util.HashMap;

public class WordCounter {
    private HashMap<Integer, Integer> freq = new HashMap<>();

    public WordCounter(String[] tokens) {
        wordLengthFreq(tokens);
    }

    public void wordLengthFreq(String[] tokens) {
        freq.clear();
        for (String word : tokens) {
            int l = word.length();
            if (freq.containsKey(l)) {
                freq.put(l, freq.get(l) + 1);
            } else {
                freq.put(l, 1);
            }
        }
    }

    public HashMap<Integer, Integer> getFreqDist() {
        return freq;
    }

    public int maxVal() {
        int maxValue = 0;
        for (int value : freq.values()) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public int maxKey() {
        int maxKey = -1;
        for (int key : freq.keySet()) {
            maxKey = Math.max(maxKey, key);
        }
        return maxKey;
    }

    public double[] map2array() {
        int total = maxVal();

        double[] freq_dist = new double[maxKey() + 1];
        for (int key : freq.keySet()) {
            freq_dist[key] = (double) freq.get(key) / total * 100;
        }
        return freq_dist;
    }

    public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer("https://www.inf.ed.ac.uk/teaching/courses/inf1/op/2020/labs/resources/austen-emma.txt");
        String[] tokens = tokenizer.getTokens();

        WordCounter wordCounter = new WordCounter(tokens);
        System.out.println(wordCounter.getFreqDist());
        double[] points = wordCounter.map2array();
        for (double i : points) {
            System.out.println(i);
        }
        int n = points.length;
        StdDraw.clear();
        StdDraw.setXscale(0, n - 1);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(0.5 / n);
        for (int i = 0; i < n; i++) {
            StdDraw.line(i, 0, i, points[i]);
        }
    }
}
