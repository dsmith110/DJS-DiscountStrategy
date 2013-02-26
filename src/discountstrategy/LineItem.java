package discountstrategy;
/*
 * Make method static that class can access
 */

import java.text.NumberFormat;
/**
 *
 * @author Dan Smith
 */
public class LineItem {
    private Product product;
    private int qty;

    public LineItem(String prodId, int qty) {
        this.qty = qty;
        this.product = findProduct(prodId);
    }

    // Looks in "db" for product information, if found assigns reference
    public final Product findProduct(String prodId) {
        // Validate
        FakeDatabase fakeDatabase = new FakeDatabase();
        this.product = fakeDatabase.findProduct(prodId);
        return product;
    }
    
    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
    
    public String getProductName() {
        return product.getProdName();
    }
    
    public String getProductId() {
        return product.getProdId();
    }
    
    public double getDiscountAmt() {
        return product.getDiscountAmt(qty);
    }
    
    public double getProductUnitPrice() {
        return product.getUnitPrice();
    }
    
    public double getPriceBeforeDiscount() {
        return qty * getProductUnitPrice();
    }
    
    public double getDiscountedPrice() {
        return getPriceBeforeDiscount() - getDiscountAmt();
    }

}
