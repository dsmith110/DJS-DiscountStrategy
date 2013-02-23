package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class CashRegister {
    private Receipt receipt;
    
    public CashRegister() {}
    
    public void startNewSale(String custId) {
        receipt = new Receipt();
        receipt.findCustomer(custId);
    }
    
    public void addItemToSale(String prodId, int qty) {
        receipt.addLineItem(prodId, qty);
    }
    
    public String finalizeSale() {
        return receipt.getFinalizedSale();
    }
    
    public Receipt getReceipt() {
        return receipt;
    }
    
}
