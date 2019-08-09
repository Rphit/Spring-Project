package comm.example.springdemo;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

public class Student {
	
	 @NotNull(message = "field canot be null")
	 @Size(min=1,message="first name required")
	 private String firstName;
	 private String lastName;
	 private String country;
	 private String language;
	 private String operating;
	 
	 private LinkedHashMap<String, String> countries=new LinkedHashMap<String, String>();
	 
	 public Student() {
		super();
		
		countries.put("USA", "united state");
		countries.put("UK", "united Kingdom");
		countries.put("IND", "India");
		countries.put("GERM", "Germany");
		countries.put("USA", "united state");
	}

	public Student(String firstName, String lastName, String country, String language, String operating) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.country = country;
		this.language = language;
		this.operating =operating;
	}

	public String getOperating() {
		return operating;
	}

	public void setOperating(String operating) {
		this.operating = operating;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public LinkedHashMap<String, String> getCountries() {
		return countries;
	}

	public void setCountries(LinkedHashMap<String, String> countries) {
		this.countries = countries;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}
	
	 
	

	 

}
