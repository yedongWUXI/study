package com.design.demo.service.serviceimpl;

import com.design.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yedong
 */
public class StudyImpl {
    public StudyImpl() {
    }

    public StudyImpl(Student student) {
        this.student = student;
    }
    @Autowired
    private Student student;

    public void test(){
        student.setName("zs");
        student.getName();
        System.out.println(student.getName());
    }

    public static void main(String[] args) {
        StudyImpl study = new StudyImpl();
        study.test();

    }




}
