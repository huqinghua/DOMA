package com.github.hqh.mgm.common.response;

import com.github.hqh.mgm.common.exception.MgmErrorCode;

/**
 * @Description:
 * @author huqinghua
 */
public class GenericResponse<T> extends GenericBaseResponse {

    private static final long serialVersionUID = 8749327984235L;

    private T content;

    public GenericResponse() {
        this(MgmErrorCode.SUCCESS);
    }

    public GenericResponse(MgmErrorCode errorCode) {
        super(errorCode);
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }
}
