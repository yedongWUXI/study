package com.design.demo.stategy_designmodle.stategy_highlevel;

import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangyedong on 2018/1/14.
 * <p>
 * <p>
 * 没有使用注解方式的工厂，if else比较多
 *
 * @NoArgsConstructor public class CalPriceFactory {
 * public static CalPrice createCalPrice(Customer customer) {
 * if (customer.getTotalAmount() > 3000) {//3000则改为金牌会员计算方式
 * return new GoldVip();
 * } else if (customer.getTotalAmount() > 2000) {//类似
 * return new SuperVip();
 * } else if (customer.getTotalAmount() > 1000) {//类似
 * return new Vip();
 * } else {
 * return new Common();
 * }
 * }
 * }
 */

/**
 * 最终价格的工厂
 */
//我们使用一个标准的简单工厂来改进一下策略模式
public class CalPriceFactory {

    private static final String CAL_PRICE_PACKAGE = "com.example.demo.stategy_designmodle.stategy_highlevel";

    private ClassLoader classLoader = getClass().getClassLoader();//我们加载策略时的类加载器，我们任何类运行时信息必须来自该类加载器

    private List<Class<? extends CalPrice>> calPriceList;//策略列表

    static CalPriceFactory instance = new CalPriceFactory();//单例

    //根据客户的总金额产生相应的策略
    public CalPrice createCalPrice(Customer customer) {
        //在策略列表查找策略
        for (Class<? extends CalPrice> clazz : calPriceList) {
            TotalValidRegion validRegion = handleAnnotation(clazz);//获取该策略的注解
            //判断金额是否在注解的区间
            if (customer.getTotalAmount() > validRegion.min() && customer.getTotalAmount() < validRegion.max()) {
                try {
                    //是的话我们返回一个当前策略的实例
                    return clazz.newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("策略获得失败");
                }
            }
        }
        throw new RuntimeException("策略获得失败");
    }

    //处理注解，我们传入一个策略类，返回它的注解
    private TotalValidRegion handleAnnotation(Class<? extends CalPrice> clazz) {
        Annotation[] annotations = clazz.getDeclaredAnnotations();
        if (annotations == null || annotations.length == 0) {
            return null;
        }
        for (int i = 0; i < annotations.length; i++) {
            if (annotations[i] instanceof TotalValidRegion) {
                return (TotalValidRegion) annotations[i];
            }
        }
        return null;
    }

    //单例
    private CalPriceFactory() {
        init();
    }

    //在工厂初始化时要初始化策略列表
    private void init() {
        calPriceList = new ArrayList<>();
        File[] resources = getResources();//获取到包下所有的class文件
        Class<CalPrice> calPriceClazz;
        try {
            calPriceClazz = (Class<CalPrice>) classLoader.loadClass(CalPrice.class.getName());//使用相同的加载器加载策略接口
        } catch (ClassNotFoundException e1) {
            throw new RuntimeException("未找到策略接口");
        }
        for (int i = 0; i < resources.length; i++) {
            try {
                //载入包下的类
                Class<?> clazz = classLoader.loadClass(CAL_PRICE_PACKAGE + "." + resources[i].getName().replace(".class", ""));
                //判断是否是CalPrice的实现类并且不是CalPrice它本身，满足的话加入到策略列表
                if (CalPrice.class.isAssignableFrom(clazz) && clazz != calPriceClazz) {
                    calPriceList.add((Class<? extends CalPrice>) clazz);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    //获取扫描的包下面所有的class文件
    private File[] getResources() {
        try {
            File file = new File(classLoader.getResource(CAL_PRICE_PACKAGE.replace(".", "/")).toURI());
            return file.listFiles(pathname -> {
                if (pathname.getName().endsWith(".class")) {//我们只扫描class文件
                    return true;
                }
                return false;
            });
        } catch (URISyntaxException e) {
            throw new RuntimeException("未找到策略资源");
        }
    }

    public static CalPriceFactory getInstance() {
        return instance;
    }


}


