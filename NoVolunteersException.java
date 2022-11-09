package hospital;

class NoVolunteersException extends Exception {
	public NoVolunteersException(String errorMsg) {
		super(errorMsg);
	}
}