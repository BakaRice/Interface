package com.example12.enumtype;

public class EnumTest {
    public static void main(String[] args) {
        System.out.println("--------base enum --------");
        System.out.println(getSeason("下课"));

        System.out.println(getEnumSession(Season.SPRING));

    }
    private static String getEnumSession(Season season) {
        String msg = "";
        switch (season) {
            case SPRING:
                msg = "花儿开啦！";
                break;
            case SUMMER:
                msg = "我喜欢凉爽的天气！";
                break;
            case AUTUMN:
                msg = "虽然可以游泳";
                break;
            case WINTER:
                msg = "极端的天气！";
                break;
        }
        return msg;
    }

    private static String getSeason(String season) {
        String msg = "";
        switch (season) {
            case "Spring":
                msg = "花儿开啦！";
                break;
            case "Summer":
                msg = "我喜欢凉爽的天气！";
                break;
            case "Autumn":
                msg = "虽然可以游泳";
                break;
            case "Winter":
                msg = "极端的天气！";
                break;
        }
        return msg;
    }

}
