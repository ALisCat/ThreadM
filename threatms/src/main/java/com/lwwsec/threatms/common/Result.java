package com.lwwsec.threatms.common;

import lombok.Data;

/**
 * 统一使用result类返回结果给前端
 * @param <T>
 */
@Data
public class Result<T> {
    private String code;
    private String msg;
    private T data;

    public static Result success(){
        Result result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        return result;
    }
    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.setCode("0");
        result.setMsg("success");
        result.setData(data);
        return result;
    }
    public static Result error(String code,String msg){
        Result result = new Result<>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
