import java.util.Comparator;

public class CartComparator implements Comparator<ShoppingCart> {
    /**
     * Calculates the mean price of the items in the shopping cart.
     *
     * @param shoppingCart the shopping cart to calculate the mean price for.
     * @return the mean price of the items in the shopping cart.
     */
    protected double calculateMeanPrice(ShoppingCart shoppingCart) {
        return shoppingCart.getItemPrices().stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

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
        return (cart1 == null && cart2 == null) ? 0
                : (cart1 == null) ? 1
                : (cart2 == null) ? -1
                : Double.compare(calculateMeanPrice(cart1), calculateMeanPrice(cart2));
    }
}
