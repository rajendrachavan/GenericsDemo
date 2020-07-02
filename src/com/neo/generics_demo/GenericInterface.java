package com.neo.generics_demo;

/**
 * Generic interface definition
 * @param <K> the class of the Objects
 * @param <V> the class of the Objects
 */
public interface GenericInterface<K, V> {

    public void setKey(K key);
    public K getKey();
    public void setValue(V value);
    public V getValue();
}

