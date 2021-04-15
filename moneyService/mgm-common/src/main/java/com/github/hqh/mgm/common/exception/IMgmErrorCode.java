package com.github.hqh.mgm.common.exception;

import java.io.Serializable;

public interface IMgmErrorCode extends Serializable {

	/**
	 * 消息
	 */
	String getErrorMsg();

	/**
	 * 状态码
	 */
	String getErrorCode();

}
