package kr.ac.bms.management;

import kr.ac.bms.model.Book;
import kr.ac.bms.model.Essay;
import kr.ac.bms.model.Novel;
import kr.ac.bms.model.Science;
import kr.ac.bms.service.BookServiceImpl;
import kr.ac.bms.service.BookService;

import java.util.Scanner;

public class BookManagementSystem implements ManagementSystem{
    Scanner scanner;
    BookService bookservice;
    public BookManagementSystem(BookServiceImpl bookserviceimpl){
        System.out.println("[BookManagementSystem 준비]");
        scanner = new Scanner(System.in);
        bookservice = new BookServiceImpl();
    }
    @Override
    public void execute() {
        System.out.println("[BookManagementSystem 실행]");
        while(true){
            System.out.println("===================");
            System.out.println("1. 책 정보 입력");
            System.out.println("2. 책 정보 출력");
            System.out.println("3. 책 정보 수정");
            System.out.println("4. 책 정보 삭제");
            System.out.println("5. 시스템 종료");
            System.out.println("===================");
            int choice = scanner.nextInt();
            switch(choice){
                case 1:
                    System.out.println("책 정보 입력을 선택하셨습니다!");
                    regist();
                    break;
                case 2:
                    System.out.println("책 정보 출력을 선택하셨습니다!");
                    list();
                    break;
                case 3:
                    System.out.println("책 정보 수정을 선택하셨습니다!");
                    modify();
                    break;
                case 4:
                    System.out.println("책 정보 삭제를 선택하셨습니다!");
                    break;
                case 5:
                    System.out.println("시스템을 종료합니다!");
                    System.exit(0);
            }
        }
    }
    void regist(){
        System.out.print("장르 선택 [소설-1], [과학-2], [에세이-3] : ");
        String type = scanner.next();
        System.out.print("제목 : ");
        String name = scanner.next();
        System.out.print("저자 : ");
        String writer = scanner.next();
        System.out.print("가격 : ");
        int price = scanner.nextInt();
        Book book;
        if(type.equals("1")){
            book = new Novel(bookservice.uniqId(), name, writer, price);
        } else if (type.equals("2")){
            book = new Science(bookservice.uniqId(), name, writer, price);
        } else {
            book = new Essay(bookservice.uniqId(), name, writer, price);
        }
        bookservice.regist(book);
    }

    void list(){
        System.out.print("[전체출력-0] [소설-1], [과학-2], [에세이-3] : ");
        int type = scanner.nextInt();
        System.out.println("===============");
        for(Book b : bookservice.getALl()){
            if (type == 1 && b instanceof Novel) {
                b.print();
                System.out.println("===============");
            } else if (type == 2 && b instanceof Science) {
                b.print();
                System.out.println("===============");
            } else if (type == 3 && b instanceof Essay) {
                b.print();
                System.out.println("===============");
            } else if (type == 0){
                b.print();
                System.out.println("===============");
            }
        }
    }

    void modify(){
        Book book = null;
        System.out.print("장르 선택 [소설-1], [과학-2], [에세이-3] : ");
        int type = scanner.nextInt();
        System.out.print("책 번호 : ");
        int id = scanner.nextInt();
        System.out.print("제목 : ");
        String name = scanner.next();
        System.out.print("저자 : ");
        String writer = scanner.next();
        System.out.print("가격 : ");
        int price = scanner.nextInt();
        if(type == 1)
            book = new Novel(id, name, writer, price);
        else if (type == 2)
            book = new Science(id, name, writer, price);
        else if (type == 3)
            book = new Essay(id, name, writer, price);
        bookservice.modify(book);
    }
}
