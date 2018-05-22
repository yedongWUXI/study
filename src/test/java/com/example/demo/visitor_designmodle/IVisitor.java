package com.example.demo.visitor_designmodle;

/**
 * @author zhangyedong
 * @date 2018/3/14.
 */
public interface IVisitor {
    //首先定义我可以访问普通员工
    void visit(CommonEmployee commonEmployee);
    //其次定义，我还可以访问部门经理
    void visit(Manager manager);
    //统计所有员工工资总和
    int getTotalSalary();
}
