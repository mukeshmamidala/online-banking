package sunspot.idbi.exception;

public class MobileAlreadyRegistered extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MobileAlreadyRegistered(){
		super("Mobile is already registered");
	}
	
}
