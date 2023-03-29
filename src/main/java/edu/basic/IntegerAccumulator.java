package edu.basic;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author: LongyunBian
 * @date: 2023/3/27 18:33
 * @Description: 不可变对象示例
 */
public final class IntegerAccumulator {
    private final int init;
    public IntegerAccumulator(int init){
        int i=0;
        this.init = init;
    }
    public IntegerAccumulator(IntegerAccumulator accumulator,int init){
        this.init = accumulator.getValue()+init;
    }

    public int getValue() {
        return init;
    }
    public IntegerAccumulator add(int i){
        return new IntegerAccumulator(this,i);
    }

    public static void main(String[] args) {
        IntegerAccumulator accumulator = new IntegerAccumulator(0);
        IntStream.range(0,3).forEach(i->new Thread(()->{
            int inc = 0;
            while (true){
                int oldV = accumulator.getValue();
                int result = accumulator.add(inc).getValue();
//                accumulator =  accumulator.add(inc);
                System.out.printf("%d + %d = %d\n",oldV,inc,result);
                if (inc+oldV!=result){
                    System.err.printf("ERROR: %d + %d = %d\n",oldV,inc,result);
                }
                inc++;
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start());
    }
}
