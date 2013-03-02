package discountstrategy;

/**
 * Interface that low level classes implement to calculate the discount applied
 * to a product. Implementations will vary, but the classes must override these
 * methods.
 * @author Dan Smith
 * @version 1.00
 */
public interface DiscountStrategy {

    double getDiscountAmt(double unitPrice, int qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
