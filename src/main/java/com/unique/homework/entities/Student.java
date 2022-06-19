package com.unique.homework.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {

  private String name;
  private float grade;

  private Student() {}

  public Student(String name, float grade) {
    this.name = name;
    this.grade = grade;
  }

}
