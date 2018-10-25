package com.geektech.navlesson.study.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.geektech.navlesson.R;

// Created by askar on 10/2/18.
//TODO: Ваш калькулятор

public class CalculatorFragment extends Fragment implements View.OnClickListener {
    private TextView mMessageView;
    private Button btnone,btntwo,btnthree,btnfour,btnfive,btnsix,btnseven,btneight,btnnine,btnzero;
    private Button btnequal,btnplus,btnminus,btnmultiply,btndivide,btnclear;
    private TextView txtResult;
    int flagAction,res1,res2;
    double result;
    private static String MESSAGE_KEY = "message_key";

    public  static Fragment getFragment(){
        Fragment fragment = new CalculatorFragment();

        return fragment;
    }
    public  static Fragment getInstance(String message){
        Fragment fragment = new CalculatorFragment();
        fragment.setArguments(getBundle(message));
        return fragment;
    }

    public static Bundle getBundle(String message){
       Bundle bundle = new Bundle();
       bundle.putString(MESSAGE_KEY,message);
       return  bundle;
    }
    public static String getMessage (Bundle args) {
        String message = "Empty";
        try{
            message = args.getString(MESSAGE_KEY);

        }catch (Exception e){
            Log.e("ahaha",e.getMessage(),e);
        }
        return message;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.calculator_fragment,container,false);
        init(view);
        return view;
    }

    private void init(View view){

        txtResult = view.findViewById(R.id.resultView);
        btnone    = view.findViewById(R.id.one);
        btntwo    = view.findViewById(R.id.two);
        btnthree  = view.findViewById(R.id.three);
        btnfour   = view.findViewById(R.id.four);
        btnfive   = view.findViewById(R.id.five);
        btnsix    = view.findViewById(R.id.six);
        btnseven  = view.findViewById(R.id.seven);
        btneight  = view.findViewById(R.id.eight);
        btnnine   = view.findViewById(R.id.nine);
        btnzero   = view.findViewById(R.id.zero);
        btnequal     = view.findViewById(R.id.equal);
        btnplus   = view.findViewById(R.id.plus);
        btnminus  = view.findViewById(R.id.minus);
        btnmultiply = view.findViewById(R.id.multiply);
        btndivide   = view.findViewById(R.id.divide);
        btnclear   = view.findViewById(R.id.clear);
        btnone.setOnClickListener(this);
        btntwo.setOnClickListener(this);
        btnthree.setOnClickListener(this);
        btnfour.setOnClickListener(this);
        btnfive.setOnClickListener(this);
        btnsix.setOnClickListener(this);
        btnseven.setOnClickListener(this);
        btneight.setOnClickListener(this);
        btnnine.setOnClickListener(this);
        btnzero.setOnClickListener(this);
        btnequal.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnminus.setOnClickListener(this);
        btnmultiply.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btndivide.setOnClickListener(this);
        btnclear.setOnClickListener(this);

        res1 = 0;
        res2 = 0;
        result = 0;
        flagAction = 0;
        txtResult.setText(Integer.toString(res1));
        getFragment();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.one: clickNumber(1);
                break;
            case R.id.two: clickNumber(2);
                break;
            case R.id.three: clickNumber(3);
                break;
            case R.id.four: clickNumber(4);
                break;
            case R.id.five: clickNumber(5);
                break;
            case R.id.six: clickNumber(6);
                break;
            case R.id.seven: clickNumber(7);
                break;
            case R.id.eight: clickNumber(8);
                break;
            case R.id.nine: clickNumber(9);
                break;
            case R.id.zero: clickNumber(0);
                break;
            case R.id.plus:
                if (flagAction == 0) flagAction = 1;
                break;
            case R.id.minus:
                if(flagAction == 0) flagAction = 2;
                break;
            case R.id.multiply:
                if(flagAction == 0) flagAction = 3;
                break;
            case R.id.divide:
                if(flagAction == 0) flagAction = 4;
                break;
            case R.id.equal:
                switch (flagAction){
                    case 1: result = res1 + res2;
                        break;
                    case 2: result = res1 - res2;
                        break;
                    case 3: result = res1 * res2;
                        break;
                    case 4: result = (double)res1 / (double)res2;
                        break;
                    //default: Toast.makeText(this, "Операция не задана", Toast.LENGTH_LONG).show();

                }
                if (flagAction != 0){
                    txtResult.setText(Double.toString(result));

                    res1 = 0;
                    res2 = 0;
                    result = 0;
                    flagAction = 0;

                }
                break;
            case R.id.clear:
                res1 = 0;
                res2 = 0;
                result = 0;
                flagAction = 0;
                txtResult.setText(Integer.toString(res1));

                break;

        }

    }

    private void  clickNumber(int  num){
        if (flagAction == 0){
            res1 = res1*10 + num;
            txtResult.setText(Integer.toString(res1));


        }
        else{
            res2 = res2*10 + num;
            txtResult.setText(Integer.toString(res2));
            txtResult.setText(Integer.toString(res2));

        }

    }

}

