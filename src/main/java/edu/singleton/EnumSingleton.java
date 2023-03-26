package edu.singleton;

/**
 * @ClassName EnumSingleton
 * @Author ly
 * @Date 2023/3/26 下午11:21
 * @Description 枚举实现单例
 **/
public enum EnumSingleton {
    INSTANCE;
    private byte [] data = new byte[1024];
    EnumSingleton(){
//        System.out.println("");
    }
    public static void method(){

    }
    public EnumSingleton getInstance(){
        return INSTANCE;
    }
}
