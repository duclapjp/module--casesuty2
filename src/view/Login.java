package view;

import controller.*;
import molder.login.User;
import molder.product.Product;
import storage.FileProduct;
import storage.FileRevenue;
import storage.FileUser;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner number = new Scanner(System.in);
    private static final ProductManager productManager = ProductManager.getInstance();
    private static final BillManager billManager = BillManager.getInstance();
    private static final AccountExample accountExample = new AccountExample();
    private static final PriceComparator priceComparator = new PriceComparator();
    private static final FileUser fileUser = FileUser.getInstance();
    private static final UserManager lapLogin = new UserManager(fileUser);

    private static final RevenueManager revenueManager = new RevenueManager();

    private static FileRevenue fileRevenue = new FileRevenue();
    public static void main(String[] args) throws IOException {
        FileProduct fileProduct = FileProduct.getInstance();
        List<Product> productList = fileProduct.readFile();
        productManager.setProductList(productList);
        RunAdmin runAdmin = new RunAdmin();


        List<User> userList = fileUser.readFile();
        lapLogin.setUserList(userList);

        boolean check = true;
        while (check) {
            System.out.println("---CHỌN CHỨC NĂNG---");
            System.out.println("---ADMIN---");
            System.out.println("1:Đăng nhập");
            System.out.println("2:Đăng ký");
            System.out.println("----------------------");
            System.out.println("---kHÁCH HÀNG---");
            System.out.println("3:Xem hàng");
            System.out.println("4:Thêm vào giỏ hàng");
            System.out.println("5:Xem giỏ hàng");
            System.out.println("6:Thanh toán");
            System.out.println("7:Xem sản phẩm  theo thứ tự tăng dần");
            System.out.println("8:Exit");
            int choice = number.nextInt();
            switch (choice) {
                case 1:
                    if (lapLogin.checkUser(getNickName(), getPass())) {
                        System.out.println("Đăng nhập thành công");
                        runAdmin.runAdmin();
                    } else {
                        System.out.println("Sai thông tin đăng nhập");
                    }
                    break;
                case 2:
                    lapLogin.add(creatUser());
                    break;
                case 3:
                    System.out.println("---Sản Phẩm---");
                    productManager.showAll();
                    break;
                case 4:
                    int index = productManager.getIndexByName(getCodeProduct());
                    Product product = productList.get(index);
                    System.out.println("Nhập số lượng muốn mua");
                    int n = number.nextInt();
                    if (product.getQuantity() == 0) System.out.println("Hết hàng");
                    if (n > product.getQuantity()) {
                        System.out.println("Vui lòng liên hệ trực tiếp cửa hàng vì số lượng quá lớn");
                        break;
                    } else {
                        addBill(product, n);
                        break;
                    }
                case 5:
                    billManager.showAll();
                    break;
                case 6:
                    System.out.println("---Số tiền phải trả là:---");
                    double money = billManager.Pay();
                    System.out.println(money);
                    revenueManager.setRevenue((int)money);
                    break;
                case 7:
                    Collections.sort(productList, priceComparator);
                    productManager.showAll();
                    break;
                case 8:
                    check = false;
                    break;
            }
        }
    }


    private static void addBill(Product product, int n) throws IOException {
        int q = product.getQuantity();
        product.setQuantity(q - n);
        String codeProduct = product.getCodeProduct();
        String name = product.getName();
        String description = product.getDescription();
        double price = product.getPrice();
        LocalDate localDate = product.getImportDate();
        Product newP = new Product(name, n, codeProduct, price, localDate, description);
        billManager.add(newP);
    }

    public static String getCodeProduct() {
        System.out.println("nhập vào mã sản phẩm");
        return scanner.nextLine();
    }


    public static String getNickName() {
        System.out.println("nhập vào tên đăng nhập");
        return scanner.nextLine();
    }

    public static String getPass() {
        System.out.println("nhập vào pass");
        return scanner.nextLine();
    }

    public static User creatUser() {
        User user = new User();
        System.out.println("Nhập tên đăng nhập");
        String name = scanner.nextLine();
        if (accountExample.validate(name)) {
            if (lapLogin.checkNickName(name)) {
                System.out.println("Tên đăng nhập đã tồn tại");
            } else {
                user.setNickName(name);
                System.out.println("nhập vào pass");
                String pass = scanner.nextLine();
                user.setPass(pass);
                return user;
            }
        } else {
            System.out.println("Tên tài khoản chứa ít nhất 6 ký tự và không chứa ký tự đặc biệt");
        }
        return user;
    }
}
