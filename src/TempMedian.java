import java.util.Arrays;

public class TempMedian {

    /** Print the temperatures. */
    public static void printTemp(int[] temp){
        for (int i : temp){
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int l = args.length;
        int[] temp = new int[l];
        temp[0] = Integer.parseInt(args[0]);
        for (int i = 1; i<l; i++){
            switch (args[i]) {
                case "." -> temp[i] = temp[i - 1];
                case "+" -> temp[i] = temp[i - 1] + 1;
                case "-" -> temp[i] = temp[i - 1] - 1;
            }
        }
        printTemp(temp);

        Arrays.sort(temp);
        printTemp(temp);

        if (l % 2 == 0)
            System.out.println((temp[l/2 - 1] + temp[l/2]) / 2.0f);
        else
            System.out.println(temp[l/2]);

    }
}
