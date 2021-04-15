
package com.github.hqh.mgm.common.log;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ApiLog {

	/**
	 * 日志描述
	 */
	String value() default "日志记录";
}
