package edu.singleton;

import java.net.Socket;
import java.sql.Connection;

/**
 * @ClassName DoubleCheckSingleton
 * @Author ly
 * @Date 2023/3/26 下午11:12
 * @Description double check
 **/
public class DoubleCheckSingleton {
    private byte [] data = new byte[1024];
    private static volatile DoubleCheckSingleton instance = null;
    // private static DoubleCheckSingleton instance = null;
    Connection conn;
    Socket socket;
    private DoubleCheckSingleton(){
        // 初始化conn
        // 初始化socket
    }

    public static DoubleCheckSingleton getInstance(){
        if (null==instance){
            synchronized (DoubleCheckSingleton.class){
                if (null==instance){
                    instance = new DoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
