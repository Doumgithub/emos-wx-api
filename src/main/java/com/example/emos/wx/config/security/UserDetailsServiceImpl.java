package com.example.emos.wx.config.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName UserDetailsService.java
 * @Description
 * @createTime 2022-04-30 15:16:00
 */
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        todo 从数据库中查询用户数据
        return null;
    }
}
