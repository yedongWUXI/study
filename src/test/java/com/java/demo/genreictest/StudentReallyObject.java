package com.java.demo.genreictest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhangyedong on 2018/1/13.
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class StudentReallyObject {
    Object name;
    public void showType(){
        System.out.println("Object的实际类型为"+name.getClass().getName());
    }

    public static void main(String[] args) {
        StudentReallyObject st = new StudentReallyObject();
        st.setName("zs");
        String name = (String)st.getName();//这边需要强转，而泛型就不用
    }
}
