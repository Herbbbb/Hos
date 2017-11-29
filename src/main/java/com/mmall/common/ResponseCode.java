package com.mmall.common;

/**
 * Created by Herb on 2017/11/29.
 */
public enum ResponseCode {

    SUCCESS(0,"SUCCESS"),
    ERROR(1,"ERROR"),
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT"),
    NEED_LOGIN(10,"NEED_LOGIN");
    //后续还可能有别的CODE码

    private final int code;
    private final String desc;
    ResponseCode(int code, String desc) {

        this.desc = desc;
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public String getDesc(){
        return this.desc;
    }
}
