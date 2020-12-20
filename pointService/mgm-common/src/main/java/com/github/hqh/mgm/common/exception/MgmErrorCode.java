package com.github.hqh.mgm.common.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * @Description:
 * @author huqinghua
 */

public enum MgmErrorCode {

    SYSTEM_EXCEPTION("SYSTEM_EXCEPTION", "系统异常"),
    SYSTEM_ERROR("SYSTEM_ERROR", "系统错误"),
    FAIL("FAIL", "处理失败"),
    SUCCESS("SUCCESS", "处理成功"),
    NOT_IMPLETMENT("NOT_IMPLETMENT", "未实现"),
    CHECK_PARAMS_ERR("CHECK_PARAMS_ERR", "请求参数有误"),
    PASSWORD_ERROR("PASSWORD_ERROR", "密码错误"),
    POINTS_OVERRUN("POINTS_OVERRUN", "积分超限")
    ;



    private String errorCode;
    private String errorMsg;

    private MgmErrorCode(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public static MgmErrorCode getEnumFromCode(String code) {
        for (MgmErrorCode errorCode : MgmErrorCode.values()) {
            if (StringUtils.equals(errorCode.getErrorCode(), code)) {
                return errorCode;
            }
        }
        return null;
    }
}