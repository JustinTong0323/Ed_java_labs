public class DateFashion {

    public static int dateFashion(int you, int date){
        int eligible = 0;
        if (you <= 2 || date <= 2)
            eligible = 0;
        else if (you >=8 || date >= 8)
            eligible = 2;
        else
            eligible = 1;
        return eligible;
    }

    public static void main(String[] args) {
        int you = Integer.parseInt(args[0]);
        int date = Integer.parseInt(args[1]);
        System.out.println(dateFashion(you,date));
    }
}
