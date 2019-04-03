package com.example20.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class ImmutableCollectionTest {
    public static void main(String[] args) {
        // getImmutableList();
        // getImmutableList2();
        getImmutableList3();
    }

    private static void getImmutableList() {
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        List<User> users = List.of(user, user2, user3);
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    private static void getImmutableList2() {
        User user = new User("BO");
        User user2 = new User("SUN");
        List<User> users = List.of(user, user2);
        User user3 = new User("ZHANG");
        // UnsupportedOperationException异常
        users.add(user3);
    }
    private static void getImmutableList3() {
        User user = new User("BO");
        User user2 = new User("SUN");
        List<User> users = List.of(user, user2);
        for (User u : users) {
            u.setName("ZHANG");
        }
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    private static void getImmutableMap() {
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        Map<Integer, User> userMap = Map.of(1, user, 2, user2, 3, user3);
    }

}
