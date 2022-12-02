package com.infinite.JunitDemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployTest {

	@Test
	public void testConstructor() {
		Employ employ1 = new Employ();
		assertNotNull(employ1);
		Employ employ2 = new Employ(1, "kishore", Gender.MALE, "java", "programmer", 88424);
		assertEquals(1, employ2.getEmploy());
		assertEquals("kishore", employ2.getName());
		assertEquals(Gender.MALE, employ2.getGender());
		assertEquals("java", employ2.getDept());
		assertEquals("programmer", employ2.getDesign());
		assertEquals(88424, employ2.getBasic(),0);
	}
	
	@Test
	public void testGettersAndSetters(){
		Employ employ = new Employ();
		employ.setEmploy(1);
		employ.setName("venkatesh");
		employ.setGender(Gender.MALE);
		employ.setDept("java");
		employ.setDesign("programmer");
		employ.setBasic(84834);
		
		
		assertEquals(1, employ.getEmploy());
		assertEquals("venkatesh", employ.getName());
		assertEquals(Gender.MALE, employ.getGender());
		assertEquals("java", employ.getDept());
		assertEquals("programmer", employ.getDesign());
		assertEquals(84834, employ.getBasic(),0);
	}
	
	/*@Test
	public String testToString(){
		Employ employ = new Employ();
		
	}*/
}
