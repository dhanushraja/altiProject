package myApp.exception;

public class NoFlightDetailsFoundException extends Throwable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String msg;
	
	public NoFlightDetailsFoundException() {
		// TODO Auto-generated constructor stub
	}

	public NoFlightDetailsFoundException(String msg) {
		super();
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
