package com.ndaarp.n_li8;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by naveen on 9/23/2015.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private final LayoutInflater inflater;
    List<Information> data = Collections.emptyList();

    public Adapter(Context context , List<Information> data){

        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.customrow,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        Information current = data.get(position);
        holder.club.setText(current.deptName);
        holder.heading.setText(current.heading);
        holder.notice.setText(current.message);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class MyViewHolder extends  RecyclerView.ViewHolder {

        TextView club,heading,notice;
        public MyViewHolder(View itemView) {
            super(itemView);
            club = (TextView) itemView.findViewById(R.id.row1);
            heading = (TextView) itemView.findViewById(R.id.row2);
            notice = (TextView) itemView.findViewById(R.id.row3);
        }
    }
}
