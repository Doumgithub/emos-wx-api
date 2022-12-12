package com.example.emos.wx.config;

import com.baidu.aip.face.AipFace;
import lombok.Data;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ApiFaceConfig.java
 * @Description
 * @createTime 2022-05-12 19:24:00
 */
@Configuration
public class ApiFaceConfig {
    //设置APPID/AK/SK
    @Value("${emos.face.AppID}")
    public String APP_ID;
    @Value("${emos.face.APIKey}")
    public String API_KEY;
    @Value("${emos.face.SecretKey}")
    public String SECRET_KEY;

    public AipFace
    public static void main(String[] args) {
        // 初始化一个AipFace
        AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理


    }
}
