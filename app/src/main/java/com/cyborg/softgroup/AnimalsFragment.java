package com.cyborg.softgroup;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Random;


public class AnimalsFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerAdapter recyclerAdapter;
    private MediaPlayer mediaPlayer;

    private Random random = new Random();

    private LinearLayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_animals,
                container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);


        recyclerAdapter = new RecyclerAdapter(getActivity(), Init.mAnimals, new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Subject subject = (Subject) view.getTag();
                int r = random.nextInt(subject.getSoundList().size());
                mediaPlayer = MediaPlayer.create(getActivity(), subject.getSoundList().get(r));
                mediaPlayer.start();
            }
        });

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);


        return rootView;
    }
}