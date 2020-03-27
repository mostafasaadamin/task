package com.example.intern_task;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Alnhar(View view) {
        redirect("UCtpL6HyBK-z16GbJguHf3JQ");
    }

    public void Alsout(View view) {
        redirect("UChzJgvm9Mx7qQ6eh6j3Zuag");
    }


    public void kabreat(View view) {
        redirect("UC-4KnPMmZzwAzW7SbVATUZQ");
    }

    public void bander(View view) {
        redirect("UCxEGVXh6fi-XYo58NZrbIHQ");

    }

    public void Ashoyat(View view) {
        redirect("UCe1m3ZH68Q8314yqulWHTcw");
    }

    public void mehwar(View view) {
        redirect("UCYoo3rvwB24q9_kRCgR897Q");
    }

public void redirect(String id)
{
    Intent i=new Intent(MainActivity.this,videoList.class);
    i.putExtra("ID",id);
    startActivity(i);
}

}
