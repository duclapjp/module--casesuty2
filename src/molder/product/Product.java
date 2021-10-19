package molder.product;

import java.io.Serializable;
import java.time.LocalDate;

public class Product implements Serializable {
    String name;
    int quantity;
    double price;
    LocalDate importDate;
    String description;
    String codeProduct;
    public Product(String name, int quantity,String codeProduct, double price, LocalDate importDate, String description) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.importDate = importDate;
        this.description = description;
        this.codeProduct = codeProduct;
    }

    public Product() {
    }


    public String getCodeProduct() {
        return codeProduct;
    }

    public void setCodeProduct(String codeProduct) {
        this.codeProduct = codeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getImportDate() {
        return importDate;
    }

    public void setImportDate(LocalDate importDate) {
        this.importDate = importDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
   
    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +codeProduct+
                ", quantity=" + quantity +
                ", price=" + price +
                ", importDate=" + importDate +
                ", description='" + description + '\'' +
                '}';
    }
}
