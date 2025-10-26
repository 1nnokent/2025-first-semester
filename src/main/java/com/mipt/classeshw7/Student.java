package com.mipt.classeshw7;

import java.util.Objects;

public class Student {

  private int id;
  private String name;
  private double grade;

  public Student(int id, String name, double grade) {
    this.id = id;
    this.name = name;
    this.grade = grade;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getGrade() {
    return grade;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
      return false;
    }
    Student other = (Student) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!this.name.equals(other.name)) {
      return false;
    }
    return this.grade != other.grade;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, grade);
  }

}
