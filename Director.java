package hospital;

import java.util.ArrayList;

class Director extends Administrator {
	protected ArrayList<PhysicianAdministrator> adminList;

	public Director(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
		this.adminList = new ArrayList<>();
	}

	public boolean assignAdministrator(PhysicianAdministrator admin) {
		if (adminList.size() < 3)
			return adminList.add(admin);
		else
			return false;
	}

	public ArrayList<PhysicianAdministrator> extractPhysicianAdmins() {
		return adminList;
	}

	@Override
	public String toString() {
		return "Director [[[" + id + ",[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", " + address
				+ "]], " + salary + "], " + type + "]";
	}
}