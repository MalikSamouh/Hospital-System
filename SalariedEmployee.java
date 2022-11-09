package hospital;

class SalariedEmployee extends Employee {
	protected double salary;
	protected String type;

	public SalariedEmployee(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);

	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	protected void setAdminSpecialtyType(String type) {
		this.type = type;
	}

	protected String getAdminSpecialtyType() {
		return type;
	}
}