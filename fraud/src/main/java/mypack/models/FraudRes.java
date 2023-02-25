package mypack.models;

public class FraudRes {
    private Integer id;
    private String customerName;
    private Integer idCustomer;
    private String res;

    public FraudRes() {
    }

    public FraudRes(Integer id, String customerName, Integer idCustomer, String res) {
        this.id = id;
        this.customerName = customerName;
        this.idCustomer = idCustomer;
        this.res = res;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }
}
