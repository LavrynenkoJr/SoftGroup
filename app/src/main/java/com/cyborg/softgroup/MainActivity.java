package com.cyborg.softgroup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*Creating a collection of SUBJECTS*/
        Init init = new Init();
        init.initial();

    }
    public void listeningAct(View view){ startActivity(new Intent(this, ListeningActivity.class)); }

    public void testAct(View view){ startActivity(new Intent(this, TestActivity.class)); }
}
