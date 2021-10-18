package molder.product;

import java.io.Serializable;
import java.time.LocalDate;

public class TableProduct extends Product implements Serializable {
    private static final String codeCategory  = "table";

    public TableProduct(String name, int quantity, String codeProduct, double price, LocalDate importDate, String description) {
        super(name, quantity, codeProduct, price, importDate, description);
    }

    public TableProduct() {
    }

    @Override
    public String toString() {
        return "TableProduct{" +
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
