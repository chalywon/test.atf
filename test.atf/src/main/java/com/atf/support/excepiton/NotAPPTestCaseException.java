package com.atf.support.excepiton;

/**
 * @author charlse
 * @version
 * @time 2017年3月21日 下午6:51:57
 * @desption
 */
public class NotAPPTestCaseException extends Exception {

	public NotAPPTestCaseException() {
		super();
	}

	public NotAPPTestCaseException(String message) {
		super(message);
	}

	public NotAPPTestCaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public NotAPPTestCaseException(Throwable cause) {
		super(cause);
	}

}
