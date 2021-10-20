package controller;

import storage.FileRevenue;

import java.io.IOException;
import java.io.Serializable;

public class RevenueManager implements Serializable {
    private FileRevenue fileRevenue = new FileRevenue();
    private double revenue;

    public RevenueManager(FileRevenue fileRevenue) {
        this.fileRevenue = fileRevenue;
    }

    public RevenueManager(double revenue) {
        this.revenue = revenue;
    }

    public RevenueManager() {
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) throws IOException {
        this.revenue += revenue;
        fileRevenue.writeFile((int)revenue);
    }

    @Override
    public String toString() {
        return "RevenueManager{" +
                "revenue=" + revenue +
                '}';
    }
}
