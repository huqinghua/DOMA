package com.github.hqh.mgm.common.response;

import java.io.Serializable;

import com.github.hqh.mgm.common.exception.MgmErrorCode;

/**
 * @Description:
 * @author huqinghua
 */
public class GenericBaseResponse implements Serializable {

    private static final long serialVersionUID = 75098234684L;

    /**
     * 结果码
     */
    private String ret = "0";
    /**
     * 结果描述
     */
    private String msg = "";

    /**
     * 默认构造
     */
    public GenericBaseResponse() {
    }

    /**
     * 带错误码构造
     *
     * @param error
     */
    public GenericBaseResponse(MgmErrorCode error) {
        this.setRet(error.getErrorCode());
        this.setMsg(error.getErrorMsg());
    }

    public String getRet() {
        return ret;
    }

    public void setRet(String ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseResponse [resultCode=" + ret + ", resultMsg=" + msg + "]";
    }

}
