package com.example11.nestedclass;

public class Person {
    private String name;
    private IQ iq;
    public Person(String name, IQ iq) {
        this.name = name;
        this.iq = iq;
    }
    public static class IQ {
        private int score;
        public IQ(int score) {
            this.score = score;
        }
        public int getScore() {
            return score;
        }
        public void setScore(int score) {
            this.score = score;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IQ getIq() {
        return iq;
    }

    public void setIq(IQ iq) {
        this.iq = iq;
    }


}
