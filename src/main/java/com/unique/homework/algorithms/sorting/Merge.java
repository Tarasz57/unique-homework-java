package com.unique.homework.algorithms.sorting;

import com.unique.homework.entities.Student;
import java.util.ArrayList;
import java.util.List;

public class Merge implements SortingMethod{

  @Override
  public void sort(List<Student> elements) {
    mergeSort(elements, 0, elements.size() - 1);
  }

  private void merge(List<Student> elements, int p, int q, int r) {

    int n1 = q - p + 1;
    int n2 = r - q;

    List<Student> left = new ArrayList();
    List<Student> right = new ArrayList();

    // fill the left and right lists
    for (int i = 0; i < n1; i++)
      left.add(elements.get(p + i));
    for (int j = 0; j < n2; j++)
      right.add(elements.get(q + 1 + j));

    // Maintain current index of sub-lists and main list
    int i, j, k;
    i = 0;
    j = 0;
    k = p;

    // Until we reach either end of either Left or Right, pick larger among
    // elements Left and Right and place them in the correct position at List[p..r]
    // for sorting in descending
    // use if(Left[i] >= <[j])
    while (i < n1 && j < n2) {
      if (left.get(i).getGrade() <= right.get(j).getGrade()) {
        elements.set(k, left.get(i));
        i++;
      } else {
        elements.set(k, right.get(j));
        j++;
      }
      k++;
    }

    // When we run out of elements in either Left or Right,
    // pick up the remaining elements and put in List[p..r]
    while (i < n1) {
      elements.set(k, left.get(i));
      i++;
      k++;
    }

    while (j < n2) {
      elements.set(k, right.get(j));
      j++;
      k++;
    }
  }

  // Divide the list into two sub lists, sort them and merge them
  private void mergeSort(List<Student> elements, int left, int right) {
    if (left < right) {

      // m is the point where the list is divided into two sub lists
      int mid = (left + right) / 2;

      // recursive call to each sub list
      mergeSort(elements, left, mid);
      mergeSort(elements, mid + 1, right);

      // Merge the sorted sub lists
      merge(elements, left, mid, right);
    }
  }

}
