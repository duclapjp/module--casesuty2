package view;

import controller.BillManager;
import controller.CustomerManager;
import controller.ProductManager;
import controller.UserManager;
import molder.Bill;
import molder.login.User;
import molder.product.Product;
import storage.FileCustomer;
import storage.FileProduct;
import storage.FileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager = ProductManager.getInstance();
    private static List<User> userList;
    private static BillManager billManager = BillManager.getInstance();

    public static void main(String[] args) throws IOException {
        FileProduct fileProduct = FileProduct.getInstance();
        List<Product> productList = fileProduct.readFile();
        productManager.setProductList(productList);
        RunAdmin runAdmin = new RunAdmin();
        FileUser fileUser = FileUser.getInstance();
        UserManager lapLogin = new UserManager(fileUser);
        userList = fileUser.readFile();
        lapLogin.setUserList(userList);

        boolean check = true;
        while (check) {
            System.out.println("---CHỌN CHỨC NĂNG---");
            System.out.println("---ADMIN---");
            System.out.println("1:Đăng nhập");
            System.out.println("2:Đăng ký");
            System.out.println("7:Hiện danh sách User");
            System.out.println("----------------------");
            System.out.println("---kHÁCH HÀNG---");
            System.out.println("3:Xem hàng");
            System.out.println("4:thêm vào giỏ hàng");
            System.out.println("5:Xem giỏ hàng");
            System.out.println("6:thanh toán");
            System.out.println("8:Exit");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    if (lapLogin.checkUser(getNickName(), getPass())) {
                        runAdmin.runAdmin();
                    } else {
                        System.out.println("sai thông tin đăng nhập");
                    }
                    break;
                case 2:
                    lapLogin.add(creatUser());
                    System.out.println("đăng ký thành công!");
                    break;
                case 3:
                    System.out.println("---Sản Phẩm---");
                    productManager.showAll();
                    break;
                case 4:
                    int index = productManager.getIndexByCodeProduct(getCodeProduct());
                    Product product = productList.get(index);
                    System.out.println("nhập số lượng muốn mua");
                    int n = scanner.nextInt();
                    if(n>product.getQuantity()){
                        System.out.println("vui lòng liên hệ trực tiếp cửa hàng vì số lượng quá lớn");
                        break;
                    }else {
                        int quantity = product.getQuantity();
                        product.setQuantity(n);
                        billManager.add(product);
                        productList.get(index).setQuantity(quantity - n);
                        productManager.setProductList(productList);
                        break;
                    }
                case 5:
                        billManager.showAll();
                        break;
                case 6:
                    System.out.println("---Số tiền phải trả là:---");
                    System.out.println(billManager.Pay());
                    break;
                case 7:
                    lapLogin.showAll();
                    break;
                case 8:
                    check = false;
                    break;
            }
        }
    }
    public static String getCodeProduct(){
        System.out.println("nhập vào mã sản phẩm");
        scanner.nextLine();
        String code = scanner.nextLine();
        return code;
    }
    public static User creatUser() {
        User user = new User();
        System.out.println("nhập tên đăng nhập");
        scanner.nextLine();
        user.setNickName(scanner.nextLine());
        System.out.println("nhập vào pass");
        user.setPass(scanner.nextLine());
        return user;
    }

    public static String getNickName() {
        System.out.println("nhập vào tên đăng nhập");
        scanner.nextLine();
        String nickName = scanner.nextLine();
        return nickName;
    }

    public static String getPass() {
        System.out.println("nhập vào pass");
        String pass = scanner.nextLine();
        return pass;
    }

}
