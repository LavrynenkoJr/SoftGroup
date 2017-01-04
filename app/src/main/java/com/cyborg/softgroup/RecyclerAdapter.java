package com.cyborg.softgroup;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyborg on 12/29/2016.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    private final View.OnClickListener mOnClickListener;

    private Context mContext;
    private List<Subject> subjectList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.title);
            imageView = (ImageView) view.findViewById(R.id.image_view);
        }
    }


    public RecyclerAdapter(Context mContext, List<Subject> subjectList, View.OnClickListener onClickListener) {
        this.mContext = mContext;
        this.subjectList = subjectList;
        mOnClickListener = onClickListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.subject_card, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Subject subject = subjectList.get(position);
        holder.title.setText(subject.getName());
        holder.imageView.setImageResource(subject.getImage());
        holder.imageView.setOnClickListener(mOnClickListener);
        holder.imageView.setTag(subject);

    }

    @Override
    public int getItemCount() {
        return subjectList.size();
    }
}