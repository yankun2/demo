package com.example.demo.bean;


import java.io.Serializable;

/**
* @Description: 返回实体类
* @author wangshun
* @date 2018-08-13 16:12
*/
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private boolean status = false;

    private String message;

    private long total;

    private T result;

    private String statusCode;

/*    public static Result error(ErrorCodeConstants constants){
        return new Result(constants.getErrorMessage(),null,constants.getErrorCode());
    }*/
    public static Result error(String message){
        return new Result(message,null,null);
    }
    public static <T> Result<T>  success(T data){
        return new Result<>(true,0,"操作成功",data,"SYS000");
    }
    public static <T> Result<T>  success(T data,long total){
        return new Result<>(true,total,"操作成功",data,"SYS000");
    }
    public static <T> Result<T>  success(T data ,String message){
        return new Result<>(true,0,message,data,"SYS000");
    }
    public Result() {
        super();
    }

    public Result(String message, T result, String statusCode) {
        this.message = message;
        this.result = result;
        this.statusCode = statusCode;
    }

    public Result(boolean success, long total, String message, T result, String statusCode) {
        this.status = success;
        this.total = total;
        this.message = message;
        this.result = result;
        this.statusCode = statusCode;
    }
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
