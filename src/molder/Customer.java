package molder;

import java.io.Serializable;

public class Customer implements Serializable {
    private String name;
    private String address;
    private int countOfBuyProduct;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(String name, String address, int countOfBuyProduct, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.countOfBuyProduct = countOfBuyProduct;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCountOfBuyProduct() {
        return countOfBuyProduct;
    }

    public void setCountOfBuyProduct(int countOfBuyProduct) {
        this.countOfBuyProduct = countOfBuyProduct;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", numberOfBuyProduct=" + countOfBuyProduct +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
