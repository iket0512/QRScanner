package com.kyb.hack36.kyb.Home.api;

import com.kyb.hack36.kyb.Home.model.QrData;
import com.kyb.hack36.kyb.helper.Keys;
import com.kyb.hack36.kyb.helper.Urls;
import com.kyb.hack36.kyb.login.model.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by iket on 27/1/18.
 */

public interface QrRequest {
    @FormUrlEncoded
    @POST(Urls.REQUEST_QR_DATA)
    Call<QrData> getQR(@Field("product_hash") String prod_id,@Field("access_token") String access);

    @FormUrlEncoded
    @POST(Urls.REQUEST_TRANSACT)
    Call<QrData> sendQR(@Field("product_hash") String prod_id,@Field("access_token") String access,@Field("receiver") String receiver);
}
