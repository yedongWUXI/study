package com.example.demo.enumtest.enum_interface;

/**
 * @author zhangyedong
 * @date 2018/2/3.
 *
 * 这个Meal感觉没什么用 ，除了包含了所有的Food的枚举类型   ？？？
 *
 */
public enum Meal {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);

    private Food[] values;

    public Food[] getValues() {
        return values;
    }

    /**
     * 枚举构造器默认是私有的
     * @param kind
     */
    Meal(Class<? extends Food> kind) {
        values = kind.getEnumConstants();
    }

    /**
     * 通过接口组织枚举
     */
    public interface Food {
        enum Appetizer implements Food {
            SALAD, SOUP, SPRING_ROLLS;
        }

        enum MainCourse implements Food {
            LASAGNE, BURRITO, PAD_THAI, LENTILS, HUMMOUS, VINDALOO;
        }

        enum Dessert implements Food {
            TIRAMISU, GELATO, BLACK_FOREST_CAKE, FRUIT, CREME_CARAMEL;
        }

        enum Coffee implements Food {
            BLACK_COFFEE, DECAF_COFFEE, ESPRESSO, LATTE, CAPPUCCINO, TEA, HERB_TEA;
        }
    }


    public static void main(String[] args) {
        Meal[] mealValues = Meal.values();
        System.out.println("Meal.mealValues().length = "+mealValues.length);
        //遍历所有Food的枚举实例
        for (int i = 0; i < mealValues.length; i++) {
            Food[] correctEnum = mealValues[i].getValues();
            for (int j = 0; j<correctEnum.length;j++){
                System.out.println(correctEnum[j].toString());
            }
        }

        //通过接口组织枚举
        Food.Appetizer.SALAD.name();

    }
}
