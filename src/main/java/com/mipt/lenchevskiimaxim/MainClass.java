package com.mipt.lenchevskiimaxim;

interface Student {
    Object study(Object obj);
}

abstract class WorkingClass {
    abstract void work(int num);

    boolean goHome(String a, String b){
        return a.equals(b);
    }
}

public class MainClass {

    private int firstField;
    private String secondField;
    protected static double thirdField;
    public final long fourthField = 1337;

    public static void main(String[] args) {
        for (int i = 0; i < 15; ++i) {
            System.out.println("Iter:" + i);
        }
    }
}
