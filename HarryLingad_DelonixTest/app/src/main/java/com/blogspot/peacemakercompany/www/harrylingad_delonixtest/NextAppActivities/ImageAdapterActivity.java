package com.blogspot.peacemakercompany.www.harrylingad_delonixtest.NextAppActivities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.blogspot.peacemakercompany.www.harrylingad_delonixtest.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Harry Lingad on 10/17/2016.
 */
public class ImageAdapterActivity extends Activity {

    private String TAG = ImageAdapterActivity.class.getSimpleName();
    private String url ="https://www.mangaeden.com/api/list/0";

    public String arrayURL = "https://videogamesrating.p.mashape.com/get.php?count=5&game=God+of+War";
    private String tag_json_obj = "jobj_req";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_adapter_activity);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Loading...");
        dialog.setCancelable(false);

//        jsonArrayRequest();

//        getComicsLists();

        fetchMovies();
//        makeJsonObjReq();
    }




  //// IMAGE TEST

        private void fetchMovies() {
//        showProgressDialog();

//        String url = URL_TOP_250 + offSet;
//        String url = URL_TOP_250;
//
//
      JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());

                        if (response.length() > 0) {
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    JSONArray comics = response.getJSONArray("manga");
                                    JSONObject comicsObject = comics.getJSONObject(i);

//                                    String a_alias = comicsObject.getString("a");
//                                    JSONArray c_category = comicsObject.getJSONArray("c");
//                                    int h_hits = comicsObject.getInt("h");
//                                    String i_id = comicsObject.getString("i");
//                                    String im_images = comicsObject.getString("im");
//                                    double ld_lastChapterDate = comicsObject.getDouble("ld");
//                                    int s_status = comicsObject.getInt("s");
                                    String t_title = comicsObject.getString("t");


                                    int rank = i + 1;
                                    String title = t_title;

//                                    Movie m = new Movie(rank, title);
//                                    movieList.add(0, m);


                                        // updating offset value to highest value
//                                        if (rank >= offSet) {
//                                            offSet = rank;
//                                            Log.d("OFFSET: ", " " + offSet);
//                                        }


                                    Log.d("MANGA", comics.toString());
                                    Log.d("COMICS_OBJECT", comicsObject.toString());

                                } catch (JSONException e) {
                                    Log.e(TAG, "JSON Parsing error: " + e.getMessage());
                                }
                            }
//                            adapter.notifyDataSetChanged();
                        }
//                        // stopping swipe refresh
//                        swipeRefreshLayout.setRefreshing(false);


                        //todo
//                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
//                headers.put("X-Mashape-Key", "ah8FGpEPZxmshzRiM9eeldMq02Awp1R2Dzkjsn7IsizraQR6R6");
//                headers.put("Accept", "application/json");

                headers.put("Content-Type", "application/json");
                return headers;
            }

            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("name", "Androidhive");
                params.put("email", "abc@androidhive.info");
                params.put("pass", "password123");

                return params;
            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
    }

















    public void getComicsLists(){

        Response.Listener respListener = new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                Log.d("RESPONSE: ", response.toString());
            }
        };

            Response.ErrorListener respErrorListener = new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("ERROR; ", error.toString());

            }
        };




        JsonObjectRequest req = new JsonObjectRequest(url, null, respListener, respErrorListener)
        {
 		@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Content-Type", "application/json");
            return headers;
          }
        };

        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(req, tag_json_obj);
    }









    private void showProgressDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    private void hideProgressDialog() {
        if (dialog.isShowing())
            dialog.hide();
    }




    private void makeJsonObjReq() {
        showProgressDialog();

        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Method.GET,
                url, null,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("ImageAdapterActivity", response.toString());
                        hideProgressDialog();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("ImageAdapterActivity", "ERROR: " + error.getMessage());
                hideProgressDialog();
            }
        }) {

            /**
             * Passing some request headers
             * */
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                return headers;
            }

//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "Androidhive");
//                params.put("email", "abc@androidhive.info");
//                params.put("pass", "password123");
//
//                return params;
//            }

        };

        // Adding request to request queue
        AppController.getInstance().addToRequestQueue(jsonObjReq,
                "ImageAdapterActivity");
    }










    public void jsonArrayRequest(){

        Response.Listener responseListener = new Response.Listener<JSONArray>(){

            @Override
            public void onResponse(JSONArray response) {

                Log.d("IMAGEADAPTERACTIVITY", response.toString());

            }
        };

        Response.ErrorListener  responseErrorListener = new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        };

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(arrayURL, responseListener, responseErrorListener){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("X-Mashape-Key", "ah8FGpEPZxmshzRiM9eeldMq02Awp1R2Dzkjsn7IsizraQR6R6");
                headers.put("Accept", "application/json");
                return headers;
            }
        };

        AppSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonArrayRequest, "ImageAdapterActivity");

    }




}
