package kr.ac.bms.service;

import java.util.ArrayList;
import kr.ac.bms.model.Book;

public interface BookService {
    int uniqId();
    void regist(Book book);
    ArrayList<Book> getALl();
    void modify(Book book);
    void remove(int id);
}
