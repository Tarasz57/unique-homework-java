package com.unique.homework.algorithms.sorting;

import com.unique.homework.entities.Student;
import java.util.Collections;
import java.util.List;

public class Heap implements SortingMethod{

  @Override
  public void sort(List<Student> elements) {
    int size = elements.size();

    for (int i = size / 2 - 1; i >= 0; i--) {
      heapify(elements, size, i);
    }

    for (int i = size - 1; i >= 0; i--) {

      Collections.swap(elements, 0, i);

      heapify(elements, i, 0);
    }
  }


    private void heapify(List<Student> elements, int size, int i) {
      int largest = i;
      int leaf = 2 * i + 1;
      int root = 2 * i + 2;

      if (leaf < size && elements.get(leaf).getGrade() > elements.get(largest).getGrade())
        largest = leaf;

      if (root < size && elements.get(root).getGrade() > elements.get(largest).getGrade())
        largest = root;

      if (largest != i) {

        Collections.swap(elements, i, largest);

        heapify(elements, size, largest);
      }
    }
  }
