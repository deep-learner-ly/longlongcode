package edu.basic;

import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class IntegerAccumulatorTest {

    @Test
    public void add() {
        IntegerAccumulator accumulator = new IntegerAccumulator(0);
        IntStream.range(0,3).forEach(i->new Thread(()->{
            int inc = 0;
            while (true){
                int oldV = accumulator.getValue();
                int result = accumulator.add(inc).getValue();
                System.out.printf("%d + %d = %d",oldV,i,result);
                if (inc+oldV!=result){
                    System.err.printf("ERROR: %d + %d = %d",oldV,i,result);
                }
                inc++;
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start());
    }
}