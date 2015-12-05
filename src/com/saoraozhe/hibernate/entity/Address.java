package com.saoraozhe.hibernate.entity;

public class Address{
	
	private int postcode;
	private String address = "some where";
	
	public Address(){
		
	}

	public Address(int postcode, String address) {
		this.postcode = postcode;
		this.address = address;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Address [postcode=" + postcode + ", address=" + address + "]";
	}
	
}
