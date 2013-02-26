package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class QtyVariableRateDiscount implements DiscountStrategy {
    private double discountRate = .15;
    private int minQty = 5;

    public QtyVariableRateDiscount() {}
    
    public QtyVariableRateDiscount(double rate) {
        this.setDiscountRate(rate);
    }
    
    public QtyVariableRateDiscount(double rate, int qty) {
        discountRate = rate;
        minQty = qty;
    }
    
    @Override
    public double getDiscountAmt(double unitPrice, int qty) {
        if(qty >= minQty) {
            return unitPrice * qty * discountRate;
        } else {
            return 0;
        }
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
        QtyVariableRateDiscount test = new QtyVariableRateDiscount(0.10, 5);
        System.out.println("Discount: " + test.getDiscountAmt(10, 5));
    }
    
}
