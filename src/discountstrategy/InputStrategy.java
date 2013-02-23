package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public interface InputStrategy {
    
    public abstract String inputProductId();
    public abstract int inputQty();
    public abstract String inputCustomerId();
}
