package discountstrategy;

/**
 * This class implements the discount strategy interface and can apply a 
 * variable rate discount to a product, which is assigned a default of %15.
 * The default value can be changed with setDiscountRate or via the constructor.
 * @author Dan Smith
 * @version 1.00
 */
public class VariableRateDiscount implements DiscountStrategy {
    
    private double discountRate;

    /**
     * Default constructor that gives the discount rate a default value of
     * %15.
     */
    public VariableRateDiscount() {
        discountRate = .15;
    }
    
    /**
     * Constructor that accepts a rate as an argument.
     * @param rate - cannot be less than zero otherwise it will throw an
     * unsupported exception.
     */
    public VariableRateDiscount(double rate) {
        if(rate < 0) {
            throw new UnsupportedOperationException("TO DO");
        } else {
            discountRate = rate;
        }
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
    
//    public static void main(String[] args) {
//        VariableRateDiscount test = new VariableRateDiscount(0.10);
//        System.out.println("Discount: " + test.getDiscountAmt(10, 2));
//    }
    
}
