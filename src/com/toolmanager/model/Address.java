package com.toolmanager.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Address {
	@Id
	@GeneratedValue
	@Column(name="id_address")		
	private Long id_address;
	@Column(name="street")
	private String street;
	@Column(name="complement")
	private String complement;
	@Column(name="region")
	private String region;
	@Column(name="zipcode")
	private String zipcode;
	// Country - State - City: refractory this field for others tables
	@Column(name="country")
	private String country;
	@Column(name="state")
	private String state;
	@Column(name="city")
	private String city;
		
	public Address(){}
	/**
	 * @param street
	 * @param complement
	 * @param region
	 * @param zipcode
	 * @param country
	 * @param state
	 * @param city
	 */
	public Address(String street, String complement, String region,
			String zipcode, String country, String state, String city) {
		super();
		this.street = street;
		this.complement = complement;
		this.region = region;
		this.zipcode = zipcode;
		this.country = country;
		this.state = state;
		this.city = city;
	}
	public Long getId_address() {
		return id_address;
	}
	public void setId_address(Long id_address) {
		this.id_address = id_address;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Address [id_address=" + id_address + ", street=" + street
				+ ", complement=" + complement + ", region=" + region
				+ ", zipcode=" + zipcode + ", country=" + country + ", state="
				+ state + ", city=" + city + "]";
	}
}
