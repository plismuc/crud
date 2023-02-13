package com.entity;

/**
 * 统一返回值
 * (是不是成功,状态码, “字符长显示的操作”, 返回值  )
 * (是不是成功,状态码, “字符长显示的操作”, 没有返回值  )
 * delete(true,”40000”,”删除成功”)
 * add(true，”400001”,”增加成功”,  数据)
 */
public class Result {
    private boolean flag;
    private Integer code;
    private String  message;
    private Object data;

    //没有返回值
    public Result(boolean flag, Integer code, String message) {
        this.flag = flag;
        this.code = code;
        this.message = message;
    }
    //没有返回值
    public Result(boolean flag, Integer code, String message, Object data) {
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }
    public Result(){}

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
