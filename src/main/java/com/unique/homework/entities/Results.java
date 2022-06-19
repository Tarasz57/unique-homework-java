package com.unique.homework.entities;

import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
@Setter
public class Results {

  private List<Student> sortedStudents;
  private long sortingTime;
  private long parsingTime;
  private int entriesProcessed;

}
