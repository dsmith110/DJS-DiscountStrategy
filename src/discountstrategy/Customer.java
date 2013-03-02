package discountstrategy;

/**
 * Class hold information about the customer such as name and customer Id for
 * looking up information about the customer and displaying information on the 
 * receipt.
 * @author Dan Smith
 * @version 1.00
 */
public class Customer {
    private String name;
    private String custId;

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
    }

    /**
     * Returns the customer name
     * @return - must be a valid name.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

}
