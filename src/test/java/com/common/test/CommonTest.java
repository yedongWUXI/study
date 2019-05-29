package com.common.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.processing.AbstractProcessor;
import java.awt.image.DataBuffer;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.stream.Collectors;

/**
 * @author zhangyedong
 * @date 2018/2/26.
 */
public class CommonTest {
    @Transactional
    public void test() {

    }

    public static void main(String[] args) throws ClassNotFoundException {
        for (int i = 0, n = args.length; i < n; i++) {
            System.out.println("Arg " + i + ":" + args[i]);
        }
        System.out.println(11);
        Type type = new Type() {
            @Override
            public String getTypeName() {
                return null;
            }
        };

        Class.forName("");
    }

    @Test
    public void test1() {
        AbstractProcessor abstractProcessor = null;
        BeanDefinition beanDefinition = null;
        BeanDefinitionRegistry beanDefinitionRegistry = null;
        ClassLoader classLoader = null;
        ArrayBlockingQueue arrayBlockingQueue = null;
        Condition condition = null;
        ConcurrentHashMap concurrentHashMap = null;
        Exchanger exchanger = null;
        DataBuffer dataBuffer = null;
        Callable callable = null;
        ThreadPoolExecutor threadPoolExecutor = null;
        SortedMap<Integer, String> sortedMap = new TreeMap<Integer, String>();
        sortedMap.put(2, "2");
        sortedMap.put(1, "1");
        sortedMap.put(4, "4");
        sortedMap.put(3, "3");
        List<String> msgList = new ArrayList<>();
        msgList.add("1");
        msgList.add("1");
        msgList.add("1");
        msgList.add("2");
        List<String> collect = msgList.stream().distinct().collect(Collectors.toList());
        System.out.println(Arrays.toString(collect.toArray()));
    }

    /**
     * float double 在计算的时候由于计算机是转为最为接近的二进制的，所以计算出来不精确
     */
    @Test
    public void test2() {
        float a = (float) 0.1;
        float b = (float) 0.2;
        System.out.println(a * b);
        double a1 = 0.1;
        double b1 = 0.2;
        System.out.println(a1 * b1);


    }


    @Test
    public void test3() {
//        Duration;
    }

    @Test
    public void test4() {
        Map map = new HashMap();
        Object key = map.get("key");
        if (key == null) {
            key = new Object();
            map.put("key", key);
        }

        Object key1 = map.get("key");
        System.out.println(key1 == null);

        //java8之后多了这个更简便的方法，其实就是多了一个回调赋值的操作
        Object key2 = map.computeIfAbsent("key", k -> new Object());
    }

    @Test
    public void test5() {
        String msg = "{\"Obj_Type\":73,\"PowerType\":1,\"VehiclePowerTypeCodeFirst\":\"11\",\"area_id\":1,\"cond_data_info\":{},\"crossing_id\":1,\"ent_id\":\"8711123AEE0D4DE2938B4D42857DFD76\",\"equip_id\":\"3B5E24E7FFFD47B09554422CC83F6E09\",\"equip_no\":10282635,\"equip_vin\":\"GUOZHIYONG0000000\",\"event_handle_category\":\"RsuTrafficLight\",\"event_info\":{},\"gps_info\":{},\"light_info\":{},\"messageCategory\":\"RsuTrafficLight\",\"message_command\":\"3008\",\"obu_equipment_num\":\"12\",\"org_id\":\"8711123AEE0D4DE2938B4D42857DFD76\",\"parameterLength\":0,\"phase_data_size\":1,\"phone_no\":\"15381153292\",\"platform_rev_time\":\"20181010165645\",\"power_info\":{},\"priority_phase_id\":\"01\",\"priority_status\":\"01\",\"signal_light_equip_serial\":\"12\",\"state_info\":{},\"time_stamp_str\":\"121212121212\",\"uplinkMessageList\":[{\"Obj_Type\":3,\"cond_data_info\":{},\"content\":\"01\",\"event_handle_category\":\"RsuTrafficLight\",\"event_info\":{},\"gps_info\":{},\"green_light_time\":1,\"id\":1,\"light_info\":{},\"messageCategory\":\"RsuTrafficLight\",\"number\":1,\"power_info\":{},\"red_light_time\":1,\"residue_seconds\":1,\"state\":1,\"state_info\":{},\"yellow_light_time\":1}],\"vehicle_code\":\"GZY00\",\"vehicle_id\":\"3B5E24E7FFFD47B09554422CC83F6E09\",\"vehicle_ln\":\"豫AGZY00\",\"vehicle_no\":10282635,\"vehicle_vin\":\"GUOZHIYONG0000000\"}";
        JSONObject jsonObject = (JSONObject) JSONObject.parse(msg);
        String equip_id = (String) jsonObject.get("equip_id");
        System.out.println(equip_id);
    }

    /**
     * 进制转换如果超过int的最大值要用BigInteger
     */
    @Test
    public void test6() {
        String s = "D5D22C80";
        String intStr = new BigInteger(s, 16).toString();
        System.out.println(intStr);
        System.out.println(Double.valueOf(intStr));
    }

