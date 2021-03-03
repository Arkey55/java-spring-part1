package ru.romankuznetsov.singleton;

public class SingletonExample {
    private static SingletonExample singletonExample;
    private static Integer value = 5;

    public static Integer getValue() {
        return value;
    }

    private SingletonExample() {
    }

    public static SingletonExample getInstance(){
        if (singletonExample == null){
            singletonExample = new SingletonExample();
        }
        value++;
        return singletonExample;
    }

}
