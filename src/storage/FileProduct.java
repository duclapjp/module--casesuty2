package storage;

import molder.product.Product;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileProduct {
    private static FileProduct fileProduct;

    public static FileProduct  getInstance() {                      //sử dụng singleton
        if (fileProduct==null){
            fileProduct = new FileProduct();
        }
        return fileProduct;
    }

    public  void writeFile(List<Product> productList) throws IOException {
        try {
            OutputStream os = new FileOutputStream("product.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(productList);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public  List<Product> readFile(){
        File file = new File("product.txt");
        List<Product>productList = new ArrayList<>();
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (file.length()==0) return productList;
        try{
            InputStream ips = new FileInputStream(new File("product.txt"));
            ObjectInputStream ois = new ObjectInputStream(ips);
            productList = (List<Product>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
