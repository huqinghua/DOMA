package com.github.hqh.mgm.common.exception;

import org.apache.commons.lang3.StringUtils;

/**
 * 系统异常错误码
 */
public class MgmException extends RuntimeException {
    private static final long serialVersionUID = 532196574398873L;

    /**
     * 错误枚举
     */
    protected MgmErrorCode error;
    /**
     * 错误描述
     */
    private String errorMsg;

    public MgmException() {
        super();
    }

    public MgmException(MgmErrorCode error) {
        super();
        this.error = error;
    }

    /**
     * 需要展示特殊错误码描述
     *
     * @param error
     * @param errorMsg
     */
    public MgmException(MgmErrorCode error, String errorMsg) {
        super();
        this.errorMsg = errorMsg;
        this.error = error;
    }

    /**
     * 获取错误码
     *
     * @return
     */
    public String getErrorCode() {
        if (this.getError() != null) {
            return this.getError().getErrorCode();
        }
        return null;
    }

    /**
     * 获取错误描述
     *
     * @return
     */
    public String getErrorMsg() {
        if (StringUtils.isNotBlank(errorMsg)) {
            return errorMsg;
        }
        if (this.getError() != null) {
            return this.getError().getErrorMsg();
        }
        return null;
    }

    /**
     * 获取原始错误描述
     *
     * @return
     */
    public String getOriginalErrorMsg() {
        return errorMsg;
    }

    /**
     * @return the error
     */
    public MgmErrorCode getError() {
        return error;
    }

    /**
     * @param error the error to set
     */
    public void setError(MgmErrorCode error) {
        this.error = error;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "error[" + error + "],errorMsg[" + errorMsg + "]";
    }
}
