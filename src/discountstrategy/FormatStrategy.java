package discountstrategy;

/**
 * Interface used to format data about transactions for displaying the receipt.
 * Any class implementing this interface must override these methods.
 * @author Dan Smith
 * @version 1.00
 */
public interface FormatStrategy {
    public abstract String getFormattedData(Receipt receipt);
}
