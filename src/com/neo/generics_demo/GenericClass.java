package com.neo.generics_demo;

/**
 * GenericClass is parameterized class,
 * which illustrates an example of GenericClasses
 * T stands for Type in Generics
 * @param <T> the class of the Objects
 */
public class GenericClass<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
