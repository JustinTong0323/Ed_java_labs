public class DNAStrand {
    private final String[] DNAStrand;

    public DNAStrand(String DNAStrand) {
        if (DNAStrand.equals("")) this.DNAStrand = null;
        else this.DNAStrand = DNAStrand.split("");
    }

    public boolean isValidDNA() {
        if (DNAStrand == null) return false;
        for (String i : DNAStrand) {
            if (!"ATCG".contains(i)) {
                return false;
            }
        }
        return true;
    }

    public String complementWC() {
        StringBuilder complementWc = new StringBuilder();
        for (String i : DNAStrand) {
            switch (i) {
                case "A" -> complementWc.append("T");
                case "T" -> complementWc.append("A");
                case "C" -> complementWc.append("G");
                case "G" -> complementWc.append("C");
            }
        }
        return complementWc.toString();
    }

    public String palindromeWC() {
        StringBuilder palindromeWC = new StringBuilder();
        for (int i = complementWC().length() - 1; i >= 0; i--) {
            palindromeWC.append(complementWC().charAt(i));
        }
        return palindromeWC.toString();
    }

    public boolean containsSequence(String seq) {
        return toString().contains(seq);
    }

    @Override
    public String toString() {
        StringBuilder toString = new StringBuilder();
        for (String i : DNAStrand) {
            toString.append(i);
        }
        return toString.toString();
    }

    public static void main(String[] args) {

    }
}
