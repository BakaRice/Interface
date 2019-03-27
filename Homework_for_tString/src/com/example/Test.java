package com.example;

import java.util.Scanner;

public class Test {
    /*
    * 本质上是想要实现普遍的从文件目录中提取出带有后缀名的文件
    *   在进行搜索不包含文件路径的文件名称，应该把他的所以根目录都导出然后每一个都判断是否存在带有
    *   后缀的文件，并且找到该文件
    * */
    public static void main(String[] args) {

        String fdir = "/courses/lecture/lecture01.pdf";//定义新的对象 文件目录,并且赋予初始值；
       // System.out.println(fdir.lastIndexOf("/"));
        String []a= fdir.split("/");
        System.out.println("分解后的单词个数为："+a.length);
        System.out.println("分解后的文件目录如下");

        int temp = 0;
        int p = 0;//一定要写初始化值
        for(int i=0;i<a.length;i++)
        {
            if(a[i].length()!=0){//防止一个字符即为"/"
            temp++;
            System.out.println("文件目录"+temp+" "+a[i]);
            if(a[i].indexOf(".")!=-1)
                p = i;
        }
        }
        System.out.println("找到文件存在后缀名位于文件目录"+p);
        System.out.println(a[p]);
        String temp_ = a[p];
        String []b  = temp_.split("\\.");//正则表达式
        System.out.println("文件名 "+b[0]);
        System.out.println("后缀名 "+b[1]);

    }
}
