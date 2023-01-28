public class ArithmeticSeries {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int counter = 1;
        int sum = 0;
        while (counter <= n){
            sum += counter;
            counter++;
        }
        System.out.println(sum);
    }
}
