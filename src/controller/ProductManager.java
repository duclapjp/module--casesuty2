package controller;

import molder.product.Product;
import storage.FileProduct;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ProductManager implements GeneralManager<Product> {
    private static List<Product> productList = new ArrayList<>();
    private FileProduct fileProduct = FileProduct.getInstance();
    private static ProductManager productManager;

    public static ProductManager getInstance() {
        if (productManager == null) {
            productManager = new ProductManager();
        }
        return productManager;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public ProductManager() {
    }

    public ProductManager(FileProduct fileProduct) {
        this.fileProduct = fileProduct;
    }

    public void setProductList(List<Product> productList) throws IOException {
        this.productList = productList;
        fileProduct.writeFile(productList);
    }


    @Override
    public void showAll() {
        for (Product p : productList) {
            System.out.println(p.toString());
        }
    }

    public int getIndexByName(String codeProduct) {
        int index = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCodeProduct().equals(codeProduct)) {
                return index = i;
            }
        }
        return -1;
    }

    @Override
    public void add(Product product) throws IOException {
        productList.add(product);
        fileProduct.writeFile(productList);
    }

    @Override
    public void edit(int index, Product product) throws IOException {
        productList.set(index, product);
        fileProduct.writeFile(productList);
    }

    @Override
    public void delete(int index) throws IOException {
        try {
            productList.remove(index);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("nhập sai mã sản phẩm");
        }

        fileProduct.writeFile(productList);
    }

    public void checkProduct(String codeProduct) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getCodeProduct().equals(codeProduct)) {
                System.out.println(productList.get(i).toString());
            }
        }
    }

    public void checkOverDate() {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getImportDate().isBefore(productList.get(i).getImportDate().plusDays(90))) {
                if (productList.get(i).getQuantity() > 0) {
                    System.out.println(productList.get(i).toString());
                }
            }
        }
    }
}
