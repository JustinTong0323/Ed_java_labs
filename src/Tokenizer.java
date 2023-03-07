public class Tokenizer {
    private String[] tokens = {};

    public Tokenizer() {
    }

    public Tokenizer(String fname) {
        tokensFromFile(fname);
    }

    public void tokensFromFile(String fname) {
        In file = new In(fname);
        tokenize(file.readAll());
    }

    public void tokenize(String str) {
        tokens = str.split("\\W+");
    }

    public String[] getTokens() {
        return tokens;
    }

    public int getNumberTokens() {
        return tokens.length;
    }

    public static void main(String[] args) {
        //Use the constructor to read in a file
        Tokenizer t0 = new Tokenizer("https://www.inf.ed.ac.uk/teaching/courses/inf1/op/2020/labs/resources/austen-emma.txt");
        String[] tokens0 = t0.getTokens();

        //Call tokensFromFile() to read in a file
        Tokenizer t1 = new Tokenizer();
        t1.tokensFromFile("https://www.inf.ed.ac.uk/teaching/courses/inf1/op/2020/labs/resources/austen-emma.txt");
        String[] tokens1 = t1.getTokens();

        //Call tokenize() on a string
        Tokenizer t2 = new Tokenizer();
        String sent = "Together we can change the world.";
        t2.tokenize(sent);
        String[] tokens2 = t2.getTokens();
    }
}
