package com.example.intern_task.Retrofit;

import com.example.intern_task.POJO.Videos;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface connection {
    @GET("youtube/v3/search")
    Call<Videos>getAllvideos(@Query("key") String api_key, @Query("channelId") String channel_id, @Query("part") String part, @Query("order") String order);

    @GET("youtube/v3/search")
    Call<Videos>get_next_videos(@Query("key") String api_key, @Query("channelId") String channel_id, @Query("part") String part, @Query("order") String order,@Query("pageToken") String token);



}
