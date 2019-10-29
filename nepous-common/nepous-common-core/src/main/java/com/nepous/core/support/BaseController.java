
package com.nepous.core.support;

import com.nepous.base.constant.GlobalConstant;
import com.nepous.base.enums.ErrorCodeEnum;
import com.nepous.base.exception.BussinessException;
import com.nepous.dto.LoginAuthDto;
import com.nepous.util.PublicUtil;
import com.nepous.util.ThreadLocalMap;
import com.nepous.util.result.RestResult;
import com.nepous.util.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The class Base controller.
 *
 */
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * Gets login auth dto.
	 *
	 * @return the login auth dto
	 */
	protected LoginAuthDto getLoginAuthDto() {
		LoginAuthDto loginAuthDto = (LoginAuthDto) ThreadLocalMap.get(GlobalConstant.Sys.TOKEN_AUTH_DTO);
		if(PublicUtil.isEmpty(loginAuthDto)) {
			throw new BussinessException(ErrorCodeEnum.UAC10011041);
		}
		return loginAuthDto;
	}

	/**
	 * Handle result Result.
	 *
	 * @param <T>    the type parameter
	 * @param result the result
	 *
	 * @return the Result
	 */
	protected <T> Result<T> handleResult(T result) {
		boolean flag = isFlag(result);

		if (flag) {
			return RestResult.result(Result.SUCCESS_CODE, "操作成功", result);
		} else {
			return RestResult.result(Result.ERROR_CODE, "操作失败", result);
		}
	}

	/**
	 * Handle result Result.
	 *
	 * @param <E>      the type parameter
	 * @param result   the result
	 * @param errorMsg the error msg
	 *
	 * @return the Result
	 */
	protected <E> Result<E> handleResult(E result, String errorMsg) {
		boolean flag = isFlag(result);

		if (flag) {
			return RestResult.result(Result.SUCCESS_CODE, "操作成功", result);
		} else {
			return RestResult.result(Result.ERROR_CODE, errorMsg, result);
		}
	}

	private boolean isFlag(Object result) {
		boolean flag;
		if (result instanceof Integer) {
			flag = (Integer) result > 0;
		} else if (result instanceof Boolean) {
			flag = (Boolean) result;
		} else {
			flag = PublicUtil.isNotEmpty(result);
		}
		return flag;
	}

//	protected long generateId() {
//		return UniqueIdGenerator.getInstance(IncrementIdGenerator.getServiceId()).nextId();
//	}

}
  