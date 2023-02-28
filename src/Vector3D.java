public class Vector3D {
    private final double x;
    private final double y;
    private final double z;

    public Vector3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public double getR() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public double getTheta() {
        return Math.acos(z / getR());
    }

    public double getPhi() {
        return Math.atan2(y, x);
    }

    public static Vector3D add(Vector3D lhs, Vector3D rhs) {
        return new Vector3D(lhs.getX() + rhs.getX(), lhs.getY() + rhs.getY(), lhs.getZ() + rhs.getZ());
    }

    public static Vector3D subtract(Vector3D lhs, Vector3D rhs) {
        return new Vector3D(lhs.getX() - rhs.getX(), lhs.getY() - rhs.getY(), lhs.getZ() - rhs.getZ());
    }

    public static Vector3D scale(Vector3D v, double scaleFactor) {
        return new Vector3D(v.getX() * scaleFactor, v.getY() * scaleFactor, v.getZ() * scaleFactor);
    }

}
