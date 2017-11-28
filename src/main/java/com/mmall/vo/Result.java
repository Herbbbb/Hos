package com.mmall.vo;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;

/**
 * Created by Herb on 2017/11/28.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Result implements Serializable {
    private int status;
    private int data;
    private String msg;

    public Result() {
    }

    public Result(int status, int data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
