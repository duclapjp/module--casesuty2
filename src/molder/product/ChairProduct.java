package molder.product;

import java.io.Serializable;
import java.time.LocalDate;

public class ChairProduct extends Product implements Serializable {
    private static final String codeCategory = "chair";

    public ChairProduct(String name, int quantity, String codeProduct, double price, LocalDate importDate, String description) {
        super(name, quantity, codeProduct, price, importDate, description);
    }

    public ChairProduct() {
    }

    @Override
    public String toString() {
        return "ChairProduct{" +
                "name='" + name + '\'' +
                ", codeProduct='" + codeProduct + '\'' +
                ", codeCategory='" + codeCategory + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", importDate=" + importDate +
                ", description='" + description + '\'' +
                '}';
    }
}
