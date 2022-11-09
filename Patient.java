package hospital;

class Patient extends Person {
	protected static int PatientID = 1000;
	protected static int pID;
	protected Physician assignedPhysician;

	public Patient(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
		pID = PatientID;
		PatientID++;
	}

	public int getPatientID() {
		return pID;
	}

	protected void setAssignedPhysician(Physician p) {
		this.assignedPhysician = p;
	}

	protected Physician getAssignedPhysician() {
		return assignedPhysician;
	}

	protected boolean clearPatientRecord() {
		if (assignedPhysician == null) {
			return true;
		} else
			return false;

	}

	@Override
	public String toString() {
		return "Patient " + "[" + pID + ", [" + firstName + ", " + lastName + ", " + age + ", " + gender + ", "
				+ address + "]]";
	}

}