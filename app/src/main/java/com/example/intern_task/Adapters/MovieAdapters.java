package com.example.intern_task.Adapters;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.intern_task.POJO.Item;
import com.example.intern_task.POJO.Videos;
import com.example.intern_task.R;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeStandalonePlayer;
import com.google.android.youtube.player.YouTubeThumbnailLoader;
import com.google.android.youtube.player.YouTubeThumbnailView;

import java.util.ArrayList;

public class MovieAdapters extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<Item> MovList;
    Context context;
    private final int VIEW_TYPE_ITEM = 0;
    private final int VIEW_TYPE_LOADING = 1;

    public MovieAdapters(ArrayList<Item> MovList, Context context) {
        this.MovList = MovList;
        this.context = context;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == VIEW_TYPE_ITEM) {
            View form = LayoutInflater.from(context).inflate(R.layout.video, parent, false);
            videoHolder sesstion = new videoHolder(form);
            return sesstion;
        }else
            {
                View form = LayoutInflater.from(context).inflate(R.layout.progress, parent, false);
                progressholder sesstion = new progressholder(form);
                return sesstion;

            }
    }

    @Override
    public int getItemViewType(int position) {

    return MovList.get(position).getId().getVideoId()==null?VIEW_TYPE_LOADING:VIEW_TYPE_ITEM;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
          final ArrayList<Item> videos=MovList;
          if(holder instanceof videoHolder) {
              final YouTubeThumbnailLoader.OnThumbnailLoadedListener onThumbnailLoadedListener = new YouTubeThumbnailLoader.OnThumbnailLoadedListener() {
                  @Override
                  public void onThumbnailError(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader.ErrorReason errorReason) {

                  }

                  @Override
                  public void onThumbnailLoaded(YouTubeThumbnailView youTubeThumbnailView, String s) {
                      youTubeThumbnailView.setVisibility(View.VISIBLE);
                  }
              };

             ((videoHolder) holder).youTubeThumbnailView.initialize("AIzaSyBFdZwdrdeW2fNirSqJ919XG3aZedVW98U", new YouTubeThumbnailView.OnInitializedListener() {
                  @Override
                  public void onInitializationSuccess(YouTubeThumbnailView youTubeThumbnailView, YouTubeThumbnailLoader youTubeThumbnailLoader) {

                      String item = videos.get(position).getId().getVideoId();
                      youTubeThumbnailLoader.setVideo(item);
                      youTubeThumbnailLoader.setOnThumbnailLoadedListener(onThumbnailLoadedListener);
                  }

                  @Override
                  public void onInitializationFailure(YouTubeThumbnailView youTubeThumbnailView, YouTubeInitializationResult youTubeInitializationResult) {
                      //write something for failure
                  }
              });
              ((videoHolder) holder).card.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View view) {
                      String item = videos.get(position).getId().getVideoId();
                      Intent intent = YouTubeStandalonePlayer.createVideoIntent((Activity) context, "AIzaSyBFdZwdrdeW2fNirSqJ919XG3aZedVW98U", item);
                      context.startActivity(intent);
                  }
              });
          }else
              {
                  ((progressholder) holder).progressBar.setVisibility(View.VISIBLE);
              }
    }
    @Override
    public int getItemCount() {
        return MovList.size();
    }

}