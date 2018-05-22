package com.example.demo.genreictest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2018/1/13.
 * generic <T></>
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class Student<T> {
    private T name;

    public void showType(){
        System.out.println("T的实际类型为"+name.getClass().getName());
    }
    public static void main(String[] args) {
        Student<String> st = new Student<>();
        st.setName("zs");
        st.showType();
        String name = st.getName();//泛型不需要强转
        Student<Integer> st1 = new Student<>();
        st1.setName(7);
        st1.showType();

    }

}
