package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public class ConsoleOutput implements OutputStrategy {

    @Override
    public void outputReceipt(String receipt) {
        System.out.println(receipt);
    }
    
}
