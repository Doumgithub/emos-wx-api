package com.example.emos.wx.controller;

import com.example.emos.wx.common.util.R;
import com.example.emos.wx.controller.form.TestSayHelloForm;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName TestController.java
 * @Description
 * @createTime 2022-04-26 19:35:00
 */
@RestController
@Api(description = "测试swagger接口")
@RequestMapping("/test")
public class TestController {

    @PostMapping("/sayHello")
    @ApiOperation("sayHello方法")
    public R sayHello(@Valid @RequestBody TestSayHelloForm form){
        return R.ok().put("message","Hello"+form.getName());
    }
}
