package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class CashRegister {
    private Receipt receipt;
    private OutputStrategy out;
    private InputStrategy in;
    
    public CashRegister() {}
    
    public void startNewSale(String custId) {
        receipt = new Receipt();
        receipt.findCustomer(custId);
    }
    
    public void addItemToSale(String prodId, int qty) {
        receipt.addLineItem(prodId, qty);
    }
    
    public void outputReceipt() {
        System.out.println(receipt.getFinalizedSale());
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
