package com.yatop.lambda.manager.exception;

public class ResourceNotFoundException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5085872417533990395L;

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 */
	public ResourceNotFoundException(String errorMessage, String frontEndMessage) {
		super(errorMessage, frontEndMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param cause
	 */
	public ResourceNotFoundException(String errorMessage, Throwable cause) {
		super(errorMessage, cause);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 * @param cause
	 */
	public ResourceNotFoundException(String errorMessage, String frontEndMessage, Throwable cause) {
		super(errorMessage, frontEndMessage, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public ResourceNotFoundException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * @param errorMessage
	 *            异常信息，系统日志;
	 */
	public ResourceNotFoundException(String errorMessage) {
		super(errorMessage);
	}
}
