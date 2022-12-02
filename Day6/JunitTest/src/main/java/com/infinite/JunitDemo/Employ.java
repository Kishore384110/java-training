package com.infinite.JunitDemo;

public class Employ {
	
	private int employ;
	private String name;
	private Gender gender;
	private String dept;
	private String design;
	private double basic;
	
	@Override
	public String toString() {
		return "Employ [employ=" + employ + ", name=" + name + ", gender=" + gender + ", dept=" + dept + ", design="
				+ design + ", basic=" + basic + "]";
	}

	public Employ(int employ, String name, Gender gender, String dept, String design, double basic) {
		this.employ = employ;
		this.name = name;
		this.gender = gender;
		this.dept = dept;
		this.design = design;
		this.basic = basic;
	}

	public Employ() {
		
	}

	public int getEmploy() {
		return employ;
	}

	public void setEmploy(int employ) {
		this.employ = employ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getDesign() {
		return design;
	}

	public void setDesign(String design) {
		this.design = design;
	}

	public double getBasic() {
		return basic;
	}

	public void setBasic(double basic) {
		this.basic = basic;
	}
	
	

}
