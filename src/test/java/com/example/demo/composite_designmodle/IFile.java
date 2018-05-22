package com.example.demo.composite_designmodle;

/**
 * @author zhangyedong
 * @date 2018/2/27.
 */
//文件系统中的节点接口
public interface IFile {
    //下面两个方法，相当于类图中operation方法
    void delete();

    String getName();

    /* 以上为公共行为，以下为文件夹才有的行为 */

    //创建新文件，相当于add方法
    void createNewFile(String name);

    //相当于remove方法
    void deleteFile(String name);

    //相当于GetChild方法
    IFile getIFile(int index);
}
