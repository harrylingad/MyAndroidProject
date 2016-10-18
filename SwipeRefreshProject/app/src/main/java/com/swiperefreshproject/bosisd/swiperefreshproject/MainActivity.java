package com.swiperefreshproject.bosisd.swiperefreshproject;


import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;


import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.swiperefreshproject.bosisd.swiperefreshproject.app.AppController;
import com.swiperefreshproject.bosisd.swiperefreshproject.app.MyApplication;
import com.swiperefreshproject.bosisd.swiperefreshproject.helper.Movie;
import com.swiperefreshproject.bosisd.swiperefreshproject.helper.SwipeListAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener {
    private String TAG = MainActivity.class.getSimpleName();

    private String URL_TOP_250 = "http://api.androidhive.info/json/imdb_top_250.php?offset=";
//    private String URL_TOP_250 = "http://www.mangaeden.com/api/list/";

//    private String URL_TOP_250 = "https://videogamesrating.p.mashape.com/get.php?count=5&game=God+of+War";

    private String tag_json_obj = "jobj_req";

    private SwipeRefreshLayout swipeRefreshLayout;
    private ListView listView;
    private SwipeListAdapter adapter;
    private List<Movie> movieList;


        // initially offset will be 0, later will be updated while parsing the json
    private int offSet = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);

        movieList = new ArrayList<>();
        adapter = new SwipeListAdapter(this, movieList);
        listView.setAdapter(adapter);

        swipeRefreshLayout.setOnRefreshListener(this);

        /**
         * Showing Swipe Refresh animation on activity create
         * As animation won't start on onCreate, post runnable is used
         */
        swipeRefreshLayout.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        swipeRefreshLayout.setRefreshing(true);

//                                        fetchMovies();



                                    }
                                }
        );

    }

    /**
     * This method is called when swipe refresh is pulled down
     */
    @Override
    public void onRefresh() {

        fetchMovies();
    }

    /**
     * Fetching movies json by making http call
     */

//    private void fetchMovies() {
////        showProgressDialog();
//
//        String url = URL_TOP_250 + offSet;
////        String url = URL_TOP_250;
//
//        JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.GET,
//                url, null,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//
//                        if (response.length() > 0) {
//                            for (int i = 0; i < response.length(); i++) {
//                                try {
//                                    JSONArray comics = response.getJSONArray("manga");
//                                    JSONObject comicsObject = comics.getJSONObject(i);
//
////                                    String a_alias = comicsObject.getString("a");
////                                    JSONArray c_category = comicsObject.getJSONArray("c");
////                                    int h_hits = comicsObject.getInt("h");
////                                    String i_id = comicsObject.getString("i");
////                                    String im_images = comicsObject.getString("im");
////                                    double ld_lastChapterDate = comicsObject.getDouble("ld");
////                                    int s_status = comicsObject.getInt("s");
//                                    String t_title = comicsObject.getString("t");
//
//
//                                    int rank = i + 1;
//                                    String title = t_title;
//
//                                    Movie m = new Movie(rank, title);
//                                    movieList.add(0, m);
//
//
//                                        // updating offset value to highest value
//                                        if (rank >= offSet) {
//                                            offSet = rank;
//                                            Log.d("OFFSET: ", " " + offSet);
//                                        }
//
//
//                                    Log.d("MANGA", comics.toString());
//                                    Log.d("COMICS_OBJECT", comicsObject.toString());
//
//                                } catch (JSONException e) {
//                                    Log.e(TAG, "JSON Parsing error: " + e.getMessage());
//                                }
//                            }
//                            adapter.notifyDataSetChanged();
//                        }
////                        // stopping swipe refresh
//                        swipeRefreshLayout.setRefreshing(false);
//
//
//                        //todo
////                        hideProgressDialog();
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
////                hideProgressDialog();
//            }
//        }) {
//
//            /**
//             * Passing some request headers
//             * */
//            @Override
//            public Map<String, String> getHeaders() throws AuthFailureError {
//                HashMap<String, String> headers = new HashMap<String, String>();
////                headers.put("X-Mashape-Key", "ah8FGpEPZxmshzRiM9eeldMq02Awp1R2Dzkjsn7IsizraQR6R6");
////                headers.put("Accept", "application/json");
//
//                headers.put("Content-Type", "application/json");
//                return headers;
//            }
//
//            @Override
//            protected Map<String, String> getParams() {
//                Map<String, String> params = new HashMap<String, String>();
//                params.put("name", "Androidhive");
//                params.put("email", "abc@androidhive.info");
//                params.put("pass", "password123");
//
//                return params;
//            }
//
//        };
//
//        // Adding request to request queue
//        AppController.getInstance().addToRequestQueue(jsonObjReq);
//
//        // Cancelling request
//        // ApplicationController.getInstance().getRequestQueue().cancelAll(tag_json_obj);
//    }










    private void fetchMovies() {

        // showing refresh animation before making http call
        swipeRefreshLayout.setRefreshing(true);

        // appending offset to url
        String url = URL_TOP_250 + offSet;

        // Volley's json array request object
        JsonArrayRequest req = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d(TAG, response.toString());

                        if (response.length() > 0) {

                            // looping through json and adding to movies list

                              for (int i = 0; i < response.length(); i++) {

                                try {
                                    JSONObject movieObj = response.getJSONObject(i);

                                    int rank = movieObj.getInt("rank");
                                    String title = movieObj.getString("title");

                                    Movie m = new Movie(rank, title);



                                    movieList.add(0, m);

                                    // updating offset value to highest value
                                    if (rank >= offSet) {
                                        offSet = rank;
                                        Log.d("OFFSET: ", " " + offSet);
                                    }

                                } catch (JSONException e) {
                                    Log.e(TAG, "JSON Parsing error: " + e.getMessage());
                                }
                            }

                            adapter.notifyDataSetChanged();
                        }

                        // stopping swipe refresh
                        swipeRefreshLayout.setRefreshing(false);

                    }
                }, new Response.ErrorListener() {
            @Override

            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "Server Error: " + error.getMessage());

                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

                // stopping swipe refresh
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        // Adding request to request queue

        MyApplication.getInstance().addToRequestQueue(req);
    }

}
