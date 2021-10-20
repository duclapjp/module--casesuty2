package storage;


import controller.RevenueManager;

import java.io.*;

public class FileRevenue {
    public String readFile() throws IOException {
        RevenueManager revenue = new RevenueManager();
        File file = new File("revenue.txt");
        if(!file.exists()){
            file.createNewFile();
        }
        FileReader  is = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(is);
        String line = "";
        while ((line= bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        return line;
    }
    public void writeFile(int revenue) throws IOException {
        FileWriter fileWriter  = new FileWriter(new File("revenue.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(revenue);
        bufferedWriter.close();
    }
}
