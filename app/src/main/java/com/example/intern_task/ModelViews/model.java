package com.example.intern_task.ModelViews;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.intern_task.POJO.Videos;
import com.example.intern_task.Retrofit.connection;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class model extends AndroidViewModel {
    public  MutableLiveData<Videos> movies_videos;;
    public  MutableLiveData<Videos> next_movies_videos;
    public model(@NonNull Application application)
    {
        super(application);

        movies_videos = new MutableLiveData<>();
        next_movies_videos = new MutableLiveData<>();
    }

    public void getData(String ch_id)
    {
        if(NetworkState.checkInternetConnection(getApplication().getApplicationContext()))
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            connection conn = retrofit.create(connection.class);
            Call<Videos> getmovies = conn.getAllvideos("AIzaSyBFdZwdrdeW2fNirSqJ919XG3aZedVW98U",ch_id,"id","date");
            getmovies.enqueue(new Callback<Videos>() {
                @Override
                public void onResponse(@NotNull Call<Videos> call, @NotNull Response<Videos> response) {
                    Videos moviemodel = response.body();
                    movies_videos.setValue(moviemodel);
                    Log.i("res", "onFailure: " +moviemodel.getItems().get(0).getId().getVideoId());
                //    Toast.makeText(getApplication().getApplicationContext(), moviemodel.getItems().get(0).getId().getVideoId(), Toast.LENGTH_SHORT).show();

                }
                @Override
                public void onFailure(Call<Videos> call, Throwable t) {
                    Log.i("asd", "onFailure: " + t.getMessage());
                    Toast.makeText(getApplication().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });
        }
        else
        {
           // movies_videos.setValue(null);
            Log.i(TAG, "getData:Network error!!!!! ");
            Toast.makeText(getApplication().getApplicationContext(), "Netwok Error!!", Toast.LENGTH_SHORT).show();
        }

    }

    public void get_next_Data(String ch_id,String token)
    {
        if(NetworkState.checkInternetConnection(getApplication().getApplicationContext()))
        {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://www.googleapis.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            connection conn = retrofit.create(connection.class);
            Call<Videos> getmovies = conn.get_next_videos("AIzaSyBFdZwdrdeW2fNirSqJ919XG3aZedVW98U",ch_id,"id","date",token);
            getmovies.enqueue(new Callback<Videos>() {
                @Override
                public void onResponse(@NotNull Call<Videos> call, @NotNull Response<Videos> response) {
                    Videos moviemodel = response.body();
                    next_movies_videos.setValue(moviemodel);
                    Log.i("res", "onFailure: " +response.body().getItems().get(0).getId().getVideoId());

                }
                @Override
                public void onFailure(Call<Videos> call, Throwable t) {
                    Log.i("asd", "onFailure: " + t.getMessage());
                    Toast.makeText(getApplication().getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//                    movies_videos.setValue(null);
                }
            });
        }
        else
        {
            // movies_videos.setValue(null);
            Log.i(TAG, "getData:Network error!!!!! ");
            Toast.makeText(getApplication().getApplicationContext(), "Netwok Error!!", Toast.LENGTH_SHORT).show();
        }

    }

}
