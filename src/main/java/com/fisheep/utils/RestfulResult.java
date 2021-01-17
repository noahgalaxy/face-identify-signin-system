package com.fisheep.utils;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import org.omg.CORBA.OBJECT_NOT_EXIST;

import java.util.HashMap;

public class RestfulResult extends HashMap<String, Object> {
    private static final String STATUS = "httpStatus";
    private static final String MSG = "msg";
    private static final String DATA = "data";

    private RestfulResult(){
    }

    private RestfulResult(Builder builder){
        super.put(STATUS, builder.status);
        super.put(MSG, builder.msg);
        super.put(DATA, builder.data);
    }

    public static class Builder{
        private int status;//必选
        private String msg;
        private Object data;

        private Builder(){
        }

        public Builder(int status){
            this.status = status;
        }

        public Builder setMsg(String msg){
            this.msg= msg;
            return this;
        }
        public Builder setData(Object data){
            this.data = data;
            return this;
        }

        public RestfulResult build(){
            return new RestfulResult(this);
        }
    }
}
