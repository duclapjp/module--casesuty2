package molder.product;

import java.time.LocalDate;

public class ProductFactory {
    public static Product getProduct(ProductType type){               //factory
        switch (type){
            case BED:
                return new BedProduct();
            case CHAIR:
                return new ChairProduct();
            case CABINET:
                return new CabinetProduct();
            case TABLE:
                return new TableProduct();
            default:
                throw new IllegalArgumentException("tham số không đúng");
        }
    }
}
