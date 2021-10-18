package controller;

import java.io.IOException;
import java.util.List;

public interface GeneralManager<T> {
    void showAll();
    void add(T t) throws IOException;
    void edit(int index,T t) throws IOException;
    void delete(int index) throws IOException;
}
