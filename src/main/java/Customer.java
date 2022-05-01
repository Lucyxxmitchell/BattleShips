//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class Customer {
    private final String firstName;
    private final String lastName;
    private final String emailAddress;
    private final String password;
    public static final String dataSourceName = "customer";

    public Customer(String emailAddress, String firstName, String lastName, String password) {
        this.emailAddress = emailAddress;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getPassword() {
        return this.password;
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }
}
