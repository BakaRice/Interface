package com.example;

class Base {
    int i = 86;
    public void amethod(){
        System.out.println("Base.amethod()");
    }
    public void  test(){
        System.out.println("testeste");
    }
    Base(){
        test();
        amethod();
    }
}
public class Derived extends Base{
    int i = 10;
    public static void main(String argv[]){
        Base b = new Derived();
        System.out.println(b.i);//86
        b.amethod();//Derived.amethod()
    }
    public void amethod(){
        System.out.println("Derived.amethod()");
    }
}
