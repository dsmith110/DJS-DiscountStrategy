package discountstrategy;

/**
 * Class implements an OutputStrategy interface that must override the 
 * outputReceipt method. Accepts a receipt as a string and outputs that string
 * accordingly.
 * @author Dan Smith
 * @version 1.00
 */
public class ConsoleOutput implements OutputStrategy {

    /**
     * Outputs the receipt to the console
     * @param receipt - Must be a valid receipt
     */
    @Override
    public void outputReceipt(String receipt) {
        if(receipt == null || receipt.equals("")) {
            throw new UnsupportedOperationException("TO DO");
        } else {
            System.out.println(receipt);
        }
    }
    
}
