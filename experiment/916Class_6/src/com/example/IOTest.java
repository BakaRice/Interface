package com.example;

import com.example.until.FileRootUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class IOTest {
    public static void main(String[] args) {
        String file = "from.txt";

        System.out.println("----- 创建文件 ------");
        createFile(file);

        System.out.println("-----  将字符串写入文件 -------");
        StringBuilder builder = new StringBuilder();
        // \r\n在txt文本中换行
        builder.append("白日依山尽\r\n");
        builder.append("黄河入海流\r\n");
        builder.append("欲穷千里目\r\n");
        builder.append("更上一层楼\r\n");
        writeToFile(builder.toString(), file);

        System.out.println("--------- 基于IO流复制文件 ----------");
        String toFile = "to.txt";
        copyByIO(file, toFile);

        System.out.println("---------- 删除指定文件 -------------");
        deleteFile(toFile);
    }

    // 在应用根root目录下，创建指定名称的文件
    // 如果文件已经存在，则忽略
    private static void createFile(String fileName) {
        Path p = FileRootUtils.getRoot().resolve(fileName);
        System.out.println(p);
        if (Files.exists(p){
            return;
        }
        try {
            Files.createFile(p);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 提示：文件以字节操作，因此可以
     * 通过调用字符串对象中的getBytes()方法，将字符串转为字节数组
     * 再通过Files.write()方法，保存
     *
     * @param content
     * @param file
     */
    private static void writeToFile(String content, String file) {
        byte[] bytes = content.getBytes();
        Path p = FileRootUtils.getRoot().resolve(file);
        try {
            Files.write(p, bytes);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * IO不支持NIO Path接口，因此需调用path对象的toString()方法转为字符串操作
     * 打印显示循环读写循环次数
     *
     * @param sourceFile
     * @param targetFile
     */
    private static void copyByIO(String sourceFile, String targetFile) {

    }

    /**
     * 删除文件
     * @param file
     */
    private static void deleteFile(String file) {

    }
}

