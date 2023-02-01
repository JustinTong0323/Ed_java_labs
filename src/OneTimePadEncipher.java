public class OneTimePadEncipher {

    public static int charToInt(char l) {
        if (l >= 'a')
            return (int) l - 97;
        else
            return (int) l - 65;
        // Should convert a character to an integer, for example 'a' -> 0, 'b' -> 1
    }

    public static char intToChar(int i) {
        return (char) (i + 97);
        // ADD CODE HERE
        // Should convert an integer to a character, for example 0 -> 'a', b -> '1'
        // it should always return lower case char
    }

    public static boolean isAlpha(char c) {
        int i = c;
        if ((i >= 65 && i <= 90) || (i >= 97 && i <= 122))
            return true;
        else
            return false;
        // You do not need to implement this method, but you may find it useful.
    }

    public static String encipher(String original, String onetimepad) {
        StringBuilder ciphertext = new StringBuilder();
        for (int i = 0; i < original.length(); i++){
            if (original.charAt(i) == ' ')
                ciphertext.append(' ');
            else {
                int num = (charToInt(original.charAt(i)) + charToInt(onetimepad.charAt(i))) % 26;
                ciphertext.append(intToChar(num));
            }
        }
        return ciphertext.toString();
    }


    public static void main(String[] args) {
        String ciphertext = encipher("HELLO EVERYBODY", "MYSECRETKETMYSECRETKEY");
        System.out.print(ciphertext);
    }

}