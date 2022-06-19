package com.unique.homework.algorithms.sorting;

import com.unique.homework.entities.Student;
import java.util.Collections;
import java.util.List;

public class Bubble implements SortingMethod{

  @Override
  public void sort(List<Student> elements) {
    int size = elements.size();

    for (int i = 0; i < size - 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (elements.get(j).getGrade() > elements.get(j + 1).getGrade()) {
          Collections.swap(elements, j, j + 1);
        }
      }
    }
  }
}
