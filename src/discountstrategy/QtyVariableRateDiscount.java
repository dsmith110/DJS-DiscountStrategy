package discountstrategy;

/**
 * This class implements the DiscountStrategy interface and can apply a 
 * quantity discount to products. It also can set the discount amount and 
 * minimum quantity the user decides. It has a default value of %15 discount
 * and minimum quantity of five.
 * @author Dan Smith
 * @version 1.00
 */
public class QtyVariableRateDiscount implements DiscountStrategy {
    private double discountRate;
    private int minQty;
    private double defaultDiscountRate = .15;
    private int defaultMinQty = 5;

    /**
     * Default constructor that assigns default values that the author 
     * chooses. Currently assigns a %15 discount rate and five to minimum
     * quantity.
     */
    public QtyVariableRateDiscount() {
        discountRate = defaultDiscountRate;
        minQty = defaultMinQty;
    }
    
    /**
     * Constructor that accepts a rate as an argument and calls the 
     * setDiscountRate if it's valid.
     * @param rate - If rate is less than zero throws new unsupported exception.
     */
    public QtyVariableRateDiscount(double rate) {
        if(rate < 0) {
            this.setDiscountRate(rate);
        } else {
            throw new UnsupportedOperationException("TO DO");
        }
        
    }
    
    /**
     * Constructor accepts rate and quantity as arguments. If rate and 
     * quantity are valid then it calls setDiscountRate and setMinQty.
     * If rate and quantity are less than zero it throws an exception.
     * @param rate - must be zero or above or throws exception
     * @param qty - must be zero or above or throws exception
     */
    public QtyVariableRateDiscount(double rate, int qty) {
        if(rate < 0 || qty < 0) {
            discountRate = rate;
            minQty = qty;
        } else {
            throw new UnsupportedOperationException("TO DO");
        }
    }
    
    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        if(qty >= minQty) {
            return unitPrice * qty * discountRate;
        } else {
            return 0;
        }
    }

    public int getMinQty() {
        return minQty;
    }

    public void setMinQty(int minQty) {
        this.minQty = minQty;
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
//        QtyVariableRateDiscount test = new QtyVariableRateDiscount(0.10, 5);
//        System.out.println("Discount: " + test.getDiscountAmt(10, 5));
//    }
    
}
