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
        System.out.println("1:Quản lý sản phẩm");
        System.out.println("2:Quản lý khách hàng");
        System.out.println("3:Back");
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                clientProduct.runProduct();
                break;
            case 2:
                clientCustomer.runCustomer();
                break;
            case 3:
                break;
        }
    }
}
