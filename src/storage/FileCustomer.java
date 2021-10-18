package storage;

import molder.Customer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileCustomer {
    private static FileCustomer fileCustomer;

    public static FileCustomer getInstance(){
        if (fileCustomer==null){
            fileCustomer = new FileCustomer();
        }
        return fileCustomer;
    }
    public  void writeFile(List<Customer> customerList) throws IOException {
        try {
            OutputStream os = new FileOutputStream(new File("customer.txt"));
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(customerList);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static List<Customer> readFile(){
        File file = new File("customer.txt");
        List<Customer>customerList = new ArrayList<>();
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (file.length()==0) return customerList;
        try{
            InputStream ips = new FileInputStream(new File("customer.txt"));
            ObjectInputStream ois = new ObjectInputStream(ips);
            customerList = (List<Customer>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
