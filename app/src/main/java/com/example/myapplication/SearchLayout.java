package com.example.myapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SearchLayout extends FrameLayout {

    private onInputChangedListener onInputChangedListener;
    public SearchLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public SearchLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SearchLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        inflate(getContext(),R.layout.layout_search,this);
        EditText input = findViewById(R.id.input);
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(onInputChangedListener != null){
                    onInputChangedListener.onChanged(editable.toString());
                }
            }
        });
    }

    public void setOnInputChangedListener(onInputChangedListener listener) {
        this.onInputChangedListener = listener;
    }

    public interface onInputChangedListener{
        void onChanged(String text);
    }
}
