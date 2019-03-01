package com.design.demo.utils;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.design.demo.utils.JsonUtil.*;

/**
 * @Description: java类作用描述
 * @Author: wxzhangyd
 * @Date: 2018/10/11 14:07
 * @Modified by:
 */

public class JsonTest {
    @Test
    public void test() {
        List list = new ArrayList();
        Map map1 = new HashMap();


        for (int j = 0; j < 10; j++) {
            List listMin = new ArrayList();
            for (int i = 0; i < 10; i++) {
                Map<String, String> map = new HashMap();
                map.put(j + i + "", i + j + "");
                listMin.add(map);
            }
            list.add(listMin);

        }

//        Object put = map1.put(0+"", 1+"");
//        Object put1 = map1.put(0+"", 2+"");
//        Object put2 = map1.put(0+"", 3+"");
//        Object put3 = map1.put(0+"", 4+"");

        String s = bean2Json(list);
        System.out.println(s);
        List o = (List) stringToBean(s, List.class);
        List o1 = (List) o.get(0);
        Map o2 = (Map) o1.get(0);
        String o3 = (String) o2.get("0");
        System.out.println(o3);
    }


    @Test
    public void test1() {
        String json = "{\"ID\":\"F34B862B2A894D46B0D26FF306636ABE\",\"BusinessType\":\"BST_PASS_THROUGH_${CMDID}\",\"TerminalId\":\"68026E4157D746FB946EDF205FD36530\",\"DatasReserve\":{\"buss\":1,\"sim_no\":\"18611110030\",\"terminal_time\":\"2018-06-21 16:14:46.851\",\"device_id\":11120,\"device_no\":10287277,\"device_vin\":\"XINNENGYUAN000030\",\"device_ln\":\"豫YRL30\",\"device_sn\":\"17X000N-0030\"},\"Datas\":{\"AckSerialNumber\":\"68026E415\",\"AckArgsList\":{\"CommonOrderDataSettings\":{\"OrderCanIdList\":[{\"OrderCanId\":218039844},{\"OrderCanId\":218040100},{\"OrderCanId\":419418135}],\"OrderPeriod\":20},\"SingleTriggerDataSettings\":{\"SingleTriggerCanIdList\":[{\"SingleTriggerCanId\":419367972},{\"SingleTriggerCanId\":419372068}]},\"MultiPacketOrderDataSettings\":{\"MultiPacketPeriod\":1,\"BamCanId\":2,\"DataCanId\":3},\"RepeatedTriggerDataSettings\":{\"RepeatedTriggerCanIdList\":[{\"RepeatedTriggerCanId\":1},{\"RepeatedTriggerCanId\":2}]}}}}";
        JSONObject jsonObject = JSONObject.parseObject(json);
        flatJson(jsonObject);
        System.out.println(jsonObject.toJSONString());
    }
}
