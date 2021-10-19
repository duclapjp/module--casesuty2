package controller;

import molder.Bill;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BillManager implements GeneralManager<Bill>{
    private List<Bill> billList = new ArrayList<>();

    public BillManager(List<Bill> billList) {
        this.billList = billList;
    }

    public BillManager() {
    }

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public void showAll() {

    }

    @Override
    public void add(Bill bill) throws IOException {

    }

    @Override
    public void edit(int index, Bill bill) throws IOException {

    }

    @Override
    public void delete(int index) throws IOException {

    }
}
