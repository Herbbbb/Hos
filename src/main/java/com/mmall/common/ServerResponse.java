package com.mmall.common;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Created by Herb on 2017/11/28.
 */
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class ServerResponse<T> implements Serializable{
    private int status;
    private T data;
    private String msg;

    //编写一个状态枚举类
    @JsonIgnore
    //注解作用：下面这个方法的返回值会被序列化之后放入json数据中
    //通过添加@JsonIgore注解，该属性将不会在json序列化结果中出现
    public boolean isSuccess(){
        return this.status == ResponseCode.SUCCESS.getCode();
    }

    public ServerResponse() {
    }

    private ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    private ServerResponse(int status) {
        this.status = status;
    }

    private ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private ServerResponse(int status, String msg) {
        this.msg = msg;
        this.status = status;
    }

    private ServerResponse(T data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    //返回对象属性值
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    //运行成功，提供四种公有的重载方法
    public static<T> ServerResponse<T> createSuccessResponse(){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }
    public static<T> ServerResponse<T> createSuccessResponse(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }
    public static<T> ServerResponse<T> createSuccessMessageResponse(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }
    public static<T> ServerResponse<T> createSuccessResponse(String msg, T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }
    public static ServerResponse createSuccessMessageResponse(String msg, Integer id){
        return new ServerResponse(ResponseCode.SUCCESS.getCode(),msg,id);
    }
    //运行失败，提供四种公有的重载方法
    public static<T> ServerResponse<T> createErrorResponse(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode());
    }
    public static<T> ServerResponse<T> createErrorResponse(String msg){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg);
    }
    public static<T> ServerResponse<T> createErrorMessageResponse(T data){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),data);
    }
    public static<T> ServerResponse<T> createErrorResponse(String msg, T data){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),msg,data);
    }
    //其他返回类型
    public static<T> ServerResponse<T> createErrorCodeMsg(int errCode, String errMsg){
        return new ServerResponse<T>(errCode,errMsg);
    }

    @Override
    public String toString() {
        return "ServerResponse{" +
                "status=" + status +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
