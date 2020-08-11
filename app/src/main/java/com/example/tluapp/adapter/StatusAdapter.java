package com.example.tluapp.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tluapp.Entities.Status;
import com.example.tluapp.R;

import java.util.List;

public class StatusAdapter extends BaseAdapter {

    List<Status> list;
    public StatusAdapter(List<Status> list){
        this.list = list;
    }

    public void updateStatus(List<Status> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewStatus;
       if (convertView == null){
           viewStatus = View.inflate(parent.getContext(), R.layout.status_view, null);
       } else viewStatus = convertView;
       Status status = (Status) getItem(position);
        ((TextView) viewStatus.findViewById(R.id.txt_title)).setText(status.getTitle());
        return viewStatus;
    }
}
