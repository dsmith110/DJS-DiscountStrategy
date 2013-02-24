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
    
    // Makes a string with all the line item details
    public String getLineItemDetails() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String lineItemDetails = 
                // Used for padding (makes outputs nice)
                String.format("%-8s %-18s %8s %8s %10s %8s", 
                this.getProductId(),
                this.getProductName(),
                this.getQty(),
                nf.format(this.getPriceBeforeDiscount()),
                nf.format(this.getDiscountAmt()),
                nf.format(this.getDiscountedPrice())) + "\n";
        return lineItemDetails;
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
    
    
    
    public static void main(String[] args) {
        LineItem test = new LineItem("A101", 2);
        System.out.println(test.getPriceBeforeDiscount());
        System.out.println(test.getDiscountAmt());
        System.out.println(test.getDiscountedPrice());
        
    }
}
