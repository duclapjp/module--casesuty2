package controller;

import molder.Bill;
import molder.product.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillManager implements GeneralManager<Product> {
    private static List<Product> billList = new ArrayList<>();
    private static BillManager billManager;
    private Bill bill;
    public static BillManager getInstance(){
        if (billManager == null){
            billManager = new BillManager();
        }
        return billManager;
    }

    public BillManager() {
    }

    public List<Product> getBillList() {
        return billList;
    }

    public void setBillList(List<Product> billList) {
        BillManager.billList = billList;
    }

    public  BillManager getBillManager() {
        return billManager;
    }

    public  void setBillManager(BillManager billManager) {
        BillManager.billManager = billManager;
    }

    public BillManager(BillManager billManager) {
        this.billManager = billManager;
    }

    @Override
    public void showAll() {
        for (Product bill: billList) {
            System.out.println(bill.toString());
        }
    }
    public double Pay(){
        double money = 0;
        for (int i = 0; i < billList.size(); i++) {
            money+=(billList.get(i).getQuantity())*(billList.get(i).getPrice());
        }
        return money;
    }
    @Override
    public void add(Product product) throws IOException {
        billList.add(product);
    }

    @Override
    public void edit(int index, Product product) throws IOException {
        billList.set(index,product);
    }

    @Override
    public void delete(int index) throws IOException {
        billList.remove(index);
    }

    @Override
    public int getIndexByName(String name) {
        for (int i = 0; i < billList.size(); i++) {
            if (billList.get(i).getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "BillManager{" +
                "billManager=" + billManager +
                '}';
    }
}
