package com.miaosha.response;

/**
 * @ClassName CommonRetuenType
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-09 18:16
 * @Version 1.0
 **/

public class CommonRetuenType {

    // 表明对应请求的返回结果有success, fail
    private String status;

    // if status = success, then data should return the json data that the front-end needs
    // if status = fail, then data should use the common failure format
    private Object data;

    public static CommonRetuenType create(Object result){
        return CommonRetuenType.create(result, "success");
    }

    public static CommonRetuenType create(Object result, String status){
        CommonRetuenType type = new CommonRetuenType();
        type.setStatus(status);
        type.setData(result);
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
