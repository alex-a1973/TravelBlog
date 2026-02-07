package com.example.travelblog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.example.travelblog.http.Blog;
import com.example.travelblog.http.BlogArticlesCallback;
import com.example.travelblog.http.BlogHttpClient;
import java.util.List;

public class BlogDetailsActivity extends AppCompatActivity {

  private TextView textTitle;
  private TextView textDate;
  private TextView textAuthor;
  private TextView textRating;
  private TextView textDescription;
  private TextView textViews;
  private RatingBar ratingBar;
  private ImageView imageAvatar;
  private ImageView imageMain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_blog_details);

    ImageView imageBack = findViewById(R.id.imageBack);
    imageBack.setOnClickListener(v -> finish());

    imageMain = findViewById(R.id.imageMain);
    imageAvatar = findViewById(R.id.imageAvatar);

    textTitle = findViewById(R.id.textTitle);
    textDate = findViewById(R.id.textDate);
    textAuthor = findViewById(R.id.textAuthor);
    textRating = findViewById(R.id.textRating);
    textViews = findViewById(R.id.textViews);
    textDescription = findViewById(R.id.textDescription);
    ratingBar = findViewById(R.id.ratingBar);

    // Start data loading
    loadData();
  }

  private void loadData() {
    BlogHttpClient.INSTANCE.loadBlogArticles(
        new BlogArticlesCallback() {
          @Override
          public void onSuccess(List<Blog> blogList) {
            runOnUiThread(() -> showData(blogList.get(0)));
          }

          @Override
          public void onError() {}
        });
  }

  private void showData(Blog blog) {
    textTitle.setText(blog.getTitle());
    textDate.setText(blog.getDate());
    textAuthor.setText(blog.getAuthor().getName());
    textRating.setText(String.valueOf(blog.getRating()));
    textViews.setText(String.format("(%d views)", blog.getViews()));
    textDescription.setText(blog.getDescription());
    ratingBar.setRating(blog.getRating());

    Glide.with(this)
        .load(blog.getImage())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageMain);
    Glide.with(this)
        .load(blog.getAuthor().getAvatar())
        .transition(DrawableTransitionOptions.withCrossFade())
        .into(imageAvatar);
  }
}
