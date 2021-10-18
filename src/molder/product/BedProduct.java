package molder.product;

import java.io.Serializable;
import java.time.LocalDate;

public class BedProduct extends Product implements Serializable {
    private static final String codeCategory = "bed";

    public BedProduct(String name, int quantity, String codeProduct, double price, LocalDate importDate, String description) {
        super(name, quantity, codeProduct, price, importDate, description);
    }

    public BedProduct() {

    }
    @Override
    public String toString() {
        return "BedProduct{" +
                "name='" + name + '\'' +
                ", codeProduct='" +codeProduct+
                ", codeCategory='" + codeCategory + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", importDate=" + importDate +
                ", description='" + description + '\'' +
                '}';
    }
}
