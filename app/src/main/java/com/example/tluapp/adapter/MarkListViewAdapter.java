package com.example.tluapp.adapter;

import android.icu.lang.UProperty;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tluapp.Entities.SubjectMark;
import com.example.tluapp.R;

import java.util.ArrayList;

public class MarkListViewAdapter extends BaseAdapter {
    final ArrayList<SubjectMark> listMark;

    public MarkListViewAdapter(ArrayList<SubjectMark> listMark) {
        this.listMark = listMark;
    }

    @Override
    public int getCount() {
        return listMark.size();
    }

    @Override
    public Object getItem(int position) {
        return listMark.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewMark;
        if (convertView == null){
            viewMark = View.inflate(parent.getContext(), R.layout.mark_view,null);
        } else viewMark = convertView;

        SubjectMark sm = (SubjectMark) getItem(position);
        ((TextView) viewMark.findViewById(R.id.txt_subjectName)).setText(sm.getSubName());
        ((TextView) viewMark.findViewById(R.id.txt_subjectMark)).setText(sm.getSubMark());
        ((TextView) viewMark.findViewById(R.id.txt_stringMark)).setText(sm.getStrMark());
        return viewMark;
    }
}
