package hospital;

class Employee extends Person {
	protected double salary = 0.0;
	protected static int employeeID = 100;
	protected static int id;

	public Employee(String firstName, String lastName, int age, String gender, String address) {
		super(firstName, lastName, age, gender, address);
		id = employeeID;
		employeeID++;
	}

	protected int getEmployeeID() {
		return id;
	}

}