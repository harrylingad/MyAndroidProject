package com.blogspot.peacemakercompany.www.harrylingad_delonixtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class CongratulationActivity extends Activity {



    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congratulation);



    }

    public void tryAgain(View v){

        Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(mainActivity);
    }

    public void nextApp(View v){

        Intent nextApp = new Intent(this, NextAppActivity.class);
        startActivity(nextApp);
    }
}
