public class Factorial {
    public static int factorial(int N) {
        if (N == 1)
            return 1;
        else
            return N * factorial(N-1);
    }

    public static void main(String[] args) {
        System.out.print(" 2! (Should be: 2) returned: " + factorial(2) );
        System.out.print(" 5! (Should be: 120) returned: " + factorial(5) );
        System.out.print(" 10! (Should be: 3628800) returned: " + factorial(10) );
    }
}