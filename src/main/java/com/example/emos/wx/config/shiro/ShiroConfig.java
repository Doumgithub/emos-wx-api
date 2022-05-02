package com.example.emos.wx.config.shiro;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName ShiroConfig.java
 * @Description
 * @createTime 2022-04-30 15:18:00
 */
@Configuration
public class ShiroConfig {
    @Bean
    public SecurityManager securityManager(Oauth2Realm realm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(realm);
        securityManager.setRememberMeManager(null);
        return securityManager;
    }
    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager,Oauth2Filter filter){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        HashMap<String, Filter> map = new HashMap<>();
        map.put("oauth2",filter);
        shiroFilter.setFilters(map);
        LinkedHashMap<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/webjars/**","anon");
        filterMap.put("/druid/**","anon");
        filterMap.put("/app/**","anon");
        filterMap.put("/sys/login","anon");
        filterMap.put("/swagger/**","anon");
        filterMap.put("/v2/api-docs","anon");
        filterMap.put("/swagger-ui.html","anon");
        filterMap.put("/swagger-resources/**","anon");
        filterMap.put("/user/register","anon");
        filterMap.put("/user/login","anon");
        filterMap.put("/test/**","anon");
        filterMap.put("**","oauth2");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }
    @Bean
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
