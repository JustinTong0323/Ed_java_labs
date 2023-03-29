import java.util.Comparator;

public class CartComparatorName extends CartComparator {
    /**
     * Compares its two arguments for order. Returns a negative integer, zero, or a positive integer as the first argument is
     * less than, equal to, or greater than the second.
     *
     * @param cart1 the first shopping cart to be compared.
     * @param cart2 the second shopping cart to be compared.
     * @return a negative integer, zero, or a positive integer as the first argument is less than, equal to, or greater than
     * the second.
     */
    @Override
    public int compare(ShoppingCart cart1, ShoppingCart cart2) {
        if (cart1 == null && cart2 == null) {
            return 0;
        } else if (cart1 == null) {
            return 1;
        } else if (cart2 == null) {
            return -1;
        } else {
            int nameCompare = cart1.getUserName().compareTo(cart2.getUserName());
            int priceCompare = Double.compare(calculateMeanPrice(cart1), calculateMeanPrice(cart2));
            return (nameCompare == 0 && priceCompare == 0) ? 0
                    : (priceCompare == 0) ? nameCompare
                    : priceCompare;
        }
    }

}
