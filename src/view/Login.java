package view;

import controller.CustomerManager;
import controller.ProductManager;
import controller.UserManager;
import molder.login.User;
import storage.FileCustomer;
import storage.FileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    private static Scanner scanner = new Scanner(System.in);
    private static ProductManager productManager;
    private static List<User> userList;
    public static void main(String[] args) throws IOException {
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
            System.out.println("5:thanh toán");
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
                    break;
                case 3:
                    productManager.showAll();
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
