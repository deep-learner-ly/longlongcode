package edu.singleton;

/**
 * @ClassName LazySingleton
 * @Author ly
 * @Date 2023/3/25 下午11:22
 * @Description 懒汉式单例模式 多线程不能保证单例唯一 懒加载
 **/
public class LazySingleton {
    private byte [] data = new byte[1024];
    private static LazySingleton instance = null;
    private LazySingleton(){

    }
    public static LazySingleton getInstance(){
        if (instance==null)
            instance = new LazySingleton();
        return instance;
    }
}
