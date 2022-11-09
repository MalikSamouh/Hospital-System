package hospital;

import java.util.ArrayList;

class Physician extends SalariedEmployee {
	protected ArrayList<Patient> physicianPatientList;
	protected ArrayList<Volunteer> physicianVolunteerList;
	protected int volunteerCounter;
	protected int patientCounter;

	public Physician(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
		this.physicianPatientList = new ArrayList<>();
		this.physicianVolunteerList = new ArrayList<>();
		this.patientCounter = 0;
		this.volunteerCounter = 0;
	}

	protected void setSpecialty(String type) {
		if (type.equals("Immunology") || type.equals("Dermatology") || type.equals("Neurology"))
			this.type = type;
		else
			throw new IllegalArgumentException("Invaild specialty");
	}

	public String getSpecialty() {
		return type;
	}

	protected ArrayList<Patient> extractPatientDetail() {
		return physicianPatientList;
	}

	protected ArrayList<Volunteer> extractValunterDetail() {
		return physicianVolunteerList;
	}

	protected boolean assignVolunteer(Volunteer v) {
		if (physicianVolunteerList.size() < 5) {
			volunteerCounter++;
			return physicianVolunteerList.add(v);
		} else
			return false;
	}

	protected boolean hasMaxVolunteers() {
		if (volunteerCounter == 5)
			return true;
		else
			return false;
	}

	protected boolean hasMaximumpatient() {
		if (patientCounter == 8)
			return true;
		else
			return false;
	}

	@Override
	public String toString() {
		return "Physician [[[" + id + ",[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", " + address
				+ "]], " + salary + "]]";
	}

}