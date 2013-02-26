/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author dsmith110
 */
public interface DiscountStrategy {

    double getDiscountAmt(double unitPrice, int qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
