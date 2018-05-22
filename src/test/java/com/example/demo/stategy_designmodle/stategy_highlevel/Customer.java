package com.example.demo.stategy_designmodle.stategy_highlevel;

/**
 * Created by zhangyedong on 2018/1/
 *
 * context
 */
public class Customer {
    private Double totalAmount = 0D;//客户在本商店消费的总额
    private Double amount = 0D;//客户单次消费金额
    private CalPrice calPrice = new Common();//每个客户都有一个计算价格的策略，初始都是普通计算，即原价

    //客户购买商品，就会增加它的总额

    /**
     * 测试文档注释 ^J
     * @param amount
     */
    public void buy(Double amount) {
        this.amount = amount;
        totalAmount += amount;
    /* 变化点，我们将策略的制定转移给了策略工厂，将这部分责任分离出去 */
        calPrice = CalPriceFactory.getInstance().createCalPrice(this);
    }

    //计算客户最终要付的钱
    public Double calLastAmount() {
        return calPrice.calPrice(amount);
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public Double getAmount() {
        return amount;
    }

}
