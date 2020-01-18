package com.miaosha.validator;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ValidationResult
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-16 12:56
 * @Version 1.0
 **/

public class ValidationResult {
    // validation result true or false
    private boolean hasErrors = false;

    // save the result of error message
    private Map<String, String> errMsgMap = new HashMap<>();

    // format the error message and return it
    public String getErrorMsg(){
        return StringUtils.join(errMsgMap.values().toArray(), ",");
    }

    public boolean isHasErrors() {
        return hasErrors;
    }

    public void setHasErrors(boolean hasErrors) {
        this.hasErrors = hasErrors;
    }

    public Map<String, String> getErrMsgMap() {
        return errMsgMap;
    }

    public void setErrMsgMap(Map<String, String> errMsgMap) {
        this.errMsgMap = errMsgMap;
    }
}
