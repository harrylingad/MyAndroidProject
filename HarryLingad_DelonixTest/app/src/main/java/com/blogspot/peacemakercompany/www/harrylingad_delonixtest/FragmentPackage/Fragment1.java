package com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.R;

import java.util.Random;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class Fragment1 extends Fragment {


    TextView number1TV;
    TextView number2TV;
    TextView messageTV;
    EditText answerET;

    int total = 0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment1, null);

        number1TV = (TextView) v.findViewById(R.id.number1TV);
        number2TV = (TextView)v.findViewById(R.id.number2TV);
        messageTV = (TextView)v.findViewById(R.id.messageTV);
        answerET = (EditText)v.findViewById(R.id.numberSumET);


        Random random = new Random();

        int num1 = random.nextInt(50);
        int num2 = random.nextInt(50);


        number1TV.setText("" + num1);
        number2TV.setText("" + num2);


        total = num1 + num2;
        return v;
    }

    public int getTotal() {
        return total;
    }

    public boolean evaluateNumberSum(){
        String g = answerET.getText().toString();
        int usersAnswer = Integer.parseInt(g);

        if (usersAnswer == total){
            return true;}
        else{
            messageTV.setText("WRONG");
        return false;}

    }
}
