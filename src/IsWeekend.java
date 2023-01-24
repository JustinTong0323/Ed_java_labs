public class IsWeekend {
    public static void main(String[] args) {
        String currentDay = args[0];
        int n = Integer.parseInt(args[1]);
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int currentDayIndex = -1;
        for (int i = 0; i < weekDays.length; i++){
            if (weekDays[i].equals(currentDay)){
                currentDayIndex = i;
                break;
            }
        }
        int futureDayIndex = (currentDayIndex + n) % 7;
        System.out.println(weekDays[futureDayIndex]);
        if (futureDayIndex <= 4)
            System.out.println("not weekend yet...");
        else
            System.out.println("WEEKEND!");
    }
}
