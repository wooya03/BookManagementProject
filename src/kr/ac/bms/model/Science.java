package kr.ac.bms.model;

public class Science extends Book{

    public Science(int id, String name, String writer, int price) {
        super(id, name, writer, price);
    }

    @Override
    public void print() {
        System.out.println("[과학-" + getId() + "]");
        System.out.println(getName() + " - " + getWriter());
        System.out.println("가격 : " + getPrice());
    }
}
