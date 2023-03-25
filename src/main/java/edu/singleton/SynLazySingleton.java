package edu.singleton;

/**
 * @ClassName SynLazySingleton
 * @Author ly
 * @Date 2023/3/25 下午11:30
 * @Description 同步的懒汉式单例
 **/
public class SynLazySingleton{
    private byte [] data = new byte[1024];
    private static SynLazySingleton instance = null;
    private SynLazySingleton(){

    }
    public static synchronized SynLazySingleton getInstance(){
        // synchronized 导致同一时刻只能有被一个线程访问，性能低下
        if (instance==null)
            instance = new SynLazySingleton();
        return instance;
    }
}
