public class ArrayRotate {
    public static void main(String[] args) {
        int l = args.length;
        int[] nums = new int[l];
        for (int i = 0; i < l; i++){
            nums[i] = Integer.parseInt(args[i]);
        }
        int[] copy = new int[l];
        copy[l-1] = nums[0];
        for (int i = 0; i < l-1; i++){
            copy[i] = nums[i+1];
        }
        for (int i = 0; i < l; i++){
            System.out.print(copy[i] + " ");
        }
        System.out.println();
    }
}
