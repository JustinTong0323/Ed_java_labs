public class Scrabble {
    public static void main(String[] args) {
        String word = args[0];
        char[] char_list = word.toCharArray();
        String value1 = "AEILNORSTUaeilnorstu";
        String value2 = "DGdg";
        String value3 = "BCMPbcmp";
        String value4 = "FHVWYfhvmy";
        String value5 = "Kk";
        String value8 = "JXjx";
        String value10 = "QZqz";
        int points = 0;
        for (int i = 0; i < word.length(); i++){
            if (value1.indexOf(char_list[i]) != -1)
                points++;
            else if (value2.indexOf(char_list[i]) != -1)
                points += 2;
            else if (value3.indexOf(char_list[i]) != -1)
                points += 3;
            else if (value4.indexOf(char_list[i]) != -1)
                points += 4;
            else if (value5.indexOf(char_list[i]) != -1)
                points += 5;
            else if (value8.indexOf(char_list[i]) != -1)
                points += 8;
            else if (value10.indexOf(char_list[i]) != -1)
                points += 10;
        }
        System.out.println(points);
    }
}
