package discountstrategy;

/**
 * Interface used for various inputs the POS system will use. Any class 
 * implementing this strategy must override these methods.
 * @author Dan Smith
 * @version 1.00
 */
public interface InputStrategy {
    
    public abstract String inputProductId();
    public abstract int inputQty();
    public abstract String inputCustomerId();
}
