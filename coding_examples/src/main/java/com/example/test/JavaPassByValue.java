package com.example.test;

/**
 * We pass an int to the function “change()” and as a result the change in the value of
 * that integer is not reflected in the main method. Like C/C++,
 * Java creates a COPY of the variable being passed in the method and then do the manipulations.
 * Hence the change is not reflected in the main method.
 */
public class JavaPassByValue {

    public static void main(String[] args)
    {
        int x = 5;
        change(x);
        System.out.println("No change in the value of X as it was passed by value : " + x);
    }
    public static void change(int x)
    {
        System.out.println("passed in value of x: " + x);
        x = 10;
    }
}
