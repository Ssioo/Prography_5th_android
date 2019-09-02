package com.pa1.prography_5th_android;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    public static final String API_URL = "https://ghibliapi.herokuapp.com/";

    @GET("films")
    Call<ResponseBody>getFilms();
}
