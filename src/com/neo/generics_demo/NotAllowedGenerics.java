package com.neo.generics_demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Let's see some tasks which are not allowed to do in java generics.
 */
public class NotAllowedGenerics<T> {

    /**
     * A) You can’t have static field of type:
     * You can not define a static generic parameterized member in your class.
     * Any attempt to do so will generate compile time error: Cannot make a static reference to the non-static type T.
     */
    public static T variable;

    /**
     * B) You cannot create instance of Type T:
     * Any attempt to create an instance of T will fail with error: Cannot instantiate the type T.
     */
    public NotAllowedGenerics() {
       // new T();
    }

    /**
     * C) Generics are not compatible with primitives in declarations:
     * Yes, it’s true. You can’t declare generic expression like List or Map<String, double>.
     * Definitely you can use the wrapper classes in place of primitives and then use primitives when passing the actual values.
     * These value primitives are accepted by using auto-boxing to convert primitives to respective wrapper classes.
     */
    //final List<int> ids = new ArrayList<>();    //Not allowed

    final List<Integer> ids1 = new ArrayList<>(); //Allowed

    /**
     * You can’t create Generic exception class:
     * When you try to create such an exception,
     * you will end up with message like this: The generic class GenericException may not subclass java.lang.Throwable.
     */
    //public class GenericException<T> extends Exception {}
}
