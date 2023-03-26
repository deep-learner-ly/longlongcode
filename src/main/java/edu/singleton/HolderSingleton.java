package edu.singleton;

/**
 * @ClassName HolderSingleton
 * @Author ly
 * @Date 2023/3/26 下午11:17
 * @Description Holder
 **/
public class HolderSingleton {
    private byte [] data = new byte[1024];
    private HolderSingleton(){

    }
    private static class Holder{
        private static HolderSingleton instance = new HolderSingleton();
    }
    public static HolderSingleton getInstance(){
        return Holder.instance;
    }
}
