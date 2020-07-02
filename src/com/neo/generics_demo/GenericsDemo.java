package com.neo.generics_demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericsDemo {

    public static void main(String[] args) {
        /**
         * Generics Type class or interface:
         * A class is generic if it declares one or more type variables.
         * These type variables are known as the type parameters of the class.
         * Generic Class Example:
         */
	    GenericClass<String> genericClass = new GenericClass<>();
	    genericClass.setT("Alex");
	    //stringGenericsClass.setT(1); -> This will raise a compile time error.
        System.out.println("Generic-Class Output: "+genericClass.getT());

        /**
         * Generic interface Example:
         */
        GenericInterface<String, Integer> genericInterface = new OrderedPair<>("Alex", 50);
        GenericInterface<String, Long> genericInterface1 = new OrderedPair<>("Domnic", 100L);
        System.out.println("Generic-Interface-Example:1 Output: \n " +
                "Generic class: "+genericInterface.getClass()+" -> " +
                "genericInterface-Key: "+genericInterface.getKey()+ ": " +
                "genericInterface-Value: "+genericInterface.getValue());
        System.out.println("Generic-Interface-Example:2 Output: \n " +
                "Generic class: "+genericInterface1.getClass()+" -> " +
                "genericInterface1-Key: "+genericInterface1.getKey()+ ": " +
                "genericInterface1-Value: "+genericInterface1.getValue());

        /**
         * Generic Methods Example:
         * Generic methods are much similar to generic classes.
         * They are different only in one aspect that scope of type information is inside method (or constructor) only.
         * Generic methods are methods that introduce their own type parameters.
         */
        OrderedPair<Integer, String> p1 = new OrderedPair<>(1, "apple");
        OrderedPair<Integer, String> p2 = new OrderedPair<>(2, "pear");
        OrderedPair<Integer, String> p3 = new OrderedPair<>(1, "apple");
        System.out.println("Generic Method Output: Ordered Pair objects (p1, p2) are "+ (compare(p1, p2) ? "equal/similar." : "not equal."));
        System.out.println("Generic Method Output: Ordered Pair objects (p1, p3) are "+ (compare(p1, p3) ? "equal/similar." : "not equal."));

        /**
         * Generic Constructor Example:
         */
        Dimension<Integer> dimension = new Dimension<>(20, 30, 40);
        Dimension<Double> dimension1 = new Dimension<>(20.4, 30.6, 40.8);

        /**
         * Generic Type Wildcards:
         * Unbounded Wildcards
         */
        List<Integer> integerList = Arrays.asList(1, 2, 3);
        List<String>  stringList = Arrays.asList("one", "two", "three");
        printList(integerList);
        printList(stringList);

        /**
         * Upper Bounded Wildcards
         */
        List<Integer> li = Arrays.asList(1, 2, 3);
        System.out.println("sum = " + sumOfList(li)); // returns 6.0

        List<Double> ld = Arrays.asList(1.2, 2.3, 3.5);
        System.out.println("sum = " + sumOfList(ld)); // returns 7.0

        /**
         * Generic Type Wildcards:
         * Lower Bounded Wildcards
         */
        //List of grand children
        List<GrandChildClass> grandChildren = new ArrayList<>();
        GrandChildClass grandChildClass1 = new GrandChildClass();
        grandChildClass1.setGrandChildClass("Daniel");
        grandChildren.add(grandChildClass1);
        printGrandChildren(grandChildren);

        //List of grand childs
        List<ChildClass> childs = new ArrayList<>();
        GrandChildClass grandChildClass2 = new GrandChildClass();
        grandChildClass2.setGrandChildClass("Domnic");
        childs.add(grandChildClass2);
        printGrandChildren(childs);

        //List of grand supers
        List<SuperClass> supers = new ArrayList<>();
        GrandChildClass grandChildClass3 = new GrandChildClass();
        grandChildClass3.setGrandChildClass("Alex");
        supers.add(grandChildClass3);
        printGrandChildren(supers);

    }

    /**
     * Generic Method:
     * Comparison between two OrderedPair Objects
     * @param p1 OrderedPair object 1
     * @param p2 OrderedPair object 2
     * @param <K> the class of the Objects
     * @param <V> the class of the Objects
     * @return boolean value true if they are equal or else false.
     */
    public static <K, V> boolean compare(OrderedPair<K, V> p1, OrderedPair<K, V> p2) {
        return p1.getKey().equals(p2.getKey()) &&
                p1.getValue().equals(p2.getValue());
    }

    /**
     * Unbounded Wildcard:
     * The unbounded wildcard type is specified using the wildcard character (?),
     * for example, List<?>. This is called a list of unknown type.
     * There are two scenarios where an unbounded wildcard is a useful approach:
     * If you are writing a method that can be implemented using functionality provided in the Object class.
     * When the code is using methods in the generic class that don't depend on the type parameter.
     * For example, List.size or List.clear.
     * In fact, Class<?> is so often used because most of the methods in Class<T> do not depend on T.
     * @param list of unknown type
     */
    public static void printList(List<?> list) {
        for (Object elem : list)
            System.out.println("Unbounded Wildcards: Example: "+ elem.getClass().getName() + " : "+ elem);
        System.out.println();
    }

    /**
     * Upper Bounded Wildcard:
     * You can use an upper bounded wildcard to relax the restrictions on a variable.
     * For example, say you want to write a method that works on List<Integer>, List<Double>, and List<Number>;
     * you can achieve this by using an upper bounded wildcard.
     * To declare an upper-bounded wildcard, use the wildcard character ('?'), followed by the extends keyword,
     * followed by its upper bound.
     * Note that, in this context, extends is used in a general sense to mean either "extends" (as in classes)
     * or "implements" (as in interfaces).
     * @param list of unknown type which extends Number class
     * @return double value after summation of values in the list
     */
    public static double sumOfList(List<? extends Number> list) {
        double s = 0.0;
        for (Number n : list)
            s += n.doubleValue();
        return s;
    }

    /**
     * Lower Bounded Wildcards:
     * A lower bounded wildcard restricts the unknown type to be a specific type or a super type of that type.
     * A lower bounded wildcard is expressed using the wildcard character ('?'), following by the super keyword,
     * followed by its lower bound: <? super A>.
     * @param grandChildren of unknown type it accepts a specific type or a super type of that type.
     */
    public static void printGrandChildren(List<? super GrandChildClass> grandChildren) {
        grandChildren.forEach(System.out::println);
    }

}

class SuperClass{
   public String superClassName;

    public void setSuperClassName(String superClassName) {
        this.superClassName = superClassName;
    }
}
class ChildClass extends SuperClass{
    public String childClassName;

    public void setChildClassName(String childClassName) {
        this.childClassName = childClassName;
    }
}
class GrandChildClass extends ChildClass{
    public String grandChildClass;

    public void setGrandChildClass(String grandChildClass) {
        this.grandChildClass = grandChildClass;
    }

    @Override
    public String toString() {
        return "GrandChildClass{" +
                "grandChildClass='" + grandChildClass + '\'' +
                '}';
    }
}


