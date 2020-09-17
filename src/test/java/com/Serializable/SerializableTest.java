package com.Serializable;

import com.design.demo.domain.Car;
import org.junit.Test;

import java.io.*;

/**
 * @Description:
 * @Author: yedong
 * @Date: 2020/9/17 15:31
 * @Modified by:
 */

public class SerializableTest {
    /**
     * 序列化
     */
    @Test
    public void test() {
        Car build = Car.builder().id(1L).make("CN").model("BM").build();

        try {
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\yedong\\Desktop\\notepad\\cat.dat");
            ObjectOutputStream outStream = new ObjectOutputStream(fileOut);
            outStream.writeObject(build);
            outStream.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    /**
     * 反序列化
     */
    @Test
    public void testConvert() {

        Car car = null;
        try {
            FileInputStream fileIn = new FileInputStream("C:\\Users\\yedong\\Desktop\\notepad\\cat.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            car = (Car) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Employee class not found");
            c.printStackTrace();
            return;
        }
        System.out.println("Deserialized Car...");

        System.out.println(car.getId());
        System.out.println(car.getMake());
        System.out.println(car.getModel());

    }


}
