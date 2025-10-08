package com.mipt.classeshw6;

public class Calculator<T extends Number> {

  public double sum(T a, T b) {
    double aValue = (a == null) ? 0 : a.doubleValue();
    double bValue = (b == null) ? 0 : b.doubleValue();
    return aValue + bValue;
  }

  public double substract(T a, T b) {
    double aValue = (a == null) ? 0 : a.doubleValue();
    double bValue = (b == null) ? 0 : b.doubleValue();
    return aValue - bValue;
  }

  public double multiply(T a, T b) {
    double aValue = (a == null) ? 0 : a.doubleValue();
    double bValue = (b == null) ? 0 : b.doubleValue();
    return aValue * bValue;
  }

  public double divide(T a, T b) {
    double aValue = (a == null) ? 0 : a.doubleValue();
    double bValue = (b == null) ? 0 : b.doubleValue();
    if (bValue == 0){
      return Double.NaN;
    }
    return aValue / bValue;
  }

  public static void main(String[] args) {
    // пример использования
    final Calculator<Integer> intCalc = new Calculator<>();
    final double result = intCalc.sum(5, 3); // 8.0
    System.out.println(result);

    final Calculator<Double> doubleCalc = new Calculator<>();
    final double div = doubleCalc.divide(10.0, 4.0); // 2.5
    System.out.println(div);
  }
}
