package in.hirbernet.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Studentdata {
	@Id
	private int id;
	private String nameString;
	private String addressString;
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Studentdata [id=" + id + ", nameString=" + nameString + ", addressString=" + addressString + ", age="
				+ age + "]";
	}
	
	
}
