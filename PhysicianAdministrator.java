package hospital;

import java.util.ArrayList;

class PhysicianAdministrator extends Administrator {
	protected ArrayList<Physician> adminPhysicianList;

	public PhysicianAdministrator(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
		this.adminPhysicianList = new ArrayList<>();
	}

	protected ArrayList<Physician> extractPhysician() {
		return adminPhysicianList;
	}

	@Override
	public String toString() {
		return "PysicianAdministrator [[[" + id + ",[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", "
				+ address + "]], " + salary + "], " + type + "]";
	}
}