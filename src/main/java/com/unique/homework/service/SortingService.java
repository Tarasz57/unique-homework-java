package com.unique.homework.service;

import com.unique.homework.algorithms.sorting.Sort;
import com.unique.homework.entities.Results;
import com.unique.homework.entities.Student;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class SortingService {

  public Results sortTheStudents(MultipartFile file, String sortingAlgorithm) throws IOException {

    long startTime = System.nanoTime();
    List<Student> students = parseFile(file);
    long endTime = System.nanoTime();
    long parsingTime = (endTime - startTime);

    Sort sort = new Sort(sortingAlgorithm);

    startTime = System.nanoTime();
    sort.sort(students);
    endTime = System.nanoTime();
    long sortingTime = (endTime - startTime);

    Results results = new Results(students, sortingTime, parsingTime, students.size());
    return results;
  }

  private List<Student> parseFile(MultipartFile file) throws IOException {
    InputStream inputStream = file.getInputStream();
    List<Student> students = new ArrayList<>();
    final List<String[]> fileContents = new ArrayList<>();

    new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))
        .lines()
        .forEach((line) -> {
          fileContents.add(line.split(","));
        } );

    for (String[] studentInfo : fileContents) {
      students.add(createStudent(studentInfo));
    }

    return students;
  }

  private Student createStudent(String[] studentInfo) {
    return new Student(studentInfo[0], Float.valueOf(studentInfo[1]));
  }

}
