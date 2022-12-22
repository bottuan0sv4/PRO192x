package vn.funix.fx16823.java.asm02;

public class User {

    private String name;
    private String customerId;

    public User(String name, String customerId){
        this.name = name;
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}
