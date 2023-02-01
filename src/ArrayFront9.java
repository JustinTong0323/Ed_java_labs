public class ArrayFront9 {
    /**
     * @param nums the input array
     * @return the boolean value whether the array is eligible */
    public static boolean arrayFront9(int[] nums) {
        int index = -1; // Initialize index to -1
        for (int i = 0; i < nums.length; i++){ // iterate the array to find the index of int 9
            if (9 == nums[i]){
                index = i;
            }
        }
        return (index != -1 && index <= 3);
        // ADD CODE HERE
    }

    public static void main(String[] args) {
        int N = args.length;
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(args[i]);
        }
        System.out.println(arrayFront9(nums));
    }
}