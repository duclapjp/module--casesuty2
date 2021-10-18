package controller;

import molder.login.User;
import storage.FileUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager implements GeneralManager<User> {
    List<User> userList = new ArrayList<>();
    private FileUser fileUser;

    public UserManager(FileUser fileUser) {
        this.fileUser = fileUser;
    }

    public FileUser getFileUser() {
        return fileUser;
    }

    public void setFileUser(FileUser fileUser) {
        this.fileUser = fileUser;
    }

    public UserManager() {
    }

    public UserManager(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public void showAll() {

    }

    @Override
    public void add(User user) throws IOException {
        userList.add(user);
        fileUser.writeFile(userList);
    }

    @Override
    public void edit(int index, User user) throws IOException {

    }


    @Override
    public void delete(int index) throws IOException {

    }
    public boolean checkUser(String nickName,String pass){
        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getNickName().equals(nickName)){
                if (userList.get(i).getPass().equals(pass)){
                    return true;
                }
            }
        }
        return false;
    }

}
