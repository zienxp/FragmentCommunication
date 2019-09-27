package com.example.fragmentcommunication;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {
    private EditText editText;
    private Button button;
    private OnMessageReadListener onMessageReadListener;

    public MessageFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        editText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String message = editText.getText().toString();
            onMessageReadListener.onMessageRead(message);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        Activity activity = (Activity) context;


        try {
            onMessageReadListener = (OnMessageReadListener) activity;
        } catch (ClassCastException e){
            throw new ClassCastException((activity.toString()+"must Override onMessageRead..."));
        }
    }

    public interface OnMessageReadListener {
        public void onMessageRead(String message);
    }
}
