package storage;

import molder.login.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUser {
    private static FileUser fileUser;

    public static FileUser  getInstance() {                      //sử dụng singleton
        if (fileUser==null){
            fileUser = new FileUser();
        }
        return fileUser;
    }

    public  void writeFile(List<User> userList) throws IOException {
        try {
            OutputStream os = new FileOutputStream("user.txt");
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(userList);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public  List<User> readFile(){
        File file = new File("user.txt");
        List<User>userList = new ArrayList<>();
        if (!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        if (file.length()==0) return userList;
        try{
            InputStream ips = new FileInputStream("user.txt");
            ObjectInputStream ois = new ObjectInputStream(ips);
            userList = (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
