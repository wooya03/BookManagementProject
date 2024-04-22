package kr.ac.bms.model;

public class Essay extends Book {

    public Essay(int id, String name, String writer, int price) {
        super(id, name, writer, price);
    }

    @Override
    public void print() {
        System.out.println("[에세이-" + getId() + "]");
        System.out.println(getName() + " - " + getWriter());
        System.out.println("가격 : " + getPrice());
    }
}
