package com.example.demo.genreictest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2018/1/13.
 * generic <Object></>
 * 这里的<Object></>和Object类型不一样，只是定义的一个泛型别名
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentObject<Object> {
    private Object name;

    public void showType(){
        System.out.println("Object的实际类型为"+name.getClass().getName());
    }
    public static void main(String[] args) {
        StudentObject<String> st = new StudentObject();
        st.setName("zs");
        String name = st.getName();//泛型不需要强转
        st.showType();
        StudentObject<Integer> st1 = new StudentObject();
        st1.setName(6);
        st1.showType();
        StudentObject st2 = new StudentObject();
        st2.setName(5);
    }
}
