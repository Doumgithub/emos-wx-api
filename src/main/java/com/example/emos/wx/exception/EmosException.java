package com.example.emos.wx.exception;

import lombok.Data;

/**
 * @author admin
 * @version 1.0.0
 * @ClassName EmosException.java
 * @Description
 * @createTime 2022-04-26 14:53:00
 */
@Data
public class EmosException extends RuntimeException{
    private String msg;
    private int code=500;

    public EmosException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public EmosException(String msg,Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public EmosException(String msg,int code) {
        super(msg);
        this.msg = msg;
        this.code=code;
    }

    public EmosException(String msg,int code,Throwable e) {
        super(msg,e);
        this.msg = msg;
        this.code=code;
    }
}
