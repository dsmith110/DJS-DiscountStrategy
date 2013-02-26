package discountstrategy;

/**
 *
 * @author Dan Smith
 */
public interface FormatStrategy {
    public abstract String getFormattedData(LineItem[] li, Customer customer,
            int receiptNo, Receipt receipt);
}
