package com.mipt.classeshw7;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

public class CustomArrayListTester {

  CustomArrayList<Integer> list;
  Random rand = new Random();

  @BeforeEach
  void setup() {
    list = new CustomArrayList<>();
  }

  @Test
  public void addTest() {
    for (int i = 0; i < 100; ++i) {
      list.add(i);
    }
  }

  @Test
  public void getTest() {
    for (int i = 0; i < 100; ++i) {
      list.add(i);
    }
    for (int i = 0; i < 100; ++i) {
      assertEquals(list.get(i), (Integer) i);
    }
  }

  @Test
  public void removeTest() {
    for (int i = 0; i < 100; ++i) {
      list.add(i);
    }
    for (int i = 100; i > 0; --i) {
      list.remove(rand.nextInt(i));
      for (Integer elem : list) {
        assertNotNull(elem);
      }
    }
  }

  @Test
  public void sizeTest() {
    for (int i = 0; i < 100; ++i) {
      list.add(i);
      assertEquals(list.size(), i + 1);
    }
  }

  @Test
  public void isEmptyTest() {
    for (int i = 0; i < 100; ++i) {
      assertTrue(list.isEmpty());
      list.add(i);
      assertFalse(list.isEmpty());
      list.remove(0);
    }
  }
}
