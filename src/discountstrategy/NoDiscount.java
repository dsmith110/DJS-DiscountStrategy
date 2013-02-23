package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class NoDiscount implements DiscountStrategy {

    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        return 0;
    }

    @Override
    public double getDiscountRate() {
        return 0;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        
    }
    
}
