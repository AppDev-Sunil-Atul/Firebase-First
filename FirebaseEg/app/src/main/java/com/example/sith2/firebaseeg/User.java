package com.example.sith2.firebaseeg;

/**
 * Created by Sith2 on 28-Jan-18.
 */

public class User {
    String name;
    String age;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public User() {
    }

    public User(String name) {

        this.name = name;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
