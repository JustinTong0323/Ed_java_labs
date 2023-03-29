public class Asteroid {
    private double distance;
    private double theta;
    private double phi;
    private int speed;
    private SizeCategory size;

    public Asteroid(double distance, double theta, double phi, int speed, SizeCategory size) {
        this.distance = distance;
        this.theta = theta;
        this.phi = phi;
        this.speed = speed;
        if (size != null) {
            this.size = size;
        } else {
            throw new NullPointerException("size cannot be null");
        }
    }

    public double getDistance() {
        return distance;
    }

    public double getTheta() {
        return theta;
    }

    public double getPhi() {
        return phi;
    }

    public int getSpeed() {
        return speed;
    }

    public SizeCategory getSize() {
        return size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Asteroid)) return false;

        Asteroid asteroid = (Asteroid) o;

        if (Double.compare(asteroid.getDistance(), getDistance()) != 0) return false;
        if (Double.compare(asteroid.getTheta(), getTheta()) != 0) return false;
        if (Double.compare(asteroid.getPhi(), getPhi()) != 0) return false;
        if (getSpeed() != asteroid.getSpeed()) return false;
        return getSize() == asteroid.getSize();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getDistance());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getTheta());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getPhi());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getSpeed();
        result = 31 * result + getSize().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "distance=" + distance +
                ", theta=" + theta +
                ", phi=" + phi +
                ", speed=" + speed +
                ", size=" + size +
                '}';
    }
}