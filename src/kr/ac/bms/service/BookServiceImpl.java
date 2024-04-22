package kr.ac.bms.service;

import kr.ac.bms.model.Book;

import java.util.ArrayList;

public class BookServiceImpl implements BookService{
    static int uniqId = 0;
    ArrayList<Book> books = new ArrayList<>();

    @Override
    public int uniqId() {
        return uniqId++;
    }

    @Override
    public void regist(Book book) {
        books.add(book);
    }

    @Override
    public ArrayList<Book> getALl() {
        return books;
    }

    @Override
    public void modify(Book book) {
        books.set(book.getId(), book);
    }

    @Override
    public void remove(int id) {
        books.remove(id);
    }
}
