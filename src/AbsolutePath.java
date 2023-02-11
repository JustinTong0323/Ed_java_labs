public class AbsolutePath {
    public static String ensureAbsolute(String path) {
        String currentDir = System.getProperty("user.dir");
        if (path.charAt(0) == '/'){
            return path;
        } else {
            return currentDir + "/" + path;
        }

    }

    public static String[] absoluteSplitPath(String s) {
        return SplitPathName.splitPath(ensureAbsolute(s));
    }

}
