package com.example.intern_task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.intern_task.Adapters.MovieAdapters;
import com.example.intern_task.ModelViews.model;
import com.example.intern_task.POJO.Item;
import com.example.intern_task.POJO.Videos;

import java.util.ArrayList;

public class videoList extends AppCompatActivity {
    RecyclerView Movie_Recycler;
    ProgressBar progressBar;
    boolean isLoading = false;
    model itemViewModel;
    MovieAdapters adapters;
    String id = "",token="";
       ArrayList<Item> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        Movie_Recycler = findViewById(R.id.list);
       data=new ArrayList<>();
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        id = getIntent().getExtras().getString("ID");
        itemViewModel = new ViewModelProvider(this).get(model.class);
        Movie_Recycler.setLayoutManager(new LinearLayoutManager(this));
        Movie_Recycler.setHasFixedSize(true);
        itemViewModel.getData(id);
        itemViewModel.movies_videos.observe(this, new Observer<Videos>() {
            @Override
            public void onChanged(Videos videos) {
                assert videos != null;
                if (videos.getItems().size() > 0) {
                    data.addAll(videos.getItems());
                    adapters = new MovieAdapters(data, videoList.this);
                    Movie_Recycler.setAdapter(adapters);
                    token=videos.getNextPageToken();

                } else {
                    Toast.makeText(videoList.this, "no  Items", Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.GONE);
            }
        });
        initScrollListener();
    }
    private void initScrollListener() {
        Movie_Recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull final RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (!recyclerView.canScrollVertically(1) && newState==RecyclerView.SCROLL_STATE_IDLE) {
                    progressBar.setVisibility(View.VISIBLE);

                        itemViewModel.get_next_Data(id, token);
                        itemViewModel.next_movies_videos.observe(videoList.this, new Observer<Videos>() {
                            @Override
                            public void onChanged(Videos videos) {
                                assert videos != null;
                                if (videos.getItems().size() > 0) {
                                    progressBar.setVisibility(View.GONE);
                                    data.addAll(data.size() - 1, videos.getItems());
                                    isLoading=false;
                                    token = videos.getNextPageToken();
                                    adapters.notifyItemRangeInserted(data.size() - 1, videos.getItems().size());
                                    Toast.makeText(videoList.this, "token" + token, Toast.LENGTH_SHORT).show();
                                    Log.i("tok", "onChanged: " + token);
                                } else {
                                    Toast.makeText(videoList.this, "no more items Error happened!!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);


            }
        });
    }
}
