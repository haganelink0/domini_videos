package com.videosdata;

public class NullError extends Exception {
	
	private static final long serialVersionUID = 1L;

	public NullError() {
		
	}
	
	public NullError( String msg) {
		super(msg);
	}

}
