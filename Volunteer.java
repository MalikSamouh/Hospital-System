package hospital;

class Volunteer extends Employee {

	public Volunteer(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
	}

	public double getSalary() {
		return salary;
	}

	protected void setSalary(double salary) {

	}

	public int getID() {
		return employeeID;
	}

	@Override
	public String toString() {
		return "Volunteer [[" + id + ",[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", " + address
				+ "]]]";
	}

}