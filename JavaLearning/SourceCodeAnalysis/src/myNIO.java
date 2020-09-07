
import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

public class myNIO {

    public static void Buffer_exec() {
        System.out.println("\n+最初创建--------------------------------------");
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->" + byteBuffer.limit());
        System.out.println("初始时-->position--->" + byteBuffer.position());
        System.out.println("初始时-->capacity--->" + byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("\n+添加数据后--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "Ri3eMarch";
        byteBuffer.put(s.getBytes());


        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->" + byteBuffer.limit());
        System.out.println("put完之后-->position--->" + byteBuffer.position());
        System.out.println("put完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());

        System.out.println("\n+切换为读模式--------------------------------------");

        byteBuffer.flip();
        System.out.println("flip完之后-->limit--->" + byteBuffer.limit());
        System.out.println("flip完之后-->position--->" + byteBuffer.position());
        System.out.println("flip完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("flip完之后-->mark--->" + byteBuffer.mark());


        System.out.println("\n+读取缓冲区数据get()--------------------------------------");

        byte[] bytes = new byte[byteBuffer.limit()];

        byteBuffer.get(bytes);
        System.out.println(new String(bytes, 0, bytes.length));

        System.out.println("\n+缓冲区数据读取后 get()后--------------------------------------");


        System.out.println("get()完之后-->limit--->" + byteBuffer.limit());
        System.out.println("get()完之后-->position--->" + byteBuffer.position());
        System.out.println("get()完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("get()完之后-->mark--->" + byteBuffer.mark());

        System.out.println("\n+缓冲区数据清空 clear()后--------------------------------------");
        byteBuffer.clear();
        System.out.println("clear()完之后-->limit--->" + byteBuffer.limit());
        System.out.println("clear()完之后-->position--->" + byteBuffer.position());
        System.out.println("clear()完之后-->capacity--->" + byteBuffer.capacity());
        System.out.println("clear()完之后-->mark--->" + byteBuffer.mark());

    }

    public static void Channel_exec() {
        System.out.println("Channel通道 执行");

        try {
            FileInputStream fileInputStream = new FileInputStream("F:\\L.txt");

            FileChannel inchannel = fileInputStream.getChannel();

            FileChannel.open(Paths.get("F:\\L.txt"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Channel_exec();
    }
}
