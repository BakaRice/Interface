package com.homework.h02;

/**
 * 作业2，2019.03.24
 * 接口，继承，匿名内部类
 * 分析：Android系统中，组件均可被点击，Android通过监听屏幕触摸确定组件被点击了，但组件点击的结果(比如，弹出窗口，路由至下一页等)，需App开发者在开发创建组件时决定。
 * 通过接口，类，继承，匿名内部类，简单的模拟Android抽象的组件点击事件的设计实现方法
 * 创建一个可点击的Button组件，创建2个不同的button对象，实现封装不同的点击实现。
 *
 * 思路：
 * 抽象出组件类View
 * 所有View均可被点击，则创建内部点击监听接口，ViewOnClickListener，创建抽象的点击事件方法，onClick()，可以无参数，无返回值
 * 可被点击的能力，封装为View的一个属性
 * 创建类Button，作为View的一个子组件，封装在页面上显示的文本描述(提交/取消/同意等等)，text属性；Button自动具有父类View的被点击的能力
 *
 * 创建测试类，在主函数中创建2个Button，基于匿名内部类实现，一个button点击后，打印submit，一个实现打印cancel
 *
 * 理解，抽象设计的过程，以及实现方法
 */
public class Test {
    public static void main(String[] args) {
        Button b1 = new Button(new View.ViewOnClickListener() {
            @Override
            public void onClick() {
                System.out.println("submit");
            }
        }, "提交");
        b1.getViewOnClickListener().onClick();;

        Button b2 = new Button(new View.ViewOnClickListener() {
            @Override
            public void onClick() {
                System.out.println("cancel");
            }
        }, "取消");
        b2.getViewOnClickListener().onClick();
    }

}
