package discountstrategy;


import java.text.NumberFormat;
/**
 *
 * @author Dan Smith
 */
public class LineItem {
    private Product product;
    private int qty;
    
//    FakeDatabase fakeDatabase = new FakeDatabase();

    public LineItem(String prodId, int qty) {
        this.qty = qty;
        this.product = findProduct(prodId);
    }

    public final Product findProduct(String prodId) {
        // Validate
        FakeDatabase fakeDatabase = new FakeDatabase();
        this.product = fakeDatabase.findProduct(prodId);
        return product;
    }
    
    public String getLineItemDetails() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        String lineItemDetails = 
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
