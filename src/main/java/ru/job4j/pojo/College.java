package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Петров Иван Иванович");
        student.setGroup("БСБО-09-21");
        student.setDate(new Date());
        System.out.println(student.getDate() + " cтудент "
                + student.getFullName() + " зачислен в группу "
                + student.getGroup());
    }
}
