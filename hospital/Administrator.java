package hospital;

class Administrator extends SalariedEmployee {
	public Administrator(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
	}

	protected void setAdminSpecialtyType(String type) {
		if (type.equals("Immunology") || type.equals("Dermatology") || type.equals("Neurology"))
			this.type = type;
		else
			throw new IllegalArgumentException("Invaild specialty");
	}

	public String toString() {
		return "Administrator [[[" + id + ",[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", "
				+ address + "]], " + salary + "], " + type + "]";
	}

}