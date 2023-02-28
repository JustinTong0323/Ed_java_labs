public class DNAStrandTester {
    public static void summarise(DNAStrand dna) {
        System.out.println("Original DNA Sequence: " + dna);
        if (dna.isValidDNA()) {
            System.out.println("Is valid");
            System.out.println("Complement: " + dna.complementWC());
            System.out.println("WC Palindrome: " + dna.palindromeWC());
        }
        else {
            System.out.println("Not Valid DNA");
        }
    }

    public static void main(String[] args) {
        DNAStrand test1 = new DNAStrand("ABCD");
        DNAStrand test2 = new DNAStrand("ATCGGGC");
        DNAStrand test3 = new DNAStrand("ATCGGGTCAGAC");
        summarise(test1);
        summarise(test2);
        summarise(test3);

    }
}
