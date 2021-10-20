package view;

import controller.CustomerManager;
import molder.Customer;
import storage.FileCustomer;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ClientManagerCustomer {
    private static final Scanner scanner = new Scanner(System.in);


    public void runCustomer() throws IOException {
        FileCustomer fileCustomer = FileCustomer.getInstance();
        CustomerManager lap = new CustomerManager(fileCustomer);
        List<Customer> customerList = FileCustomer.readFile();
        lap.setCustomerList(customerList);
        boolean check = true;
        while (check) {
            System.out.println("chọn chức năng");
            System.out.println("-----MENU----");
            System.out.println("1:Thêm khách hàng");
            System.out.println("2:Hiển thị danh sách khách hàng");
            System.out.println("3:Tìm kiếm");
            System.out.println("4:Khách hàng tiềm năng");
            System.out.println("5:Chỉnh sửa");
            System.out.println("6:Xóa");
            System.out.println("7:Back");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    lap.add(creatCustomer());
                    lap.showAll();
                    break;
                case 2:
                    lap.showAll();
                    break;
                case 4:
                    System.out.println("khách hàng tiềm năng là:");
                    lap.checkLoyalCustomer();
                    break;
                case 5:
                    int index = lap.getIndexByName(getName());
                    lap.edit(index, creatCustomer());
                    break;
                case 6:
                    int index2 = lap.getIndexByName(getName());
                    lap.delete(index2);
                    break;
                case 7:
                    check = false;
                    break;
            }
        }
    }

    public static String getName() {
        System.out.println("nhập vào tên khách hàng");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public Customer creatCustomer() {
        System.out.println("nhập tên");
        String name = scanner.nextLine();
        System.out.println("nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.println("nhập số sản phẩm đã mua");
        int countOfBuy = scanner.nextInt();
        System.out.println("nhập số điện thoại");
        scanner.nextLine();
        String phoneNumber = scanner.nextLine();
        return new Customer(name, address, countOfBuy, phoneNumber);
    }
}
