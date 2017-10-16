package com.tear.sp.http;

import java.io.IOException;

/**
 * des:服务器请求异常
 * Created by xsf
 * on 2016.09.10:16
 */
public class ServerException extends IOException{
    String code;
    public ServerException(String msg){
        super(msg);
    }

    public ServerException(String msg, String code, Throwable E){
        super(msg,E);
        this.code= code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
