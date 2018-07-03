package com.java8;

import org.junit.Test;

import java.io.File;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/6/20 13:16
 * @Modified by:
 */

public class LambdaTest1 {
    @Test
    public void test(){
        File[] hiddenFiles = new File(".").listFiles(File::isFile);
    }
}
