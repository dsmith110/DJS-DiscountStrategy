package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class VariableRateDiscount implements DiscountStrategy {
    private double discountRate = .15;

    public VariableRateDiscount() {}
    
    public VariableRateDiscount(double rate) {
        discountRate = rate;
    }
    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        return unitPrice * qty * discountRate;
    }
    
    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public static void main(String[] args) {
        VariableRateDiscount test = new VariableRateDiscount(0.10);
        System.out.println("Discount: " + test.getDiscountAmt(10, 2));
    }
    
}
