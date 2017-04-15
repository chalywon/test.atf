package com.atf.support.excepiton;

/**
 * @author charlse
 * @version
 * @time 2017年3月21日 下午6:51:57
 * @desption
 */
public class NotAPITestCaseException extends Exception {

	public NotAPITestCaseException() {
		super();
	}

	public NotAPITestCaseException(String message) {
		super(message);
	}

	public NotAPITestCaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotAPITestCaseException(Throwable cause) {
		super(cause);
	}

}
