package com.blogspot.peacemakercompany.www.harrylingad_delonixtest.NextAppActivities;


import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class AppSingleton {

    private static AppSingleton appSingletonInstance;
    private static Context context;
    private RequestQueue requestQueue;

    public AppSingleton(Context context){

        this.context = context;
        requestQueue = getRequestQueue();

    }

    public RequestQueue getRequestQueue(){
        if(requestQueue == null){
            requestQueue = Volley.newRequestQueue(context.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized AppSingleton getInstance(Context context){
        if(appSingletonInstance == null){
            appSingletonInstance = new AppSingleton(context);
        }
        return appSingletonInstance;
    }

    public <T> void addToRequestQueue(Request<T>req, String tag ){
        req.setTag(tag);
        getRequestQueue().add(req);
    }

    public void cancelPendingRequest(Object tag){
        if(requestQueue != null)
            requestQueue.cancelAll(tag);

    }



}
