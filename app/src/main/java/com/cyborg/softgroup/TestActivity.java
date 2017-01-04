package com.cyborg.softgroup;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TestActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private MediaPlayer mediaPlayer;
    private Random random = new Random();
    private LinearLayoutManager mLayoutManager;
    private Dialog dialog;
    private TextView mTextView;
    private ImageView mImageView;
    private Button mButton;

    private int count = 0; // the number of correct answers

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        recyclerView = (RecyclerView) findViewById(R.id.test_recycler_view);
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_view);
        mTextView = (TextView) dialog.findViewById(R.id.dialogText);
        mImageView = (ImageView) dialog.findViewById(R.id.dialog_image);
        mButton = (Button) dialog.findViewById(R.id.button);

        counter();
    }

    public void counter(){
        if (count <= 3)
            work(2);
        else if (count > 3 && count <= 10)
            work(3);
        else if (count > 10 && count <= 15)
            work(4);
        else if (count > 15 && count <= 20)
            work(5);
        else if (count > 20 && count <= 25)
            work(6);
        else if (count == 26) {
            dialog.setTitle("Перемога!");
            mTextView.setText("Ви пройшли Вікторину!");
            dialog.show();
            dialogBackButton();
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                    startActivity(new Intent(TestActivity.this, MainActivity.class));
                }
            });
        }
    }

    /* Creating list with variants of answers and transferring it to recyclerAdapter */
    public void work(int n){                        // int n - number of answers
        int answerInt = random.nextInt(n);

        List <Subject> list = new ArrayList<>();
        list.addAll(Init.mAnimals);

        List<Subject> variants = new ArrayList<>();

        for (int i = 0; i < n; i++){
            Subject subject = list.get(random.nextInt(list.size()));
            variants.add(subject);
            list.remove(subject);
        }

        final Subject answer = variants.get(answerInt);
        mediaPlayer = MediaPlayer.create(this, answer.getSoundList().get(random.nextInt(answer.getSoundList().size())));
        mediaPlayer.start();

        recyclerAdapter = new RecyclerAdapter(this, variants, new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Subject subject = (Subject) view.getTag();
                if (subject.equals(answer)) {
                    count++;
                    counter();
                } else {
                    dialog.setTitle("Помилка!");
                    mTextView.setText("Правильна відповідь: ");
                    mImageView.setImageResource(answer.getImage());
                    dialog.show();
                    dialogBackButton();

                    count = 0;
                    mButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            dialog.dismiss();
                            counter();
                        }
                    });
                }
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void dialogBackButton(){
        dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
        {
            @Override
            public void onCancel(DialogInterface dialog)
            {
                TestActivity.this.finish();
            }
        });
    }
}
