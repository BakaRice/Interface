package com.example20.collection;

import java.util.*;

public class MapTest {
    public static void main(String[] args) {
        // getMapBaseOp();
        // getMapBaseOp2();
        // getMapBaseOp3();
        // getMapBaseOp4();
        // getMapBaseOp5();
        // getMapStringKey();
        // getKeySet();
        // getRemove();
    }

    private static void getMapBaseOp() {
        Map<String, String> map = new HashMap<>();
        map.put("BO", "956");
        map.put("SUN", "925");
        System.out.println(map.size());
        System.out.println(map.get("BO"));

    }

    private static void getMapBaseOp2() {
        Map<String, String> map = new HashMap<>();
        map.put("BO", "956");
        map.put("BO", "925");
        System.out.println(map.size());
        System.out.println(map.get("BO"));

    }

    private static void getMapBaseOp3() {
        User user = new User(1, "BO", User.HAERBIN);
        User user2 = new User(2, "SUN", User.BEIJING);
        User user3 = new User(3, "ZHANG", User.HAERBIN);
        Map<Integer, User> uMap = new HashMap<>();
        uMap.put(user.getId(), user);
        uMap.put(user2.getId(), user2);
        uMap.put(user3.getId(), user3);
        System.out.println(uMap.size());
        User u = uMap.get(1);
        System.out.println(u.getCity());


    }

    private static void getMapBaseOp4() {
        User user = new User(1, "BO", User.HAERBIN);
        User user2 = new User(2, "SUN", User.BEIJING);
        User user3 = new User(3, "ZHANG", User.BEIJING);
        User user4 = new User(4, "LIU", User.HAERBIN);

        List<User> hList = new ArrayList<>();
        hList.add(user);
        hList.add(user4);
        List<User> bList = new ArrayList<>();
        bList.add(user2);
        bList.add(user3);

        Map<String, List<User>> uMap = new HashMap<>();
        uMap.put(User.HAERBIN, hList);
        uMap.put(User.BEIJING, bList);
        System.out.println(uMap.size());
        for (User u : uMap.get(User.BEIJING)) {
            System.out.println(u.getName());
        }
    }

    private static void getMapBaseOp5() {
        User user = new User(1, "BO", User.HAERBIN);
        User user2 = new User(2, "SUN", User.BEIJING);
        User user3 = new User(3, "ZHANG", User.BEIJING);
        User user4 = new User(4, "LIU", User.HAERBIN);
        List<User> users = new ArrayList<>();
        users.add(user); users.add(user2);
        users.add(user3);users.add(user4);

        Map<String, List<User>> uMap = new HashMap<>();
        for (User u : users) {
            List<User> us = uMap.get(u.getCity());
            if (us == null) {
                us = new ArrayList<>();
                us.add(u);
                uMap.put(u.getCity(), us);
            } else {
                us.add(u);
            }
        }
        for (User u : uMap.get(User.HAERBIN)) {
            System.out.println(u.getName());
        }
    }

    private static void getMapStringKey() {
        String name = "BO";
        System.out.println(name.hashCode());
        String name2 = new String("BO");
        System.out.println(name2.hashCode());
        System.out.println(name == name2);
        System.out.println(name.equals(name2));
        Map<String, String> nMap = new HashMap<>();
        nMap.put(name, "956");
        nMap.put(name2, "925");
        System.out.println(nMap.size());
    }

    private static void getKeySet() {
        User user = new User(1, "BO", "哈尔滨");
        User user2 = new User(2, "SUN", "北京");
        User user3 = new User(3, "ZHANG", "上海");
        Map<Integer, User> uMap = new HashMap<>();
        uMap.put(user.getId(), user);
        uMap.put(user2.getId(), user2);
        uMap.put(user3.getId(), user3);
        Set<Integer> nMapKeys = uMap.keySet();
        for (int i : nMapKeys) {
            System.out.println(i);
        }
    }

    private static void getRemove() {
        User user = new User(1, "BO", "哈尔滨");
        User user2 = new User(2, "SUN", "北京");
        User user3 = new User(3, "ZHANG", "上海");
        Map<Integer, User> uMap = new HashMap<>();
        uMap.put(user.getId(), user);
        uMap.put(user2.getId(), user2);
        uMap.put(user3.getId(), user3);
        uMap.remove(1);
    }
}
