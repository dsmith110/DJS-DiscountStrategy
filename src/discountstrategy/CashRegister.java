package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class CashRegister {
    private Receipt receipt;
    
    // Playing around with these
    private OutputStrategy out;
    private InputStrategy in;
    
    public CashRegister() {}
    
    public void startNewSale(String custId) {
        // needs validation
        receipt = new Receipt();
        receipt.findCustomer(custId);
    }
    
    public void addItemToSale(String prodId, int qty) {
        receipt.addLineItem(prodId, qty);
    }
    
    // Can be done better, only this way for testing
    public void outputReceipt() {
        System.out.println(receipt.getFinalizedSaleString());
    }
    
    public Receipt getReceipt() {
        return receipt;
    }

    public OutputStrategy getOutputStrategy() {
        return out;
    }

    public void setOutputStrategy(OutputStrategy out) {
        this.out = out;
    }

    public InputStrategy getInputStrategy() {
        return in;
    }

    public void setInputStrategy(InputStrategy in) {
        this.in = in;
    }
    
}
