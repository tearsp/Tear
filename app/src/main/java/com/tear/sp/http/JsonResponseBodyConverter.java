package com.tear.sp.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;


import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**

 *
 */
public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Gson mGson;
    private final TypeAdapter<T> adapter;
    private Type mType;

    public JsonResponseBodyConverter(Type mType, Gson gson, TypeAdapter<T> adapter) {
        mGson = gson;
        this.adapter = adapter;
        this.mType = mType;
    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        String response = value.string();
        BaseRespose baseRespose = new BaseRespose();
        JSONObject json = JSON.parseObject(response);
        baseRespose.setCode(json.getString("code"));
        baseRespose.setMessage(json.getString("message"));
        if (!baseRespose.success()) {
            value.close();
            throw new ServerException(baseRespose.message,baseRespose.code, new Throwable(response));
        }
        try {
            return mGson.fromJson(response, mType);
        } catch (Exception e) {
            baseRespose.setData(json.getString("data"));
            return (T) baseRespose;
        } finally {
            value.close();
        }
    }
}