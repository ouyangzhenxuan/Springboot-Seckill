package com.miaosha.error;

/**
 * @ClassName BusinessException
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-09 18:44
 * @Version 1.0
 **/


// wrapper business error
public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;

    // 直接接收EmBusinessError的传参用于构造业务异常
    public BusinessException(CommonError commonError){
        super();
        this.commonError = commonError;
    }

    //接收自定义errMsg的方式构造业务异常
    public BusinessException(CommonError commonError, String errMsg){
        super();
        this.commonError = commonError;
        this.commonError.setErrMsg(errMsg);

    }

    @Override
    public int getErrCode() {
        return this.commonError.getErrCode();
    }

    @Override
    public String getErrMsg() {
        return this.commonError.getErrMsg();
    }

    @Override
    public CommonError setErrMsg(String errMsg) {
        this.commonError.setErrMsg(errMsg);
        return this;
    }
}
