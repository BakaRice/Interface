//package com.homework.h03;

/**
 * 作业3，2019.03.24
 * 字符串处理
 * 通过字符串处理方法，从以下路径中提取出文件名称(lecture01)，扩展名(pdf)，在控制台分别打印输出
 */
public class Test {
    /**
     * 无论是包含"/"路径，还是仅包含文件名称
     * @param args
     */
    public static void main(String[] args) {
       String file = "/courses/lectures/lecture01.pdf";
        //String file = "lecture01.pdf";
        // String file = ".gitignore";
        System.out.println(getFileName(file));
        System.out.println(getFileExtensionName(file));
    }

    private static String getFileName(String file) {
        return file.substring(file.lastIndexOf("/") + 1,
                file.lastIndexOf("."));
    }

    private static String getFileExtensionName(String file) {
        return file.substring(file.lastIndexOf(".") + 1);
    }
}
