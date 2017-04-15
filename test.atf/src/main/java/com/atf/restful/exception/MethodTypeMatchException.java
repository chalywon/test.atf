package com.atf.restful.exception;
/**
	*@author charlse
	*@version 
	*@time 2017年3月23日 下午2:33:41
	*@desption
*/
public class MethodTypeMatchException extends Exception {
	
	public MethodTypeMatchException() {
        super();
    }

    public MethodTypeMatchException(String message) {
        super(message);
    }

    public MethodTypeMatchException(String message, Throwable cause) {
        super(message, cause);
    }

    public MethodTypeMatchException(Throwable cause) {
        super(cause);
    }

}
