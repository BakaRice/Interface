package com.example21.collectionstream;

import com.example21.collectionstream.entity.Apple;
import com.example21.collectionstream.resource.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {

    public static void main(String[] args) {
        // getForEach();
        // getFilter();
        // getRedApples(Apple.Color.RED);
        // getStreamMap(Apple.Color.GREEN);
        // getColorAndWeight(Apple.Color.RED, 200);
        // getFilter();
        // getMap();
        // getCollect();
        getCollectGroupingBy();
    }

    private static void getForEach() {
        Database.getApples()
                .forEach(a -> System.out.println(a.getWeight()));
    }

    /**
     * 返回指定颜色的苹果
     */
    private static void getRedApples(Apple.Color c) {
        List<Apple> reds = new ArrayList<>();
        for (Apple a : Database.getApples()) {
            if (c == a.getColor()) {
                reds.add(a);
            }
        }
        System.out.println(reds.size());
    }

    private static void getStreamMap(Apple.Color c) {
        // 基于源集合，创建流
        Stream<Apple> appleStream = Database.getApples().stream();
        // 基于颜色，过滤流中的元素对象，将符合的元素置于新的流
        Stream<Apple> colorStream = appleStream.filter(a -> c == a.getColor());
        // 将流中元素，聚合为List集合
        List<Apple> apples = colorStream.collect(Collectors.toList());

        // stream方法链
        List<Apple> apples2 = Database.getApples()
                .stream()
                .filter(a -> c == a.getColor())
                .collect(Collectors.toList());
    }

    private static void getColorAndWeight(Apple.Color c, int weight) {
        List<Apple> apples = Database.getApples()
                .stream()
                .filter(a -> c == a.getColor())
                .filter(a -> weight == a.getWeight())
                .collect(Collectors.toList());

        apples.forEach(a -> System.out.println(a.getId()));

        Database.getApples()
                .stream()
                .filter(a -> c == a.getColor() && weight == a.getWeight())
                .collect(Collectors.toList());
    }

    private static void getFilter() {
        Apple a1 = new Apple(1, Apple.Color.RED, 200);
        Apple a2 = new Apple(5, Apple.Color.GREEN, 240);
        List<Apple> newApples = List.of(a1, a2);
        List<Apple> oldApples = Database.getApples();
        List<Apple> apples = new ArrayList<>();
        for (Apple a : newApples) {
            for (Apple oa : oldApples) {
                if (a.getId() == oa.getId()) {
                    apples.add(a);
                }
            }
        }
        apples.forEach(a -> System.out.println(a.getId()));

        List<Apple> apples2 = newApples.stream()
                .filter(a -> oldApples.stream()
                                .filter(oa -> oa.getId() == a.getId())
                                .count() > 0)
                .collect(Collectors.toList());
        apples2.forEach(a -> System.out.println(a.getId()));
    }

    // 将重量映射为新集合，并打印
    private static void getMap() {
        Database.getApples()
                .stream()
                .map(a -> a.getWeight())
                .collect(Collectors.toList())
                .forEach(i -> System.out.println(i));

        Database.getApples()
                .stream()
                .map(Apple::getWeight)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private static void getCollect() {
        Database.getApples()
                .stream()
                .map(Apple::getColor)
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("-----------");

        Database.getApples()
                .stream()
                .map(Apple::getColor)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
    }

    private static void getCollectGroupingBy() {
        Map<Apple.Color, List<Apple>> map = Database.getApples()
                .stream()
                .collect(Collectors.groupingBy(a -> a.getColor()));

        Map<Integer, Apple> map2 = Database.getApples()
                .stream()
                .collect(Collectors.toMap(Apple::getId, a -> a));

        map2.forEach((k, v) -> {
            System.out.println(k + "/" + v.getWeight());
        });
    }


}
