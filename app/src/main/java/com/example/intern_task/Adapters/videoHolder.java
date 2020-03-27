package com.example.intern_task.Adapters;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;


import com.example.intern_task.R;
import com.google.android.youtube.player.YouTubeThumbnailView;

import io.reactivex.annotations.NonNull;

public class videoHolder extends RecyclerView.ViewHolder  {
    public RelativeLayout relativeLayoutOverYouTubeThumbnailView;
   public YouTubeThumbnailView youTubeThumbnailView;
    public CardView card;
    public videoHolder(View itemView) {
        super(itemView);
        relativeLayoutOverYouTubeThumbnailView =itemView.findViewById(R.id.relativeLayout_over_youtube_thumbnail);
        youTubeThumbnailView =itemView.findViewById(R.id.youtube_thumbnail);

card=itemView.findViewById(R.id.card);
}

}