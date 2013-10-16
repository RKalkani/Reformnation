package com.kalkani.reformnation;

public class Data {

	private int id = 0;
	private String heading = null;
	
	public Data() {
		this.setId(0);
		this.heading = "";
	}
	
	public Data(int id, String heading)
	{
		this.id = id;
		this.heading = heading;
	}
	
	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
