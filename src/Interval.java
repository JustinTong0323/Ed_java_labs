public class Interval {
    private double left;
    private double right;

    public Interval(double left, double right) {
        this.left = left;
        this.right = right;
    }

    public double getLeft() {
        return left;
    }

    public double getRight() {
        return right;
    }

    public boolean doesContain(double x) {
        return left <= x && x <= right;
    }

    public boolean isEmpty() {
        return left > right;
    }

    public boolean intersects(Interval b) {
        return !isEmpty() && (doesContain(b.getLeft()) || doesContain(b.getRight()));
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Interval: (EMPTY)";
        } else {
            return String.format("Interval: [%s, %s]", left, right);
        }
    }
}
