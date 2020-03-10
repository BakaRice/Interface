package com.example21.collectionstream.resource;

import com.example21.collectionstream.entity.Apple;

import java.util.List;

public class Database {
    private static List<Apple> apples = create();
    private static List<Apple> create() {
        Apple apple = new Apple(1, Apple.Color.RED, 200);
        Apple apple2 = new Apple(2, Apple.Color.GREEN, 250);
        Apple apple3 = new Apple(3, Apple.Color.RED, 260);
        Apple apple4 = new Apple(4, Apple.Color.GREEN, 230);
        return List.of(apple, apple2, apple3, apple4);
    }
    public static List<Apple> getApples() {
        return apples;
    }
}
