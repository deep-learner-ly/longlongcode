package edu.singleton;

/**
 * @ClassName HungrySingleton
 * @Author ly
 * @Date 2023/3/25 下午11:19
 * @Description 饿汉式单例模式 线程安全 无法懒加载
 **/
public class HungrySingleton {
    private byte [] data = new byte[1024];
    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return instance;
    }
}
