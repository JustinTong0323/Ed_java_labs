public class Rectangle {
    private Point2DDouble topLeft;
    private Point2DDouble bottomRight;

    public Rectangle(Point2DDouble topLeft, Point2DDouble bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle() {
        this.topLeft = new Point2DDouble(0, 0);
        this.bottomRight = new Point2DDouble(1, 1);
    }

    public boolean isPointInside(Point2DDouble pt) {
        return (topLeft.getX() < pt.getX()
                && pt.getX() < bottomRight.getX()
                && topLeft.getY() < pt.getY()
                && pt.getY() < bottomRight.getY());
    }
}
