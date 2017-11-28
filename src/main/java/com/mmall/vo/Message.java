package com.mmall.vo;

import org.codehaus.jackson.map.annotate.JsonSerialize;
import java.io.Serializable;

/**
 * Created by Herb on 2017/11/28.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Message implements Serializable {
    private int status;
    private Data data;
    private String msg;

    public Message() {
    }

    public Message(int status, Data data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
