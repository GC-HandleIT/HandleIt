package com.HandleIT;

public class NonProfit {

	private String name;
	private String password;
	private String link;
	private String contactPerson;
	private String emailAddress;
	private String focus;
	private String location;
	private String projectType;
	private String projectDescription;

	public NonProfit(String name, String password, String link, String contactPerson, String emailAddress, String focus,
			String location, String projectType, String projectDescription) {
		super();
		this.name = name;
		this.password = password;
		this.link = link;
		this.contactPerson = contactPerson;
		this.emailAddress = emailAddress;
		this.focus = focus;
		this.location = location;
		this.projectType = projectType;
		this.projectDescription = projectDescription;
	}

	public NonProfit() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getFocus() {
		return focus;
	}

	public void setFocus(String focus) {
		this.focus = focus;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getProjectType() {
		return projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}

}
