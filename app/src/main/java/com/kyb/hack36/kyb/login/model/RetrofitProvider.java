package com.kyb.hack36.kyb.login.model;


import com.kyb.hack36.kyb.helper.Urls;
import com.kyb.hack36.kyb.login.LoginCallback;
import com.kyb.hack36.kyb.login.api.RequestLogin;
import com.kyb.hack36.kyb.login.model.LoginData;

import java.util.concurrent.TimeUnit;
import com.kyb.hack36.kyb.login.model.ProviderInterface;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider implements ProviderInterface {



    @Override
    public void loginData(String mobile, String email, String fcm,final LoginCallback loginCallback) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Retrofit retrofit= new Retrofit.Builder().baseUrl(Urls.BASE_URL).client(client).addConverterFactory(GsonConverterFactory.create()).build();
        RequestLogin requestLogin = retrofit.create(RequestLogin.class);
        Call<LoginData> call= requestLogin.getJSON(mobile,email,fcm);
        call.enqueue(new Callback<LoginData>() {
            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                loginCallback.onLoginSuccess(response.body());
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {
                loginCallback.onLoginFailure(t.getMessage());
            }
        });
    }
}
