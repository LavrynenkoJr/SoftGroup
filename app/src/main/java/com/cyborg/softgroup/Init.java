package com.cyborg.softgroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Cyborg on 1/2/2017.
 */

public class Init {

    private List<Integer> mAudioList;
    public static List<Subject> mAnimals = new ArrayList<>();
    public static List<Subject> mTransports = new ArrayList<>();
    private Subject sb;

    public void initial(){

        if(mAnimals.isEmpty()) {

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.airplane);
            initLists(false, "Airplane", R.drawable.transport_icon_05_big_size, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.ambulance);
            initLists(false, "Ambulance", R.drawable.transport_icon_02_big_size, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.bicycle);
            initLists(false, "Bicycle", R.drawable.bicycle, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.bus);
            initLists(false, "Bus", R.drawable.bus, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.car);
            initLists(false, "Car", R.drawable.transport_icon_08_big_size, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.cat_1);
            mAudioList.add(R.raw.cat_2);
            initLists(true, "Cat", R.drawable.cat, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.chicken_1);
            mAudioList.add(R.raw.chicken_2);
            initLists(true, "Chicken", R.drawable.chicken, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.cow_1);
            mAudioList.add(R.raw.cow_2);
            initLists(true, "Cow", R.drawable.cow, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.dog_1);
            mAudioList.add(R.raw.dog_2);
            initLists(true, "Dog", R.drawable.dog, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.elephant_1);
            mAudioList.add(R.raw.elephant_2);
            initLists(true, "Elephant", R.drawable.elephant, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.fire_engine);
            initLists(false, "Fire engine", R.drawable.fire_engine, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.horse_1);
            mAudioList.add(R.raw.horse_2);
            initLists(true, "Horse", R.drawable.horse, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.lion_1);
            mAudioList.add(R.raw.lion_2);
            initLists(true, "Lion", R.drawable.lion, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.monkey_1);
            mAudioList.add(R.raw.monkey_2);
            initLists(true, "Monkey", R.drawable.monkey, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.motorcycle);
            initLists(false, "Motorcycle", R.drawable.motorcycle, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.pig_1);
            mAudioList.add(R.raw.pig_2);
            initLists(true, "Pig", R.drawable.pig, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.police_car);
            initLists(false, "Police car", R.drawable.police_car, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.rocket);
            initLists(false, "Rocket", R.drawable.rocket, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.sheep_1);
            mAudioList.add(R.raw.sheep_2);
            initLists(true, "Sheep", R.drawable.sheep, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.ship);
            initLists(false, "Ship", R.drawable.ship, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.tiger_1);
            mAudioList.add(R.raw.tiger_2);
            initLists(true, "Tiger", R.drawable.tiger, mAudioList);

            mAudioList = new ArrayList<>();
            mAudioList.add(R.raw.train);
            initLists(false, "Train", R.drawable.train, mAudioList);
        }
    }

    public void initLists(boolean b, String name, int image, List<Integer> audioList){

        sb = new Subject();

        if (b){
            sb.setName(name);
            sb.setImage(image);
            sb.setSoundList(audioList);

            mAnimals.add(sb);

        } else {
            sb.setName(name);
            sb.setImage(image);
            sb.setSoundList(audioList);

            mTransports.add(sb);
        }
    }
}
