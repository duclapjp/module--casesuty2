package view;

import controller.ProductManager;
import controller.RevenueManager;
import molder.product.Product;
import molder.product.ProductFactory;
import molder.product.ProductType;
import storage.FileRevenue;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class ClientManagerProduct {
    private static final Scanner scanner = new Scanner(System.in);
    private static RevenueManager revenueManager = new RevenueManager();
    private static FileRevenue fileRevenue = new FileRevenue();
    public void runProduct() throws IOException {
        ProductManager duclap = ProductManager.getInstance();
        boolean check = true;
        while (check) {
            System.out.println("chọn chức năng");
            System.out.println("-----MENU----");
            System.out.println("1:Thêm sản phẩm");
            System.out.println("2:Hiển thị sản phẩm");
            System.out.println("3:Sửa");
            System.out.println("4:Xóa");
            System.out.println("5:Tìm kiếm");
            System.out.println("6:Tổng doanh thu đến thời điểm hiện tại");
            System.out.println("7:Tổng kết tiền cuối ngày");
            System.out.println("8:Back");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    duclap.add(creatProduct());
                    duclap.showAll();
                    break;
                case 2:
                    duclap.showAll();
                    break;
                case 3:
                    String codeProduct1 = getCodeProduct();
                    Product newPoduct = creatProduct();
                    int index1 = duclap.getIndexByName(codeProduct1);
                    duclap.edit(index1,newPoduct);
                    duclap.showAll();
                    break;
                case 4:
                    String codeProduct2 = getCodeProduct();
                    int index2 = duclap.getIndexByName(codeProduct2);
                    duclap.delete(index2);
                    duclap.showAll();
                    break;
                case 5:
                    String code = getCodeProduct();
                    duclap.checkProduct(code);
                    break;
                case 6:
                    System.out.println("Doanh thu tới thời điểm hiện tại là:");
                    fileRevenue.readFile();
                    break;
                case 7:
                    System.out.println("Doanh thu tới thời điểm hiện tại là:");
                    fileRevenue.readFile();
                    revenueManager.setRevenue(0);
                    break;
                case 8:
                    check = false;
                    break;
            }
        }
    }

    private String getCodeProduct() {
        System.out.println("nhập vào mã sản phẩm");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public Product creatP() {
        System.out.println("nhập vào kiểu sản phẩm muốn thêm:BED,TABLE,CHAIR,CABINET");
        scanner.nextLine();
        String name = scanner.nextLine();
        if (name.equals("BED")) {
            System.out.println("bạn đã chọn giường");
            return ProductFactory.getProduct(ProductType.BED);
        }
        if (name.equals("TABLE")) {
            System.out.println("bạn đã chọn bàn");
            return ProductFactory.getProduct(ProductType.TABLE);
        }
        if (name.equals("CHAIR")) {
            System.out.println("bạn đã chọn ghế");
            return ProductFactory.getProduct(ProductType.CHAIR);
        }
        if (name.equals("CABINET")) {
            System.out.println("bạn đã chọn tủ");
            return ProductFactory.getProduct(ProductType.CABINET);
        }
        return null;
    }

    public Product creatProduct() {
        Product product = creatP();
        int random = (int) Math.floor(Math.random()*100+1);
        System.out.println("nhập tên sản phẩm");
        product.setName(scanner.nextLine());
        System.out.println("nhập mã sản phẩm");
        product.setCodeProduct(scanner.nextLine());
        System.out.println("nhập số lượng");
        product.setQuantity(scanner.nextInt());
        System.out.println("nhập giá");
        product.setPrice(scanner.nextDouble());
        System.out.println("ngày nhập");
        product.setImportDate(LocalDate.now().minusDays(random));
        System.out.println(product.getImportDate());
        System.out.println("nhập mô tả");
        scanner.nextLine();
        product.setDescription(scanner.nextLine());
        return product;
    }
}
