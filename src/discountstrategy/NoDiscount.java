package discountstrategy;

/**
 * Class applies no discount to an item that is passed. It is implementing the
 * DiscountStrategy interface so it must override all those methods.
 * @author Dan Smith
 * @version 1.00
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
