package com.geektech.navlesson.study.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.geektech.navlesson.R;
import com.geektech.navlesson.fragments.SectionFragment;
import com.geektech.navlesson.study.operation.Statement;
import com.geektech.navlesson.study.util.listAdapter;

import java.util.ArrayList;
import java.util.List;

// Created by askar on 10/2/18.
//TODO: Ваш список

public class ListFragment extends Fragment {
    private  ListView listView;
    private static String MESSAGE_KEY = "message_key";
    //private TextView textView;

    //Всегда желательно использовать getInstance для создания новых инстансов объектов
    public static Fragment getInstance(){
        Fragment fragment = new ListFragment();

        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_item,container,false);

        init(view);

    return view;
    }
    private void init( View view){

        listView = view.findViewById(R.id.listView);
        listView = view.findViewById(R.id.listView);
        String []  Statements  = {
                "Мегаком",
                "Нуртелеком",
                "Билайн"

        };


        ArrayAdapter<String> listViewArray = new ArrayAdapter<>(getActivity()
                ,android.R.layout.simple_list_item_1,Statements);
        listView.setAdapter(listViewArray);
        getInstance();


    }

}
