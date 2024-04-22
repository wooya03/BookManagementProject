package kr.ac.bms;

import kr.ac.bms.management.BookManagementSystem;
import kr.ac.bms.management.ManagementSystem;
import kr.ac.bms.service.BookServiceImpl;

public class Process {
    public static void main(String[] args) {
        ManagementSystem managementSystem = new BookManagementSystem(new BookServiceImpl());
        managementSystem.execute();
    }
}
