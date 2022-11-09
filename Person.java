package hospital;

class Person {
	protected String firstName;
	protected String lastName;
	protected int age;
	protected String gender;
	protected String address;

	public Person(String firstName, String lastName, int age, String gender, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public int getAge() {
		return age;
	}

	public String getGender() {
		return gender;
	}

	public String getAddress() {
		return address;
	}

	protected void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	protected void setLastName(String lastName) {
		this.lastName = lastName;
	}

	protected void setAge(int age) {
		this.age = age;
	}

	protected void setGender(String gender) {
		this.gender = gender;
	}

	protected void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return firstName + ", " + lastName;
	}

	@Override
	public String toString() {
		return "[" + firstName + ", " + lastName + ", " + age + ", " + gender + ", " + address + "]";
	}

}