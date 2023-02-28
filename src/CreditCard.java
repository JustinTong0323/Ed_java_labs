import java.util.Calendar;

public class CreditCard {
    private int expiryMonth;
    private int expiryYear;
    private String firstName;
    private String lastName;
    private String ccNumber;

    public CreditCard(int expiryMonth, int expiryYear, String firstName, String lastName, String ccNumber) {
        this.expiryMonth = expiryMonth;
        this.expiryYear = expiryYear;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ccNumber = ccNumber;
    }

    public String formatExpiryDate() {
        return String.format("%d/%02d", expiryMonth, expiryYear % 100);
    }

    public String formatFullName() {
        return firstName + " " + lastName;
    }

    public String formatCCNumber() {
        return ccNumber.replaceAll("(.{4})(?=.)", "$1 ");
    }

    public boolean isValid() {
        Calendar now = Calendar.getInstance();
        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH);
        return (year < expiryYear) || (year == expiryYear && month + 1 < expiryMonth);
    }

    @Override
    public String toString() {
        return String.format("Number: %s\n" +
                "Expiration date: %s\n" +
                "Account holder: %s\n" +
                "Is valid: %s", formatCCNumber(), formatExpiryDate(), formatFullName(), isValid());
    }

    public static void main(String[] args) {
        CreditCard cc1 = new CreditCard(10, 2014, "Bob", "Jones", "1234567890123456");
        System.out.println(cc1);
    }
}
