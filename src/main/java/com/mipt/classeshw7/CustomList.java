package com.mipt.classeshw6;

public class CollectionUtils {

  public static interface CustomList<A> {

    public void add (A element) {};

    public A get (int index) {};

    public void remove (A element) {};

    public int size () {};

    public boolean isEmpty () {};
  }

  

  public static void main(String[] args) {
    final List<Integer> list1 = Arrays.asList(1, 2, 3);
    final List<Double> list2 = Arrays.asList(4.5, 5.6);
    final List<Number> merged = CollectionUtils.mergeLists(list1, list2);

    final List<Object> destination = new ArrayList<>();
    CollectionUtils.addAll(destination, list1);
  }
}
