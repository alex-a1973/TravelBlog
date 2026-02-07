package com.example.travelblog.http;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Author {
  private final String name;
  private final String avatar;
}
