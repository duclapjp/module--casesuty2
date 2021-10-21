package storage;


import controller.RevenueManager;

import java.io.*;

public class FileRevenue {
    private static FileRevenue fileRevenue;
    public static FileRevenue getInstance(){
        if (fileRevenue==null){
            fileRevenue = new FileRevenue();
        }
        return fileRevenue;
    }

    public  double readFile() throws IOException {
        RevenueManager revenue = new RevenueManager();
        File file = new File("revenue.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader  is = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(is);
        String line = "";
        double num=0;
        while ((line= bufferedReader.readLine())!=null){
            num = Double.parseDouble(line);
        }
        bufferedReader.close();
        return num;
    }
    public void writeFile(double revenue) throws IOException {
        FileWriter fileWriter  = new FileWriter(new File("revenue.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(""+revenue);
        bufferedWriter.close();
    }
}
