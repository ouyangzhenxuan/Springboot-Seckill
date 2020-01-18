package com.miaosha.error;

public enum EmBusinessError implements CommonError {

    // universal error type 10001
    PARAMETER_VALIDATION_ERROR(10001, "Parameter not validated"),
    UNKNOWN_ERROR(10002, "Error unknown"),

    // begin with 20000 --> user info error related
    USER_NOT_EXIST(20001, "User not exist"),
    USER_LOGIN_FAIL(20002, "Login Fail"),
    USER_NOT_LOGIN(20003, "User not Login"),
    // begin with 30000 --> transaction failure
    STOCK_NOT_ENOUGH(30001, "Stock Not Enough")

    ;

    private EmBusinessError(int errCode, String errMsg){
        this.errCode = errCode;
        this.errMsg = errMsg;
    }

    private int errCode;
    private String errMsg;



    @Override
    public int getErrCode() {
        return this.errCode;
    }

    @Override
    public String getErrMsg() {
        return this.errMsg;
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.errMsg = errMsg;
        return this;
    }
}
