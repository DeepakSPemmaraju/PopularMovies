package com.example.android.popularmovies;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by deepakpe on 7/31/2016.
 */
public class MainActivityFragment extends Fragment {
    private QueryResult queryResult;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        FetchMoviesTask moviesTaskTask = new FetchMoviesTask();
        moviesTaskTask.execute();
        GridView gridview = (GridView) getView().findViewById(R.id.gridview);
        gridview.setAdapter(new MovieAdapter(getActivity()));
        return rootView;
    }

    private class FetchMoviesTask extends AsyncTask<Void, Void, QueryResult> {
        private final String LOG_TAG = FetchMoviesTask.class.getSimpleName();

        @Override
        protected void onPostExecute(QueryResult result) {
            queryResult = result;
        }

        @Override
        protected QueryResult doInBackground(Void... voids) {
            HttpURLConnection urlConnection = null;
            BufferedReader reader = null;

            String popularMoviesStr = null;

            try{
                String baseUrl = "https://api.themoviedb.org/3/movie/popular?api_key=d0a65dc4886d87d6de1287f0dc4b927c";
                try {
                    URL url = new URL(baseUrl);

                    urlConnection = (HttpURLConnection)url.openConnection();
                    urlConnection.setRequestMethod("GET");
                    urlConnection.connect();

                    //Read input stream into a String
                    InputStream inputStream = urlConnection.getInputStream();
                    StringBuffer buffer = new StringBuffer();
                    if (inputStream == null) {
                        // Nothing to do.
                        return null;
                    }

                    reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        // Since it's JSON, adding a newline isn't necessary (it won't affect parsing)
                        // But it does make debugging a *lot* easier if you print out the completed
                        // buffer for debugging.
                        buffer.append(line + "\n");
                    }
                    if (buffer.length() == 0) {
                        // Stream was empty.  No point in parsing.
                        return null;
                    }

                    popularMoviesStr = buffer.toString();
                    Gson gson = new Gson();
                    QueryResult queryResult = gson.fromJson(popularMoviesStr, QueryResult.class);
                    System.out.print(queryResult);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            finally {
                if (urlConnection != null) {
                    urlConnection.disconnect();
                }
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (final IOException e) {
                        Log.e(LOG_TAG, "Error closing stream", e);
                    }
                }
            }
            return null;
        }
    }

    public class MovieAdapter extends BaseAdapter {
        private Context mContext;

        // Gets the context so it can be used later
        public MovieAdapter(Context c) {
            mContext = c;
        }

        // Total number of things contained within the adapter
        public int getCount() {
            return queryResult.getResults().length;
        }

        // Require for structure, not really used in my code.
        public Object getItem(int position) {
            return null;
        }

        // Require for structure, not really used in my code. Can
        // be used to get the id of an item in the adapter for
        // manual control.
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position,
                            View convertView, ViewGroup parent) {
            ImageView imageView;
            if (convertView == null) {
                // if it's not recycled, initialize some attributes
                imageView = new ImageView(mContext);
                imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageView.setPadding(8, 8, 8, 8);
            } else {
                imageView = (ImageView) convertView;
            }

            Picasso.with(mContext).load("http://i.imgur.com/DvpvklR.png").into(imageView);
            return imageView;
        }
    }
}
