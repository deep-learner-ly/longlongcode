package edu.basic.inout;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author: LongyunBian
 * @date: 2023/3/29 19:46
 * @Description: 非阻塞IO举例
 */
public class NIOExample {
    public static void main(String[] args) throws IOException {
        String fileName = "src/main/java/edu/basic/inout/example.txt";
        // FileChannel类来打开一个文件通道
        FileChannel channel = FileChannel.open(Paths.get(fileName));
        // ByteBuffer类来读取文件内容。allocate()方法用于分配一个新的缓冲区，
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (channel.read(buffer) > 0) {
            // flip()方法用于将缓冲区从写模式切换到读模式
//            buffer.putChar('!');
            buffer.flip();
            // hasRemaining()方法用于检查是否还有未读取的数据
            while (buffer.hasRemaining()) {
                // get()方法用于读取缓冲区中的数据
                System.out.print((char) buffer.get());
            }
            buffer.clear();
        }
        channel.close();



        String data = "Hello, world!";
        ByteBuffer buffer1 = ByteBuffer.wrap(data.getBytes());
        FileChannel channel1 = FileChannel.open(Paths.get(fileName), StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        channel1.write(buffer1);
        channel1.close();

    }
}
