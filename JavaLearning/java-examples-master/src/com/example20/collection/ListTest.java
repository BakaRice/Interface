package com.example20.collection;

import java.util.ArrayList;
import java.util.List;

public class ListTest {
    private static List<User> users = create();

    private static List<User> create() {
        List<User> users = new ArrayList<>();
        User user = new User("BO");
        User user2 = new User("SUN");
        User user3 = new User("SUN");
        users.add(user);
        users.add(user2);
        users.add(user3);
        return users;
    }

    public static void main(String[] args) {
        getSize();
        getElementByIndex();
        getUpdateElement();
        addRepeatElement();
        //getConcurrentModificationException();
    }

    private static void getSize() {
        System.out.println(users.isEmpty());
        System.out.println(users.size());
        for (User u : users) {
            System.out.println(u.getName());
        }
    }

    private static void getElementByIndex() {
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            System.out.println(user.getName());
        }
    }
    private static void getUpdateElement() {
        List<User> users = new ArrayList<>();
        User user = new User("BO");
        User user2 = new User("SUN");
        users.add(user);
        users.add(user2);
        for (User u : users) {
            u.setName("ZHANG");
        }
        System.out.println(user.getName());
        System.out.println(user2.getName());
    }

    private static void addRepeatElement() {
        User user = users.get(0);
        users.add(user);
        System.out.println(users.size());
        for (User u : users) {
            System.out.println(u);
        }
    }
    // 将产生异常
    private static void getConcurrentModificationException() {
        for (User u : users) {
            if ("BO".equals(u.getName())) {
                users.remove(u);
            }
        }
    }
}
