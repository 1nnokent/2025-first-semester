package com.mipt.classeshw6;

public class ArrayUtils {

  public static <T> int findFirst(T[] array, T element) {
    if (array == null) {
      return -1;
    }
    int size = array.length;
    for (int i = 0; i < size; ++i) {
      if (array[i].equals(element)) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    // пример использования
    final String[] names = {"Alice", "Bob", "Charlie"};
    final int index = ArrayUtils.findFirst(names, "Bob");
    // Ожидаем: 1 (тк нумерация в массиве начинается с нуля)
    System.out.println(index);
  }
}
