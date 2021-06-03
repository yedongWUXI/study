package core.page;

import com.design.demo.domain.Car;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description: 逻辑分页
 * @Author: yedong
 * @Date: 2020/9/9 15:14
 * @Modified by:
 */

public class PageTest {


    /**
     * excel 分页
     *
     * @param dataList    分页数据
     * @param pageSize    页面大小
     * @param currentPage 当前页
     * @return
     */
    public List<Map<String, String>> pageExcel(List<Map<String, String>> dataList, int pageSize, int currentPage) {

        List<Map<String, String>> currentPageList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            int currIdx = (currentPage > 1 ? (currentPage - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < dataList.size() - currIdx; i++) {
                Map<String, String> map = dataList.get(currIdx + i);
                currentPageList.add(map);
            }

        }
        return currentPageList;
    }

    /**
     * dto 分页
     *
     * @param dataList    分页数据
     * @param pageSize    页面大小
     * @param currentPage 当前页
     * @return
     */
    public <T> List<T> pageDto(List<T> dataList, int pageSize, int currentPage) {

        List<T> currentPageList = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            int currIdx = (currentPage > 1 ? (currentPage - 1) * pageSize : 0);
            for (int i = 0; i < pageSize && i < dataList.size() - currIdx; i++) {
                T map = dataList.get(currIdx + i);
                currentPageList.add(map);
            }

        }
        return currentPageList;
    }


    @Test
    public void test() {

        List<Car> list = new ArrayList<>();

        for (int i = 0; i < 100; i++) {

            Car build = Car.builder().id((long) i).make("1").model("1").build();
            list.add(build);
        }


        List<Car> cars = this.pageDto(list, 10, 3);

        cars.stream().peek(v -> System.out.println(v.getId())).collect(Collectors.toList());


    }


}
