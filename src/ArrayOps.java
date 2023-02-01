public class ArrayOps {

    public static double findMax(double[] data) {
        double max = data[0];
        for (double num : data){
            if (num > max)
                max = num;
        }
        return max;
    }

    public static double[] normalise(double data[]) {
        double sum = 0.0;
        for (double num : data){
            sum += num;
        }
        double[] copy = data.clone();
        for (int i = 0; i < data.length; i++){
            copy[i] /= sum;
        }
        return copy;
    }

    public static void normaliseInPlace(double data[]) {
        double sum = 0.0;
        for (double num : data){
            sum += num;
        }
        for (int i = 0; i < data.length; i++){
            data[i] /= sum;
        }
    }

    public static double[] reverse(double[] data) {
        int l = data.length;
        double[] copy = data.clone();
        for (int i = 0; i < l; i++){
            copy[l-1-i] = data[i];
        }
        return copy;
    }

    public static void reverseInPlace(double[] data) {
        int l = data.length;
        double[] copy = data.clone();
        for (int i = 0; i < l; i++){
            data[l-1-i] = copy[i];
        }
    }

    public static void swap(double[] data1, double[] data2) {
        for (int i = 0; i < data1.length; i++) {
            double temp = data1[i];
            data1[i] = data2[i];
            data2[i] = temp;
        }
    }

}