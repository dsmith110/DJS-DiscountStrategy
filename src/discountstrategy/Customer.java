package discountstrategy;

/**
 *
 * @author dsmith110
 */
public class Customer {
    private String name;
    private String custId;

    public Customer(String custId, String name) {
        this.custId = custId;
        this.name = name;
    }

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
