public class Mode {
    public static void main(String[] args) {
        int[] count = new int[10];
        for (String i : args)
            count[Integer.parseInt(i)]++;
        int max = 0;
        for (int i = 0; i < 10; i++){
            if (count[i] == 0)
                System.out.println("[" + i + "s: " + count[i] + "]");
            else
                System.out.println("[" + i + "s: " + count[i] + "] " + ".".repeat(count[i]));
            if (count[i] > count[max])
                max = i;
        }
        System.out.println("Mode: " + max);
    }
}
