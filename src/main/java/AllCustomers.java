//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AllCustomers {
    private List<Customer> listOfCustomers = new ArrayList();
    private boolean customersLoaded = false;

    public AllCustomers() {
    }

    private List<String[]> loadRawCustomers() {
        ReadDelimitedFile readDelimitedFile = new ReadDelimitedFile();
        return readDelimitedFile.getFileData("customer.csv");
    }

    private List<Customer> loadAsCustomers() {
        List<String[]> rawCustomers = this.loadRawCustomers();
        Iterator var2 = rawCustomers.iterator();

        while(var2.hasNext()) {
            String[] rawCustomer = (String[])var2.next();
            this.listOfCustomers.add(new Customer(rawCustomer[0], rawCustomer[1], rawCustomer[2], rawCustomer[3]));
        }

        this.customersLoaded = true;
        return this.listOfCustomers;
    }

    public List<Customer> getListOfCustomers() {
        if (!this.customersLoaded) {
            this.loadAsCustomers();
        }

        return this.listOfCustomers;
    }
}
