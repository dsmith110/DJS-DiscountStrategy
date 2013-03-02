package discountstrategy;

/**
 * This class delegates to the receipt class. It has a receipt property and 
 * input and output properties. 
 * @author Dan Smith
 * @version 1.00
 */
public class CashRegister {
    private Receipt receipt;
    
    // Playing around with these
    private OutputStrategy out;
    private InputStrategy in;
    
    public CashRegister() {}
    
    /**
     * Accepts a string customer Id as an argument. Instantiates a receipt
     * object and assigns it to receipt property. Also calls the findCustomer
     * method and passes the customer Id to it.
     * @param custId - must be a valid string in the correct format
     */
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
