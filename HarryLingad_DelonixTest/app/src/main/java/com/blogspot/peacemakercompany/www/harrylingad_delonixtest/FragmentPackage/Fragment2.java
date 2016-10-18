package com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.R;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class Fragment2 extends Fragment {


    EditText palindromeET;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2, null);
        palindromeET = (EditText)v.findViewById(R.id.palindromeET);


        return v;
    }

    public boolean evaluatePalindrome(){
        String userAnswer = palindromeET.getText().toString();
        if (isPalindrome(userAnswer)){
            return true;
        }else{
            Toast.makeText(getActivity(), "WRONG ANSWER", Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    public boolean isPalindrome(String wordPar)
    {
        if(wordPar.length() == 0 || wordPar.length() == 1)
            return true;
        if(wordPar.charAt(0) == wordPar.charAt(wordPar.length()-1))
            return isPalindrome(wordPar.substring(1, wordPar.length()-1));
        return false;
    }
}
