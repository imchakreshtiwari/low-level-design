package com.pattern.learndesignpattern;

public final class Singelton {

    private static Singelton singelton;
    public String value;

    private Singelton(String value) {
        this.value = value;
    }

    //Not thread safe It should be avoided in multi threaded environemnts
//    public static Singelton getInstance(String value) {
//        if (singelton == null) {
//            singelton = new Singelton(value);
//        }
//        return singelton;
//    }

    //volatile keyword is used for ensuring that changes are visible to all the threads
    private static volatile  Singelton singelton1;

    //Its lazy initialization and double checking
    public static Singelton getInstance(String value) {
        if (singelton == null) {
            synchronized (Singelton.class) {
                if (singelton == null) {
                    singelton = new Singelton(value);
                }
            }
        }
        return singelton;
    }

    //Thread safe eager intiaziation

//    public synchronized static Singleton getInstance() {
//        if (singleton == null) {
//            singleton = new Singleton();
//        }
//        return singleton;
//    }

//How DB connection pool works?


}
