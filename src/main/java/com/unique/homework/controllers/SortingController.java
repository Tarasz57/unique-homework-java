package com.unique.homework.controllers;

import com.unique.homework.service.SortingService;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/v1/sorted-students")
public class SortingController {

  private final SortingService sortingService;

  @Autowired
  public SortingController(SortingService sortingService) {
    this.sortingService = sortingService;
  }

  @PostMapping
  public ResponseEntity sortStudents(@RequestParam("file") MultipartFile file, @RequestParam("algorithm") String sortingAlgorithm) throws IOException {
    return new ResponseEntity(sortingService.sortTheStudents(file, sortingAlgorithm), HttpStatus.OK);
  }

}
