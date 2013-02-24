package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class NoDiscount implements DiscountStrategy {
    private final int DISCOUNT = 0;
    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        return DISCOUNT;
    }

    @Override
    public double getDiscountRate() {
        return DISCOUNT;
    }

    @Override
    public void setDiscountRate(double discountRate) {}
    
}
