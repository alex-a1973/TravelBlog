package com.example.travelblog.http;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Blog {
  private final String id;
  private final Author author;
  private final String title;
  private final String date;
  private final String image;
  private final String description;
  private final int views;
  private final float rating;
}
