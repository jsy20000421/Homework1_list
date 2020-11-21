package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    private TextView newTextView;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        newTextView = itemView.findViewById(R.id.text);
        itemView.setOnClickListener(this::onClick);
    }

    public void bind(String text){
        TextView textView = itemView.findViewById(R.id.text);
        textView.setText(text);
        newTextView.setText(text);
    }

    public void onClick(View v) {
        Intent intent = new Intent(v.getContext(), NextActivity.class);
        intent.putExtra("extra", newTextView.getText().toString());
        v.getContext().startActivity(intent);
    }
}
