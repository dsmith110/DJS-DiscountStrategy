package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class Product {
    private String prodId;
    private String prodName;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product() {
    }

    public Product(String prodId, String prodName, double unitPrice) {
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

    public double getDiscountAmt(int qty) {
        return discount.getDiscountAmt(unitPrice, qty);
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
    
    
    public static void main(String[] args) {
        Product test = new Product("101", "Hat", 10);
        test.setDiscount(new VariableRateDiscount());
        System.out.println(test.getDiscountAmt(1));
    }
    
}
