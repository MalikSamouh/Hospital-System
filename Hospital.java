package hospital;
import java.util.*;

// Written by Malik Samouh 
// Date: April 25th, 2022


public class Hospital{
	protected Director director; 
	protected Administrator admin;
	protected Physician physician;
	protected Volunteer volunteer;
	protected Patient patient;
	protected PhysicianAdministrator physicianAdmin;
	protected ArrayList<PhysicianAdministrator> hospitalAdminList;
	protected ArrayList<Physician> hospitalPhysicianList;
	protected ArrayList<Patient> hospitalPatientList;
	protected ArrayList<Volunteer> hospitalVolunteerList;

	public Hospital(Director director) {
		this.director = director;
		this.hospitalAdminList = new ArrayList<>();
		this.hospitalPhysicianList = new ArrayList<>();
		this.hospitalPatientList = new ArrayList<>();
		this.hospitalVolunteerList = new ArrayList<>();

	}

	protected Director getHospDirector() {
		return this.director;
	}

	protected boolean addAdministrator(PhysicianAdministrator p) {
		if (hospitalAdminList.size() < 3)
			return hospitalAdminList.add(p);
		else
			return false;
	}

	protected boolean hirePhysician(Physician p) {
		if (hospitalPhysicianList.size() < 70 && !(hospitalPhysicianList.contains(p))) {
			for (int i = 0; i < hospitalAdminList.size(); i++) {
				if (hospitalAdminList.get(i).type.equals(p.type) && hospitalPhysicianList.size() < 25) {
					hospitalAdminList.get(i).adminPhysicianList.add(p);
				}
			}
			return hospitalPhysicianList.add(p);
		} else
			return false;
	}

	protected boolean admitPatient(Patient p) throws NoSpaceException {
		if (hospitalPatientList.size() < (hospitalPhysicianList.size() * 8) && !(hospitalPatientList.contains(p))) {
			hospitalPatientList.add(p);
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianPatientList.size() < 8) {
					hospitalPhysicianList.get(i).physicianPatientList.add(p);
					p.setAssignedPhysician(hospitalPhysicianList.get(i));
					hospitalPhysicianList.get(i).patientCounter++;
					break;
				}
			}
			return true;
		}

		else if (hospitalPatientList.size() > 500 || (hospitalPatientList.size() >= (hospitalPhysicianList.size() * 8)))
			throw new NoSpaceException("");

		else
			return false;

	}

	protected ArrayList<Physician> extractAllPhysicianDetails() {
		return hospitalPhysicianList;
	}

	protected boolean resignPhysician(Physician p) throws NoSpecialtyException {
		if (hospitalPhysicianList.contains(p)) {
			for (int i = 0; i < p.physicianPatientList.size(); i++)
				reAdmitPateint(p.physicianPatientList.get(i));

			for (int i = 0; i < p.physicianVolunteerList.size(); i++)
				reHireVolunteer(p.physicianVolunteerList.get(i));

			p.physicianPatientList.clear();
			p.physicianVolunteerList.clear();
			p.patientCounter = 0;
			p.volunteerCounter = 0;
			return hospitalPhysicianList.remove(p);

		} else
			throw new NoSpecialtyException("");
	}

	protected ArrayList<Patient> extractAllPatientDetails() {
		return hospitalPatientList;
	}

	protected boolean dischargePatient(Patient p) {
		if (hospitalPatientList.contains(p)) {
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianPatientList.contains(p)) {
					hospitalPhysicianList.get(i).physicianPatientList.remove(p);
					hospitalPatientList.remove(p);
					break;
				}
			}
			return true;
		} else
			return false;
	}

	private boolean reAdmitPateint(Patient p) {
		if (hospitalPatientList.size() < (hospitalPhysicianList.size() * 8) && hospitalPatientList.contains(p)) {
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianPatientList.size() < 8) {
					hospitalPhysicianList.get(i).physicianPatientList.add(p);
					break;
				}
			}
			return true;
		} else
			return false;
	}

	private boolean reHireVolunteer(Volunteer v) {
		if (hospitalVolunteerList.size() < (hospitalPhysicianList.size() * 5) && hospitalVolunteerList.contains(v)) {
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianVolunteerList.size() < 5) {
					hospitalPhysicianList.get(i).physicianVolunteerList.add(v);
					break;
				}
			}
			return true;
		} else
			return false;
	}

	protected boolean hireVolunteer(Volunteer v) {
		if (hospitalVolunteerList.size() < (hospitalPhysicianList.size() * 5) && !(hospitalVolunteerList.contains(v))) {
			hospitalVolunteerList.add(v);
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianVolunteerList.size() < 5) {
					hospitalPhysicianList.get(i).physicianVolunteerList.add(v);
					hospitalPhysicianList.get(i).volunteerCounter++;

					break;
				}
			}
			return true;
		}

		else
			return false;

	}

	protected boolean resignVolunteer(Volunteer v) throws NoVolunteersException {
		if (hospitalVolunteerList.contains(v)) {
			for (int i = 0; i < hospitalPhysicianList.size(); i++) {
				if (hospitalPhysicianList.get(i).physicianVolunteerList.contains(v)) {
					hospitalPhysicianList.get(i).physicianVolunteerList.remove(v);
					hospitalVolunteerList.remove(v);
					hospitalPhysicianList.get(i).volunteerCounter--;

					break;
				}
			}
			return true;
		} else
			throw new NoVolunteersException("");
	}

	public ArrayList<Volunteer> extractAllVolunteerDetails() {
		return hospitalVolunteerList;
	}
}