public class ErrorHandlingReturn {
    public static boolean birthdayGreetings(String name, int age) {
        boolean success;

        if (age > 0) {
            System.out.println("All the best to your " + age + ". birthday " + name);
            success = true;
        } else {
            System.err.println("ERROR: The given age must be larger zero but is: " + age);
            success = false;
        }

        return success;
    }

    public static void spam(String[] names, int[] ages){
        final int defaultAge = 20;
        if (names.length == ages.length){
            for (int i = 0; i < names.length; i++){
                boolean success = birthdayGreetings(names[i],ages[i]);
                if (!success)
                    success = birthdayGreetings(names[i], defaultAge);
            }
        }
        else
            System.err.println("ERROR: The given names should have the same number as the given ages.");
    }

    public static void main(String[] args) {
        String[] names = { "Peter", "Sarah", "Ivan" };
        int[] ages = { 23, -5, 35 };
        spam(names,ages);
    }
}
