package com.example.travelblog.http;

import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BlogData {
  private final List<Blog> data;
}
