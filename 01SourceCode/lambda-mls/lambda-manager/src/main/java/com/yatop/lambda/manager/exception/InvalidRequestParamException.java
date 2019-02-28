package com.yatop.lambda.manager.exception;

public class InvalidRequestParamException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7150045527541640844L;

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 */
	public InvalidRequestParamException(String errorMessage, String frontEndMessage) {
		super(errorMessage, frontEndMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param cause
	 */
	public InvalidRequestParamException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 * 						需要前端提醒给客户的信息
	 * @param validationMessage
	 * 						验证错误信息
	 */
	public InvalidRequestParamException(String errorMessage, String frontEndMessage, String validationMessage) {
		super(errorMessage, frontEndMessage, validationMessage);
	}
	
	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 * @param cause
	 */
	public InvalidRequestParamException(String errorMessage, String frontEndMessage, Throwable cause) {
		super(errorMessage, frontEndMessage, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public InvalidRequestParamException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorMessage
	 *            异常信息，系统日志;
	 */
	public InvalidRequestParamException(String errorMessage) {
		super(errorMessage,errorMessage);
	}
}
