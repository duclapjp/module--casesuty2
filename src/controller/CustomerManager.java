package controller;

import molder.Customer;
import storage.FileCustomer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager implements GeneralManager<Customer> {
    private List<Customer> customerList = new ArrayList<>();
    private FileCustomer fileCustomer;

    public FileCustomer getFileCustomer() {
        return fileCustomer;
    }

    public void setFileCustomer(FileCustomer fileCustomer) {
        this.fileCustomer = fileCustomer;
    }

    public CustomerManager(FileCustomer fileCustomer) {
        this.fileCustomer =fileCustomer;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    @Override
    public void showAll() {
        for (Customer c:customerList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void add(Customer customer) throws IOException {
        customerList.add(customer);
       fileCustomer.writeFile(customerList);
    }


    @Override
    public void edit(int index, Customer customer) throws IOException {
        customerList.set(index, customer);
        fileCustomer.writeFile(customerList);
    }


    @Override
    public void delete(int index) throws IOException {
        customerList.remove(index);
        fileCustomer.writeFile(customerList);
    }

    public void checkLoyalCustomer(){
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getCountOfBuyProduct()>=3){
                System.out.println(customerList.get(i).toString());
            }
        }
    }
}
