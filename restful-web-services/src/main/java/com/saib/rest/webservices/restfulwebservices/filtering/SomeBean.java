package com.saib.rest.webservices.restfulwebservices.filtering;

//@JsonIgnoreProperties(value = {"field1", "field2"}) //This is also use while we need to be ignore this field --Static filtering
public class SomeBean {

	private String field1;

	// @JsonIgnore -- This is also use while we need to be ignore this field
	// --Static filtering
	private String field2;

	// @JsonIgnore
	private String field3;

	public SomeBean(String field1, String field2, String field3) {
		super();
		this.field1 = field1;
		this.field2 = field2;
		this.field3 = field3;
	}

	public String getField1() {
		return field1;
	}

	public void setField1(String field1) {
		this.field1 = field1;
	}

	public String getField2() {
		return field2;
	}

	public void setField2(String field2) {
		this.field2 = field2;
	}

	public String getField3() {
		return field3;
	}

	public void setField3(String field3) {
		this.field3 = field3;
	}

}
