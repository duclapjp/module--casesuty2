package view;

import java.io.IOException;
import java.util.Scanner;

public class RunAdmin {

    public void runAdmin() throws IOException {
        ClientManagerProduct clientProduct = new ClientManagerProduct();
        ClientManagerCustomer clientCustomer  = new ClientManagerCustomer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("CHỌN CHỨC NĂNG");
        System.out.println("---MENU---");
        System.out.println("1:quản lý sản phẩm");
        System.out.println("2:quản lý khách hàng");
        System.out.println("3:Exit");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                clientProduct.runProduct();
                break;
            case 3:
                break;
        }
    }
}
