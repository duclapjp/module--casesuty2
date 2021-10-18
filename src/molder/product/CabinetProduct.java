package molder.product;

import java.io.Serializable;
import java.time.LocalDate;

public class CabinetProduct extends Product implements Serializable {
    private static final String codeCategory = "cabinet";

    public CabinetProduct(String name, int quantity, String codeProduct, double price, LocalDate importDate, String description) {
        super(name, quantity, codeProduct, price, importDate, description);
    }

    public CabinetProduct() {
    }

    @Override
    public String toString() {
        return "CabinetProduct{" +
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
