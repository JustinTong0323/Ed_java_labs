public class SplitPathName {
    public static String[] splitPath(String s) {
        String[] components = new String[4];
        int l = s.length();
        int slash_index = s.lastIndexOf("/");
        int dot_index = s.lastIndexOf(".");
        components[0] = s.substring(0, slash_index + 1);
        components[1] = s.substring(slash_index + 1);
        if (dot_index != -1) {
            components[2] = s.substring(slash_index + 1, dot_index);
            components[3] = s.substring(dot_index);
        } else {
            components[2] = components[1];
            components[3] = "";
        }


        return components;

    }

    public static void main(String[] args) {
        for (String i : args) {
            String[] components = splitPath(i);
            System.out.printf("File: %s Type: %s [%s]\n",components[1],components[3],components[0]);
        }

    }
}
