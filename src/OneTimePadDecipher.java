public class OneTimePadDecipher {
    public static String decipher(String encipheredText, String onetimepad){
        StringBuilder deciphered = new StringBuilder();
        for (int i = 0; i < encipheredText.length(); i++){
            if (encipheredText.charAt(i) == ' ')
                deciphered.append(' ');
            else {
                int num = OneTimePadEncipher.charToInt(encipheredText.charAt(i)) - OneTimePadEncipher.charToInt(onetimepad.charAt(i));
                if (num >= 0)
                    deciphered.append(OneTimePadEncipher.intToChar(num));
                else
                    deciphered.append(OneTimePadEncipher.intToChar(num + 26));
            }
        }
        return deciphered.toString().toUpperCase();
    }
}
