package com.example.demo.ExtendsTest;

import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2017/12/14.
 */
@NoArgsConstructor
public class Student extends People {
    String studentName;
    public Student(String name) {
        super(name);
        System.out.println(this.studentName);
    }

    public String getStudentName() {
        return studentName;
    }

    @Override
    public void eat() {
        System.out.println("student to eat");
    }

    public static void main(String[] args) {
        Student st = new Student("zs");
            st.getStudentName();
            System.out.println(st.studentName);
            System.out.println(st.name);
    }
}
