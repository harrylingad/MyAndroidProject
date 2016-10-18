package com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage;

import android.app.AlertDialog;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.R;

import java.util.Arrays;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class Fragment3 extends Fragment {

    EditText word1;
    EditText word2;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment3, null);

        word1 = (EditText)v.findViewById(R.id.word1);
        word2 = (EditText)v.findViewById(R.id.word2);


        return v;
    }

    public boolean evaluateAnagram(){
        String firstWord = word1.getText().toString();
        String secondWord = word2.getText().toString();

        if(isAnagram(firstWord, secondWord)){
            Toast.makeText(getActivity(), "Correct", Toast.LENGTH_LONG);
            return true;
        }else{
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
            alertDialogBuilder.setTitle("Message");
            alertDialogBuilder.setMessage("Wrong answer");
            alertDialogBuilder.setPositiveButton("OK", null);
            alertDialogBuilder.show();
            return false;
        }

    }

    public boolean isAnagram(String firstWord, String secondWord) {

        char[] word1 = firstWord.replaceAll("[\\s]", "").toCharArray();
        char[] word2 = secondWord.replaceAll("[\\s]", "").toCharArray();
        Arrays.sort(word1);
        Arrays.sort(word2);
        return Arrays.equals(word1, word2);
    }
}
