package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class NoDiscount implements DiscountStrategy {
    private final int discount = 0;
    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        return discount;
    }

    @Override
    public double getDiscountRate() {
        return discount;
    }

    @Override
    public void setDiscountRate(double discountRate) {}
    
}
