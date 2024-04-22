package kr.ac.bms.model;

public class Novel extends Book{

    public Novel(int id, String name, String writer, int price) {
        super(id, name, writer, price);
    }

    @Override
    public void print() {
        System.out.println("[소설-" + getId() + "]");
        System.out.println(getName() + " - " + getWriter());
        System.out.println("가격 : " + getPrice());
    }
}
