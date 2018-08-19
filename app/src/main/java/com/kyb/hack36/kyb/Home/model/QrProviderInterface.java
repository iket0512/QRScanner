package com.kyb.hack36.kyb.Home.model;

import com.kyb.hack36.kyb.Home.HomeCallBack;

/**
 * Created by iket on 27/1/18.
 */

public interface QrProviderInterface {
    void getProductData(String prod_id, String access, HomeCallBack homeCallBack);
    void transfer(String prod_id,String receiver,String access, HomeCallBack homeCallBack);
}
