package discountstrategy;

/**
 * This class takes a product Id and and sends it to a database object which
 * then assigns the product object that information. It holds a reference to
 * a product object as well as a property for the quantity of the product.
 * In addition to that it also has methods to get a discounted amount and 
 * calculating prices for specific products.
 * @author Dan Smith
 * @version 1.00
 */
public class LineItem {
    private Product product;
    private int qty;

    /**
     * Constructor that accepts prodId and qty as arguments and assigns them
     * to variables if they are valid.
     * @param prodId - Must be in correct format or it will throw an exception
     * and not null.
     * @param qty - must be greater than 0 or it will throw an exception.
     */
    public LineItem(String prodId, int qty) {
        // Needs validation
        this.qty = qty;
        this.product = findProduct(prodId);
    }

    /**
     * Accepts a prodId as an argument and instantiates a "DB" object. Passes
     * the product Id to the database method findProduct and assigns the product
     * what is returned from the query.
     * @param prodId - Must be valid product Id format or throws exception
     * @return - Product information
     */
    public final Product findProduct(String prodId) {
        if(prodId == null || prodId.equals("")) {
            throw new UnsupportedOperationException("TO DO");
        } else {
            FakeDatabase fakeDatabase = new FakeDatabase();
        this.product = fakeDatabase.findProduct(prodId);
        return product;
        }
    }
    
    /**
     * Method returns information address of product
     * @return - address of product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Returns integer value of quantity assigned
     * @return - qty int value
     */
    public int getQty() {
        return qty;
    }

    /**
     * Accepts an int value for quantity as an argument.
     * @param qty - if the value is less than 0 then it throws an exception.
     */
    public void setQty(int qty) {
        if(qty < 0) {
            throw new UnsupportedOperationException("TO DO");
        } else {
            this.qty = qty;
        }
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
