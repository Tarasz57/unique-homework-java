package com.unique.homework.algorithms.sorting;

import java.util.List;

public class Sort {

  private SortingMethod sortingMethod;

  private Sort() {}

  public Sort(String algo) {
    switch (algo){
      case "heap":
        this.sortingMethod = new Heap();
        break;
      case "merge":
        this.sortingMethod = new Merge();
        break;
      case "bubble":
        this.sortingMethod = new Bubble();
        break;
    }
  }

  public void sort(List elements) {
    sortingMethod.sort(elements);
  }

}
