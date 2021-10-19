package view;

import controller.UserManager;
import molder.login.User;

import java.io.IOException;
import java.util.Scanner;

public class RunAdmin {
    private static Scanner scanner;
    private static UserManager userManager = UserManager.getInstance();
    public void runAdmin() throws IOException {
        ClientManagerProduct clientProduct = new ClientManagerProduct();
        ClientManagerCustomer clientCustomer  = new ClientManagerCustomer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHỌN CHỨC NĂNG");
        System.out.println("---MENU---");
        System.out.println("1:Quản lý sản phẩm");
        System.out.println("2:Quản lý khách hàng");
        System.out.println("3:Đăng ký");
        System.out.println("4:Back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                clientProduct.runProduct();
                break;
            case 2:
                clientCustomer.runCustomer();
                break;
            case 3:
                userManager.add(creatUser());
                break;
            case 4:
                break;
        }
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
}
