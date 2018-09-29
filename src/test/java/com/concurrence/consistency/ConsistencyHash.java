package com.concurrence.consistency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 取模
 * @Author: wxzhangyd
 * @Date: 2018/9/14 15:20
 * @Modified by:
 */

public class ConsistencyHash {


    public static void main(String[] args) {
        List<Integer> nodeList0 = new ArrayList<>();
        List<Integer> nodeList1 = new ArrayList<>();
        List<Integer> nodeList2 = new ArrayList<>();

        for (int i = 0; i < 1000; i++) {
            int node = String.valueOf(i).hashCode() % 3;
            switch (node) {
                case 0:
                    nodeList0.add(i);
                    break;
                case 1:
                    nodeList1.add(i);
                    break;
                case 2:
                    nodeList2.add(i);
                    break;
            }
        }

        System.out.println("nodeList0:" + Arrays.toString(nodeList0.toArray()));
        System.out.println("nodeList1:" + Arrays.toString(nodeList1.toArray()));
        System.out.println("nodeList2:" + Arrays.toString(nodeList2.toArray()));
    }


    @Test
    public void test() {
        int i = this.hashCode();
        System.out.println(i);
    }
}
