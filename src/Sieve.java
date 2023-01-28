import java.util.Arrays;

public class Sieve {
    public static void main(String[] args) {
        int n = 20;
        int[] sieved_numbers = new int[n-1];
        for (int i = 0; i <= n - 2; i++)
            sieved_numbers[i] = i + 2;
        int p = 2;
        while (p < n){
            System.out.print(p + " ");
            for (int i = 0; i <= n - 2; i++)
                if (sieved_numbers[i] % p == 0)
                    sieved_numbers[i] = 0;
            for (int i : sieved_numbers){
                if (i != 0){
                    p = i;
                    break;
                }
                p = n + 1;
            }
        }
        System.out.println();
    }
}
