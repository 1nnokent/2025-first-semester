package com.mipt.classeshw7;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CollectionPerformanceTester {

  private static final int OPERATION_AMOUNT = 10_000;

  ArrayList<Integer> arrayList;
  LinkedList<Integer> linkedList;

  @BeforeAll
  static void printTable() {
    System.out.printf("%-30s %-20s %-20s%n", "Операция", "ArrayList", "LinkedList");
    System.out.println("------------------------------------------------------------------");
  }

  @BeforeEach
  void setup() {
    arrayList = new ArrayList<>();
    linkedList = new LinkedList<>();
  }

  @Test
  public void addToEndTest() {
    double arrayListTime = addToEndTime(arrayList);
    double linkedListTime = addToEndTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Добавление в конец", arrayListTime,
        linkedListTime);
  }

  @Test
  public void addToBeginningTest() {
    double arrayListTime = addToBeginningTime(arrayList);
    double linkedListTime = addToBeginningTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Добавление в начало", arrayListTime,
        linkedListTime);
  }

  @Test
  public void addToCenterTest() {
    double arrayListTime = addToCenterTime(arrayList);
    double linkedListTime = addToCenterTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Добавление в середину", arrayListTime,
        linkedListTime);
  }

  @Test
  public void getTest() {
    double arrayListTime = getTime(arrayList);
    double linkedListTime = getTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Доступ по индексу", arrayListTime,
        linkedListTime);
  }

  @Test
  public void removeBeginningTest() {
    double arrayListTime = removeBeginningTime(arrayList);
    double linkedListTime = removeBeginningTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Удаление из начала", arrayListTime,
        linkedListTime);
  }

  @Test
  public void removeEndTest() {
    double arrayListTime = removeEndTime(arrayList);
    double linkedListTime = removeEndTime(linkedList);
    System.out.printf("%-30s %-20.3f %-20.3f%n", "Удаление из конца", arrayListTime,
        linkedListTime);
  }

  private <L extends List<Integer>> double addToEndTime(L list) {
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(i);
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }

  private <L extends List<Integer>> double addToBeginningTime(L list) {
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.addFirst(i);
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }

  private <L extends List<Integer>> double addToCenterTime(L list) {
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(i);
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(list.size() / 2, i);
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }

  private <L extends List<Integer>> double getTime(L list) {
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(i);
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.get(i);
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }

  private <L extends List<Integer>> double removeBeginningTime(L list) {
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(i);
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.removeFirst();
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }

  private <L extends List<Integer>> double removeEndTime(L list) {
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.add(i);
    }
    long startTime = System.nanoTime();
    for (int i = 0; i < OPERATION_AMOUNT; ++i) {
      list.removeLast();
    }
    return (System.nanoTime() - startTime) / 1_000_000.0;
  }
}
