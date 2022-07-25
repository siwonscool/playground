package com.example.playground.singleton;

import java.util.concurrent.ConcurrentHashMap;

public class SingletonDCL {
    private static volatile SingletonDCL instance;

    private SingletonDCL(){}

    public static SingletonDCL getInstance(){
        if (instance == null){
            synchronized (SingletonDCL.class){
                if (instance == null)
                    instance = new SingletonDCL();
            }
        }
        return instance;
    }

}
