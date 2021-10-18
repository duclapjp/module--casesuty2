package view;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import controller.UserManager;
import molder.login.User;
import storage.FileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Login {
    public static Scanner scanner = new Scanner(System.in);
    private static List<User> userList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        RunAdmin runAdmin = new RunAdmin();
        FileUser fileUser  = FileUser.getInstance();
        UserManager duclap = new UserManager(fileUser);
        userList = fileUser.readFile();
        System.out.println("---CHỌN CHỨC NĂNG---");
        System.out.println("---ADMIN---");
        System.out.println("1:Đăng nhập");
        System.out.println("2:Đăng ký");
        System.out.println("----------------------");
        System.out.println("3:kHÁCH HÀNG");
        System.out.println("4:Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                if (duclap.checkUser(getNickName(),getPass())){
                   runAdmin.runAdmin();
                }else {
                    System.out.println("sai thông tin đăng nhập");
                }
            case 2:
                userList.add(creatUser());
                break;
            case 3:

        }
    }
    public static User creatUser(){
        User user = new User();
        System.out.println("nhập tên đăng nhập");
        user.setNickName(scanner.nextLine());
        System.out.println("nhập vào pass");
        user.setPass(scanner.nextLine());
        return user;
    }
    public static String getNickName(){
        System.out.println("nhập vào tên đăng nhập");
        String nickName = scanner.nextLine();
        return nickName;
    }
    public static String getPass(){
        System.out.println("nhập vào pass");
        String pass = scanner.nextLine();
        return pass;
    }
}
