package com.example.tluapp.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.tluapp.Entities.Comment;
import com.example.tluapp.Entities.Status;
import com.example.tluapp.R;

import java.util.List;

public class CommentAdapter extends BaseAdapter {
    List<Comment> list;
    public CommentAdapter(List<Comment> list){
        this.list = list;
    }

    public void updateComment(List<Comment> list){
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
        View viewComment;
        if (convertView == null){
            viewComment = View.inflate(parent.getContext(), R.layout.comment_view, null);
        } else viewComment = convertView;
        Comment comment = (Comment) getItem(position);
        ((TextView) viewComment.findViewById(R.id.txt_text)).setText(comment.getText());
        return viewComment;
    }

}
