package ru.amtrend.mvvmretrofitdemo.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import ru.amtrend.mvvmretrofitdemo.R;
import ru.amtrend.mvvmretrofitdemo.model.Result;

public class MovieDetailsActivity extends AppCompatActivity {

    private Result result;
    private ImageView posterImageView;
    private String posterPath;
    private TextView titleTextView;
    private TextView voteCountTextView;
    private TextView overviewTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        posterImageView = findViewById(R.id.posterimageView);
        titleTextView = findViewById(R.id.titleTextView);
        voteCountTextView = findViewById(R.id.voteCountTextView);
        overviewTextView = findViewById(R.id.overviewTextView);

        Intent intent = getIntent();

        if (intent != null && intent.hasExtra("movieData")) {

            result = intent.getParcelableExtra("movieData");

            Toast.makeText(this, result.getOriginalTitle(), Toast.LENGTH_LONG).show();

            posterPath = result.getPosterPath();
            String imagePath = "https://image.tmdb.org/t/p/w500/" + posterPath;

            Glide.with(this).load(imagePath).placeholder(R.drawable.progress_circle).into(posterImageView);

            titleTextView.setText(result.getOriginalTitle());
            voteCountTextView.setText(Integer.toString(result.getVoteCount()));
            overviewTextView.setText(result.getOverview());

        }
    }
}