package com.example.demo.ExtendsTest;

/**
 * Created by zhangyedong on 2017/12/14.
 */
public class Student extends People {
    String studentName;
    public Student(String name) {
        super(name);
        System.out.println(this.studentName);
    }

    public String getStudentName() {
        return studentName;
    }

    public static void main(String[] args) {
        Student st = new Student("zs");
        try {
            Student.class.newInstance().getStudentName();
            People.class.newInstance().getName();
            st.getStudentName();
            System.out.println(st.studentName);
        }catch (Exception e){

        }
    }
}
