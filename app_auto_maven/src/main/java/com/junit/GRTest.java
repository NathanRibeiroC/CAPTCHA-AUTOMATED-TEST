package com.junit;

public class GRTest extends Thread{
    public void run() {
        for (int i=0;i<3;i++){
            System.out.println("Thread: " + i);
        }
    }
}
