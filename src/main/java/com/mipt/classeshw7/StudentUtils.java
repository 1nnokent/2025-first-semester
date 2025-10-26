package com.mipt.classeshw7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class StudentUtils {

  ArrayList<Student> findStudentsByGradeRange(Map<Integer, Student> map, double minGrade,
      double maxGrade) {
    ArrayList<Student> returner = new ArrayList<>();
    for (Student st : map.values()) {
      if (st.getGrade() >= minGrade && st.getGrade() <= maxGrade) {
        returner.add(st);
      }
    }
    return returner;
  }

  Student[] getTopNStudents(TreeMap<Integer, Student> map, int n) {
    Student[] returner = new Student[n];
    int counter = 0;
    for (Student st : map.values()) {
      if (counter == n) {
        break;
      }
      returner[counter] = st;
      counter++;
    }
    return returner;
  }

  public static void main(String[] args) {
    HashMap<Integer, Student> hashMap = new HashMap<>();
    TreeMap<Integer, Student> treeMap = new TreeMap<>();
  }
}
