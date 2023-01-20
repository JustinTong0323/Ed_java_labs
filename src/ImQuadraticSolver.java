public class ImQuadraticSolver {
    public static void main(String[] args) {
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double delta = b * b - 4 * a * c;
        if (a != 0) {
            if (delta >= 0) {
                double x1 = (-b + Math.sqrt(delta)) / 2 * a;
                double x2 = (-b - Math.sqrt(delta)) / 2 * a;
                System.out.println(x1);
                System.out.println(x2);
            }
            else {
                System.out.println((-b/(2*a)) + " + " + (Math.sqrt(-delta)/2*a) + "i");
                System.out.println((-b/(2*a)) + " - " + (Math.sqrt(-delta)/2*a) + "i");
            }
        }
        else
            System.out.println(-c/b);
    }
}
