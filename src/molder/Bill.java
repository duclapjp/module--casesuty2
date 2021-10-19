package molder;

public class Bill {
    private String nameCustomer;
    private String address;

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "nameCustomer='" + nameCustomer + '\'' +
                ", codeBill='" +
                ", address='" + address + '\'' +
                '}';
    }
}
