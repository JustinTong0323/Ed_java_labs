public class Car implements Comparable<Car> {
    private int speed;
    private final int maxSpeed;

    public Car(int maxSpeed) {
        if (maxSpeed < 0) {
            throw new IllegalArgumentException("maxSpeed must be positive");
        }
        this.maxSpeed = maxSpeed;
    }

    public int getSpeed() {
        return speed;
    }

    public void gas(int delta) {
        speed += delta;
        if (speed > maxSpeed) {
            speed = maxSpeed;
        } else if (speed < 0) {
            speed = 0;
        }
    }

    @Override
    public int compareTo(Car other) {
        if (this.equals(other)) {
            return 0;
        }
        return Integer.compare(speed, other.speed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return getSpeed() == car.getSpeed();
    }

    @Override
    public int hashCode() {
        return getSpeed();
    }
}