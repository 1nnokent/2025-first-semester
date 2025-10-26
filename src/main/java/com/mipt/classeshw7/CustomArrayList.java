package com.mipt.classeshw7;

import java.util.Iterator;


/**
 * Реализация интерфейса {@link CustomList} с использованием массива. Позволяет хранить элементы
 * произвольного типа и поддерживает динамическое расширение массива при добавлении новых
 * элементов.
 *
 * @param <A> тип элементов, хранящихся в списке
 */

public class CustomArrayList<A> implements CustomList<A>, Iterable<A> {

  /**
   * Начальная емкость внутреннего массива по умолчанию.
   */
  private static final int DEFAULT_CAPACITY = 10;

  /**
   * Коэффициент расширения массива при переполнении.
   */
  private static final float EXPANSION_COEFFICIENT = 1.5f;

  /**
   * Текущая емкость внутреннего массива.
   */
  private int capacity;

  /**
   * Количество элементов в списке.
   */
  private int size;

  /**
   * Внутренний массив для хранения элементов.
   */
  private Object[] innerList;

  /**
   * Создает пустой список с начальной емкостью {@link #DEFAULT_CAPACITY}.
   */
  public CustomArrayList() {
    innerList = new Object[DEFAULT_CAPACITY];
    size = 0;
    capacity = DEFAULT_CAPACITY;
  }

  /**
   * Добавляет элемент в конец списка.
   *
   * @param element элемент, который необходимо добавить; не может быть {@code null}
   * @throws IllegalArgumentException если элемент равен {@code null}
   */
  @Override
  public void add(A element) {
    if (element == null) {
      throw new IllegalArgumentException("Element can`t be null");
    }

    if (size == capacity) {
      capacity = (int) (capacity * EXPANSION_COEFFICIENT);
      Object[] newInnerList = new Object[capacity];
      for (int i = 0; i < size; ++i) {
        newInnerList[i] = innerList[i];
      }
      innerList = newInnerList;
    }

    innerList[size] = element;
    size++;
  }

  /**
   * Возвращает элемент по указанному индексу.
   *
   * @param index индекс элемента (начинается с 0)
   * @return элемент по указанному индексу
   * @throws IndexOutOfBoundsException если индекс меньше 0 или больше/равен {@link #size()}
   */
  @Override
  @SuppressWarnings("unchecked")
  public A get(int index) {
    return (A) innerList[index];
  }

  /**
   * Удаляет элемент по указанному индексу.
   *
   * @param index индекс элемента для удаления
   * @throws IndexOutOfBoundsException если индекс меньше 0 или больше/равен {@link #size()}
   */
  @Override
  public void remove(int index) {
    for (int i = index; i < size - 1; ++i) {
      innerList[i] = innerList[i + 1];
    }
    innerList[size - 1] = null;
    size--;
  }

  /**
   * Возвращает количество элементов в списке.
   *
   * @return размер списка
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * Проверяет, пуст ли список.
   *
   * @return {@code true}, если список не содержит элементов, иначе {@code false}
   */
  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  /**
   * Возвращает итератор для обхода элементов списка.
   *
   * @return итератор элементов типа {@link A}
   */
  @Override
  public Iterator<A> iterator() {
    return new CustomArrayListIterator<A>();
  }

  /**
   * Итератор по элементам {@link CustomArrayList}.
   *
   * @param <A> тип элементов в списке
   */
  private class CustomArrayListIterator<A> implements Iterator<A> {

    /**
     * Текущий индекс итератора.
     */
    private int index = 0;

    /**
     * Проверяет, есть ли следующий элемент для обхода.
     *
     * @return {@code true}, если следующий элемент есть, иначе {@code false}
     */
    @Override
    public boolean hasNext() {
      return index < size;
    }

    /**
     * Возвращает следующий элемент и сдвигает итератор.
     *
     * @return следующий элемент списка
     */
    @Override
    @SuppressWarnings("unchecked")
    public A next() {
      return (A) innerList[index++];
    }
  }

}
