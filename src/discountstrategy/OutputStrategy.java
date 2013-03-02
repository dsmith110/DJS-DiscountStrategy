package discountstrategy;

/**
 * Interface used for many different outputs that the store might need to 
 * utilize. Any class implementing this interface must override these methods.
 * @author Dan Smith
 * @version 1.00
 */
public interface OutputStrategy {
    
    public abstract void outputReceipt(String receipt);
}
