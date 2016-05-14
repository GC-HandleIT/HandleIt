package com.servletpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.HandleIT.DevObj;

public class DevConn {

	static boolean passOrFail = false;
	public static ArrayList<DevObj> soughtDevs = new ArrayList<>();
	public static DevObj whoIsLogingIn = new DevObj();

	static final String JBDC_DRIVER = "com.mysql.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/?user=root?autoReconnect=true&useSSL=false";
	static final String USER = "root";
	static final String PASSWORD = "sesame";

	public static Connection conn = null;
	public static Statement stmt = null;
	public static PreparedStatement prepStmt = null;
	public static ResultSet resSet = null;

	public static void initConnToDatabase() {

		try {
			Class.forName(JBDC_DRIVER);

			System.out.println("Connecting to the Database");
			conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			System.out.println("Connected to the Database");
			System.out.println("Dev Side");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	public static boolean searchForADev(String projectType, String skills) {

		String formatStmt = whichStmt(projectType, skills);

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery(formatStmt);

			while (resSet.next()) {

				DevObj devForNP = new DevObj();

				devForNP.setId(resSet.getString("id"));
				devForNP.setFirstName(resSet.getString("first_name"));
				devForNP.setLastName(resSet.getString("last_name"));
				devForNP.setPassword(resSet.getString("password"));
				devForNP.setEmailAddress(resSet.getString("email_address"));
				devForNP.setLocation(resSet.getString("location"));
				devForNP.setPicUrl(resSet.getString("picture_url"));
				devForNP.setProfileUrl(resSet.getString("public_profile_url"));
				devForNP.setProjects(resSet.getString("projects"));
				devForNP.setSkills(resSet.getString("skills"));

				soughtDevs.add(devForNP);
			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return false;

	}

	public static void writeToDevTable(DevObj newDevObj) {

		try {
			initConnToDatabase();
			prepStmt = conn.prepareStatement(insertToTable);

			prepStmt.setString(1, newDevObj.getId());
			prepStmt.setString(2, newDevObj.getFirstName());
			prepStmt.setString(3, newDevObj.getLastName());
			prepStmt.setString(4, newDevObj.getPassword());
			prepStmt.setString(5, newDevObj.getEmailAddress());
			prepStmt.setString(6, newDevObj.getLocation());
			prepStmt.setString(7, newDevObj.getPicUrl());
			prepStmt.setString(8, newDevObj.getProfileUrl());
			prepStmt.setString(9, newDevObj.getProjects());
			prepStmt.setString(10, newDevObj.getSkills());

			prepStmt.executeUpdate();

			passOrFail = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static boolean devLoginSearch(DevObj loginDev) {

		String email = loginDev.getEmailAddress();
		String password = loginDev.getPassword();

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `handleitdb`.`devtable` where `email_address` like '" + email
					+ "' and `password` like '" + password + "';");

			while (resSet.next()) {

				DevObj devForLogin = new DevObj();

				devForLogin.setId(resSet.getString("id"));
				devForLogin.setFirstName(resSet.getString("first_name"));
				devForLogin.setLastName(resSet.getString("last_name"));
				devForLogin.setPassword(resSet.getString("password"));
				devForLogin.setEmailAddress(resSet.getString("email_address"));
				devForLogin.setLocation(resSet.getString("location"));
				devForLogin.setPicUrl(resSet.getString("picture_url"));
				devForLogin.setProfileUrl(resSet.getString("public_profile_url"));
				devForLogin.setProjects(resSet.getString("projects"));
				devForLogin.setSkills(resSet.getString("skills"));

				whoIsLogingIn = devForLogin;

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	private static String insertToTable = "INSERT INTO `handleitdb`.`devtable` "
			+ "(`id`, `first_name`, `last_name`, `password`, `email_address`, `location`, `picture_url`, `public_profile_url`, `projects`, `skills`)"
			+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";

	private static String whichStmt(String projectType, String skills) {

		if (projectType.equalsIgnoreCase("*") && skills.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.devtable;";

		} else if (projectType.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.devtable WHERE `skills` LIKE '" + skills + ";";

		} else if (skills.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.devtable WHERE `projects` LIKE '" + projectType + ";";
		}
		return "SELECT * FROM handleitdb.devtable WHERE `projects` LIKE '" + projectType + "' AND `skills` LIKE '"
				+ projectType + ";";

	}

}
