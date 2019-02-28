package com.yatop.lambda.manager.exception;

public class InternalServerException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2131137554930451609L;

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 */
	public InternalServerException(String errorMessage, String frontEndMessage) {
		super(errorMessage, frontEndMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param cause
	 */
	public InternalServerException(String errorMessage, Throwable cause) {
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
	public InternalServerException(String errorMessage, String frontEndMessage, Throwable cause) {
		super(errorMessage, frontEndMessage, cause);
	}

	/**
	 * 
	 * @param cause
	 */
	public InternalServerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorMessage
	 *            异常信息，系统日志;
	 */
	public InternalServerException(String errorMessage) {
		super(errorMessage);
	}
}
