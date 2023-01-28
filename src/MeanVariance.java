public class MeanVariance {
    public static void main(String[] args) {
        int l = args.length;
        float[] nums = new float[l];
        for (int i = 0; i < l; i++){
            nums[i] = Float.parseFloat(args[i]);
        }

        float mean = 0.0f;
        for (float n : nums){
            mean += n;
        }
        mean /= l;

        float variance = 0.0f;
        for (float n : nums){
            variance += Math.pow((n - mean), 2);
        }
        variance /= l;

        System.out.println(mean);
        System.out.println(variance);

    }
}
