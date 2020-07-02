package com.neo.generics_demo;

import java.util.Collections.*;
/**
 * OrderedPair class is a illustration of Multiple Type Parameters
 * @param <K> the class of the Objects
 * @param <V> the class of the Objects
 */
public class OrderedPair<K, V> implements GenericInterface<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void setKey(K key) { this.key = key; }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public void setValue(V value) { this.value = value; }

    @Override
    public V getValue() {
        return value;
    }
}
