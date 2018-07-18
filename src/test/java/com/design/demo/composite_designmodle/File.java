package com.design.demo.composite_designmodle;

/**
 * @author zhangyedong
 * @date 2018/2/27.
 */
public class File implements IFile {
    private String name;
    private IFile folder;

    File(String name, IFile folder) {
        super();
        this.name = name;
        this.folder = folder;
    }

    public String getName() {
        return name;
    }

    public void delete() {
        folder.deleteFile(name);
        System.out.println("---删除[" + name + "]---");
    }

    //文件不支持创建新文件
    public void createNewFile(String name) {
        throw new UnsupportedOperationException();
    }

    //文件不支持删除文件
    public void deleteFile(String name) {
        throw new UnsupportedOperationException();
    }

    //文件不支持获取下面的文件列表
    public IFile getIFile(int index) {
        throw new UnsupportedOperationException();
    }
}
