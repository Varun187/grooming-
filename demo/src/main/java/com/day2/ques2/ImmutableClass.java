package com.day2.ques2;

public final class ImmutableClass {
    public final int age;
    public final String name;

    public ImmutableClass(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "ImmumatableClass [age=" + age + ", name=" + name + "]";
    }

}
