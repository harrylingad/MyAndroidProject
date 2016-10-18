package com.blogspot.peacemakercompany.www.harrylingad_delonixtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.NextAppActivities.ImageAdapterActivity;
import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.NextAppActivities.PullToRefreshActivity;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class NextAppActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.next_app_menu);

    }

    public void goToAdapterImage(View v){

        Intent imageAdapterActivity = new Intent(this, ImageAdapterActivity.class);
        startActivity(imageAdapterActivity);
    }

    public void goToAdapterPullToRefresh(View v){

        Intent pullToRefreshActivity = new Intent(this, PullToRefreshActivity.class);
        startActivity(pullToRefreshActivity);
    }
}
