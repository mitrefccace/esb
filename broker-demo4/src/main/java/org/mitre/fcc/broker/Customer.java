package org.mitre.fcc.broker;

import java.util.Date;

import org.apache.camel.dataformat.bindy.annotation.CsvRecord;
import org.apache.camel.dataformat.bindy.annotation.DataField;

@CsvRecord(separator = ",", skipFirstLine = true)
public class Customer {

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", isAlive=" + isAlive + ", birthDate="
				+ birthDate + ", streetAddress=" + streetAddress + ", cityAddress=" + cityAddress + ", stateAddress="
				+ stateAddress + ", postalCodeAddress=" + postalCodeAddress + ", phoneType=" + phoneType
				+ ", phoneNumber=" + phoneNumber + "]";
	}

	@DataField(pos = 1)
    private String firstName;
 
    @DataField(pos = 2)
    private String lastName;
    
    @DataField(pos = 3)
    private boolean isAlive;
    
    @DataField(pos = 4, pattern = "dd-MM-yyyy")
    private Date birthDate;

    @DataField(pos = 5)
    private String streetAddress;
    
    @DataField(pos = 6)
    private String cityAddress;
    
    @DataField(pos = 7)
    private String stateAddress;
    
    @DataField(pos = 8)
    private String postalCodeAddress;
   
    @DataField(pos = 9)
    private String phoneType;
    
    @DataField(pos = 10)
    private String phoneNumber;  //TODO:  Should we use a pattern for validation?

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

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCityAddress() {
		return cityAddress;
	}

	public void setCityAddress(String cityAddress) {
		this.cityAddress = cityAddress;
	}

	public String getStateAddress() {
		return stateAddress;
	}

	public void setStateAddress(String stateAddress) {
		this.stateAddress = stateAddress;
	}

	public String getPostalCodeAddress() {
		return postalCodeAddress;
	}

	public void setPostalCodeAddress(String postalCodeAddress) {
		this.postalCodeAddress = postalCodeAddress;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
}

