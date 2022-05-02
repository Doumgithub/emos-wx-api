package com.example.emos.wx.config.shiro;

import org.springframework.stereotype.Component;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ThreadLocalToken.java
 * @Description
 * @createTime 2022-04-30 14:19:00
 */
@Component
public class ThreadLocalToken {
    private ThreadLocal<String> local = new ThreadLocal();

    public void setToken(String token){
        local.set(token);
    }

    public String getToken(){
        return (String)local.get();
    }

    public void clear(){
        local.remove();
    }
}
