package discountstrategy;

/**
 * Class holds information about the product Id, product name, unit price of the
 * product and the discount strategy applied to the product.
 * @author Dan Smith
 * @version 1.00
 */
public class Product {
    private String prodId;
    private String prodName;
    private double unitPrice;
    private DiscountStrategy discount = new NoDiscount();

    public Product() {}

    /**
     * Constructor accepts product Id, product name, and unit price as arguments
     * and assigns them to the respective properties in the class.
     * @param prodId - must be valid string
     * @param prodName - must be valid string
     * @param unitPrice - must be greater than 0
     */
    public Product(String prodId, String prodName, double unitPrice) {
        // Needs validation
        this.prodId = prodId;
        this.prodName = prodName;
        this.unitPrice = unitPrice;
    }

    public Product(String prodId, String prodName, double unitPrice, 
            DiscountStrategy discount) {
        this.prodId = prodId;
        this.prodName = prodName;
        this.unitPrice = unitPrice;
        this.discount = discount;
    }

    /**
     * Used to calculate the discounted amount of the product. Accepts a quantity
     * as an argument, which must be greater than 0, and returns a the discounted
     * amount.
     * @param qty - Must be greater than 0
     * @return - discounted amount of the product
     */
    public double getDiscountAmt(int qty) {
        if(qty < 0) {
            throw new UnsupportedOperationException("TO DO");
        } else {
            return discount.getDiscountAmt(unitPrice, qty);
        }
    }
    
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public DiscountStrategy getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    
//    public static void main(String[] args) {
//        Product test = new Product("101", "Hat", 10);
//        test.setDiscount(new VariableRateDiscount());
//        System.out.println(test.getDiscountAmt(1));
//    }
    
}
