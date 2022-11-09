package hospital;

class NoSpaceException extends Exception {
	public NoSpaceException(String errorMsg) {
		super(errorMsg);
	}
}