    @Test
    public void test7() {
        String s = "";
        System.out.println(s == "");
    }

    @Test
    public void test8() {
        int a = 1;
        int b = 2;
        int c = 3;
        if (a == 1) {
            System.out.println(1);

        } else if (b == 2) {
            System.out.println(2);
        } else if (c == 3) {
            System.out.println(3);
        }

        ArrayList<String> strings = new ArrayList<>();
        strings.add("A");
        System.out.println(strings.contains("a"));
    }

    @Test
    public void test9() {

        List<String> lower = new ArrayList<>();

        String s = "abcde";
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            System.out.println("a".equals(String.valueOf(aChar)));
            System.out.println(aChar);
        }

        StringBuffer sb = new StringBuffer(s);
//        sb.append("_",1,3);
        sb.insert(1, "_");
        System.out.println(sb.toString());

    }


    @Test
    public void test10() {
//        String s = "    TB_VEHICLE_MODEL.POWER_TYPE   \n" +
//                "    TB_VEHICLE.TERMINAL_NETWORK_ST\n" +
//                "AccState                          \n" +
//                "EngineRotateSpeed                 \n" +
//                "cond_data_info.m_motor_rotate     \n" +
//                "VehicleSpeed                      \n" +
//                "PONENT_PARAM_VAL.PARAM_VAL        \n" +
//                "GPSValid                          \n" +
//                "RSSI2G                            \n" +
//                "RSSI3G                            \n" +
//                "RSSIWireless                      \n" +
//                "TerminalTime                      \n" +
//                "GPSLongitude                      \n" +
//                "GPSLatitude                       \n" +
//                "AirCondition.AirConditionState    \n" +
//                "Hearter.HearterWork               \n" +
//                "Terminal.MainPowerVoltageLack     \n" +
//                "FuelVolume                        \n" +
//                "ICLE_MODEL.POWER_FIRST_VOL        \n" +
//                "ICLE.CURRENT_LIMIT_SPD_THRESHOLD  \n" +
//                "ExternalVoltage                   \n" +
//                "EngineOilPressure                 \n" +
//                "EngineCoolantTemperature          \n" +
//                "MINAL.TERMINAL_CODE               \n" +
//                "AL表的TERMINAL_ID关联的                \n" +
//                "_CARD_INFO表的                      \n" +
//                "_CARD_INFO.PHONE_NO           \n" +
//                "ICLE_MODEL.POWER_TYPE             \n" +
//                "FuelVolume                   \n" +
//                "ICLE_MODEL.POWER_FIRST_VOL        \n" +
//                "Door.Door1OpenClose               \n" +
//                "ICLE.VEHICLE_CODE  ";


        String s = "TB_VEHICLE.VEHICLE_ID\n" +
                "        TB_VEHICLE.VEHICLE_LN\n" +
                "        state_info.on_gear_ex\n" +
                "        timestamp\n" +
                "\n" +
                "\n" +
                "        RemainingGas\n" +
                "        _MODEL.POWER_TYPE\n" +
                "        state_info.acs\n" +
                "        power_info.dd_fuel_level\n" +
                "        cond_data_info.psv24\n" +
                "        cond_data_infoe_oil_press\n" +
                "        e_cool_water_temper\n" +
                "        e_rotate_spd\n" +
                "        m_motor_rotate\n" +
                "        power_info.i_fuel_cons\n" +
                "        cond_data_infom_motor_temper\n" +
                "        cond_data_info.m_motor_ctrl_bus_vol";

        String s1 = s.trim().replaceAll("\\u00A0", "").trim().replaceAll(" ", "");
        System.out.println(s1);


    }


    @Test
    public void test11() {
        String s = "  h e ll o";
        s.replaceAll(" ", "").trim();
        System.out.println(s);
    }


    @Test
    public void test12() {
        Byte a = 66;
        System.out.println(a == 66);
    }

    @Test
    public void test13() throws IOException {
        Map map = new HashMap();
        List<Map> list = new ArrayList<>();
        List<map> list3 = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        map.put("test", "22");
        list.add(map);
        map = new HashMap();
        map.put("test2", "33");
        list.add(map);
        map = new HashMap();
        map.put("test3", "44");
        list.add(map);

        list1.add("1");
        list1.add("2");
        list1.add("3");

        map map1 = new map();
        map1.setK("test");
        map1.setV("22");
        list3.add(map1);
        map1 = new map();
        map1.setK("test");
        map1.setV("33");
        list3.add(map1);
        map1 = new map();
        map1.setK("test");
        map1.setV("44");
        list3.add(map1);
        System.out.println(JSON.toJSONString(list));
        System.out.println(JSON.toJSONString(list1, SerializerFeature.DisableCircularReferenceDetect));
        System.out.println(JSON.toJSONString(list3));
        System.out.println(JacksonUtil.bean2Json(list3));


    }

    @Data
    class map {
        String k;
        String v;
    }


}