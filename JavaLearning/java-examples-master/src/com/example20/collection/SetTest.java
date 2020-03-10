package com.example20.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        // getAddElement();
        //getForEach();
    }

    private static void getAddElement() {
        Set<User> users = new HashSet<>();
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = user;
        users.add(user);
        users.add(user2);
        users.add(user3);
        System.out.println(users.size());
    }

    private static void getForEach() {
        Set<User> users = new HashSet<>();
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("ZHANG");
        users.add(user);
        users.add(user2);
        users.add(user3);
        for (User u : users) {
            System.out.println(u.getName());
        }
    }
}
