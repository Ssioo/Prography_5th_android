package com.pa1.prography_5th_android;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Fragment_films extends Fragment {
    private RecyclerView recyclerView;
    private CustomRecyclerView recycleradapter;
    private Retrofit retrofit;
    private ApiService apiService;
    private ArrayList<JSONData> Datalist = new ArrayList<>();

    public Fragment_films() { }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_chats, container, false);

        retrofit = new Retrofit.Builder().baseUrl(ApiService.API_URL).build();
        apiService = retrofit.create(ApiService.class);

        /* findViewById */
        recyclerView = view.findViewById(R.id.recyclerview);

        /* JSON 불러오기 */
        Call<ResponseBody> films = apiService.getFilms();
        films.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    String json = response.body().string();
                    jsonParsing(json);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                /* RecyclerView 구성 */
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
                recyclerView.setLayoutManager(linearLayoutManager);
                recycleradapter = new CustomRecyclerView(Datalist);
                recyclerView.setAdapter(recycleradapter);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });



        return view;
    }

    private void jsonParsing(String json) {
        try {
            JSONArray dataArray = new JSONArray(json); // json 문자열을 jsonArray로 받아오기

            for (int i=0; i<dataArray.length(); i++) {
                JSONObject dataObject = dataArray.getJSONObject(i);

                JSONData jsonData = new JSONData();
                jsonData.setNum(i + 1);
                jsonData.setId(dataObject.getString("id"));
                jsonData.setTitle(dataObject.getString("title"));
                jsonData.setDirector(dataObject.getString("director"));
                jsonData.setDescription(dataObject.getString("description"));
                jsonData.setProducer(dataObject.getString("producer"));
                jsonData.setRelease_date(dataObject.getString("release_date"));
                jsonData.setRt_score(dataObject.getInt("rt_score"));

                Datalist.add(jsonData);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
