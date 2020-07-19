package com.example.tluapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tluapp.Entities.TimeTable;
import com.example.tluapp.R;

import java.util.ArrayList;

public class TimeTableViewAdapter extends BaseAdapter {
    final ArrayList<TimeTable> list;

    public TimeTableViewAdapter(ArrayList<TimeTable> list){
        this.list = list;
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewTimeTable;
        if (convertView == null){
            viewTimeTable = View.inflate(parent.getContext(), R.layout.timetable_view, null);
        } else viewTimeTable = convertView;

        TimeTable timeTable = (TimeTable) getItem(position);
        ((TextView) viewTimeTable.findViewById(R.id.txt_subName)).setText(timeTable.getSubjectName());
        ((TextView) viewTimeTable.findViewById(R.id.txt_time)).setText(timeTable.getTime());
        ((TextView) viewTimeTable.findViewById(R.id.txt_location)).setText(timeTable.getLocation());

        return viewTimeTable;
    }
}
