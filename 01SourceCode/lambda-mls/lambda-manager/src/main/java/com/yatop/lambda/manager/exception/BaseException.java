package com.yatop.lambda.manager.exception;

public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5176654175351604586L;

	private String frontEndMessage;
	private String validationMessage;

	/**
	 * 
	 * @param cause
	 */
	public BaseException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param errorMessage
	 *            异常信息，系统日志;
	 */
	public BaseException(String errorMessage) {
		super(errorMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 */
	public BaseException(String errorMessage, String frontEndMessage) {
		super(errorMessage);
		this.frontEndMessage = frontEndMessage;
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 * @param frontEndMessage
	 * 						验证错误信息
	 */
	public BaseException(String errorMessage, String frontEndMessage, String validationMessage) {
		super(errorMessage);
		this.frontEndMessage = frontEndMessage;
		this.validationMessage = validationMessage;
	}
	
	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param cause
	 */
	public BaseException(String errorMessage, Throwable cause) {
		super(errorMessage);
	}

	/**
	 * 
	 * @param errorMessage
	 *            异常信息，系统日志;
	 * @param frontEndMessage
	 *            需要前端提醒给客户的信息
	 * @param cause
	 */
	public BaseException(String errorMessage, String frontEndMessage, Throwable cause) {
		super(errorMessage, cause);
		this.frontEndMessage = frontEndMessage;
	}

	public String getFrontEndMessage() {
		return frontEndMessage;
	}

	public void setFrontEndMessage(String frontEndMessage) {
		this.frontEndMessage = frontEndMessage;
	}
}
