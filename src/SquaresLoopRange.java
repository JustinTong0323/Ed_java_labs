public class SquaresLoopRange {
    public static void main(String[] args) {
        int start = Integer.parseInt(args[0]);
        int stop = Integer.parseInt(args[1]);
        if (start <= stop){
            for (int i = start; i <= stop; i++){
                System.out.print(i*i + " ");
            }
        }
        else
            System.out.print("Start-limit greater than stop-limit!");
        System.out.println();
    }
}
