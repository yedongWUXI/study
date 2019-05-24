package com.spring;

import com.bean.StudentOne;
import com.bean.StudentTwo;
import org.junit.Test;
import org.springframework.beans.BeanUtils;

/**
 * @Description: spring 里的utils
 * @Author: Administrator
 * @Date: 2019/5/19 17:20
 * @Modified by:
 */

public class Utils {
    @Test
    public void testCopyProperties(){
        StudentOne studentOne = new StudentOne();
        studentOne.setAge("10");
        studentOne.setHeight(160);
        studentOne.setName("zs");
        StudentTwo studentTwo = new StudentTwo();

        BeanUtils.copyProperties(studentOne,studentTwo);
        System.out.println(studentTwo.toString());
    }
}
