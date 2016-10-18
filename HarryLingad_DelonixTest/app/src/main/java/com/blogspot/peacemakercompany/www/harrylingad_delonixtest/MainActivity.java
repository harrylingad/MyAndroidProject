package com.blogspot.peacemakercompany.www.harrylingad_delonixtest;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage.Fragment1;
import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage.Fragment2;
import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage.Fragment3;
import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.FragmentPackage.Fragment4;

public class MainActivity extends Activity {

    public enum Status{

        frag0, frag1, frag2, frag3
    }

    Status status;
    Fragment1 fm1;
    Fragment2 fm2;
    Fragment3 fm3;
    Fragment4 fm4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fm1 = new Fragment1();
        fm2 = new Fragment2();
        fm3 = new Fragment3();
        fm4 = new Fragment4();

        status = Status.frag0;
        Button button = (Button) findViewById(R.id.loadbutton);



        View.OnClickListener viewlistener = new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View v) {



                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                switch(status){
                    case frag0:
                        status = Status.frag1;
                        fragmentTransaction.add(R.id.fragment_container, fm1, "HELLO");
                        break;
                    case frag1:
                        if (fm1.evaluateNumberSum()) {
                            status = Status.frag2;
                            fragmentTransaction.addToBackStack("Hello");
                            fragmentTransaction.replace(R.id.fragment_container, fm2, "HELLO");
                        }
                        break;
                    case frag2:
                        if (fm2.evaluatePalindrome()) {
                            status = Status.frag3;
                            fragmentTransaction.addToBackStack("Hello");
                            fragmentTransaction.replace(R.id.fragment_container, fm3, "HELLO");
                        }
                        break;
                    case frag3:
                        if(fm3.evaluateAnagram()) {
                            Intent i = new Intent(MainActivity.this, CongratulationActivity.class);
                            startActivity(i);
                        }
                        break;
                        default:

                }
                fragmentTransaction.commit();


            }
        };

        button.setOnClickListener(viewlistener);

    }




    public void evaluateFragment1(){


    }
}
