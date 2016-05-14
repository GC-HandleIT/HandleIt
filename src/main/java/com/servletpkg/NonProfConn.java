package com.servletpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.HandleIT.*;

public class NonProfConn {

	static boolean passOrFail = false;
	public static ArrayList<NonProfObj> soughtNps = new ArrayList<>();

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
			System.out.println("NP Side");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println(ex.getMessage());
		}
	}

	public static boolean searchForANP(String projectType, String focus) {

		String formatStmt = whichStmt(projectType, focus);

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery(formatStmt);

			while (resSet.next()) {

				NonProfObj npForDev = new NonProfObj();

				npForDev.setId(resSet.getString("id"));
				npForDev.setName(resSet.getString("name"));
				npForDev.setPassword(resSet.getString("password"));
				npForDev.setLink(resSet.getString("link"));
				npForDev.setContactPerson(resSet.getString("contact_person"));
				npForDev.setEmailAddress(resSet.getString("email_address"));
				npForDev.setFocus(resSet.getString("focus"));
				npForDev.setLocation(resSet.getString("location"));
				npForDev.setProjectType(resSet.getString("project_type"));
				npForDev.setProjectDescription(resSet.getString("project_description"));

				soughtNps.add(npForDev);
			}

			return true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return false;

	}

	public static void writeToNPTable(NonProfObj newNPObj) {

		try {
			initConnToDatabase();
			prepStmt = conn.prepareStatement(insertToTable);

			prepStmt.setString(1, newNPObj.getId());
			prepStmt.setString(2, newNPObj.getName());
			prepStmt.setString(3, newNPObj.getPassword());
			prepStmt.setString(4, newNPObj.getLink());
			prepStmt.setString(5, newNPObj.getContactPerson());
			prepStmt.setString(6, newNPObj.getEmailAddress());
			prepStmt.setString(7, newNPObj.getFocus());
			prepStmt.setString(8, newNPObj.getLocation());
			prepStmt.setString(9, newNPObj.getProjectType());
			prepStmt.setString(10, newNPObj.getProjectDescription());

			prepStmt.executeUpdate();
			passOrFail = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static boolean npLoginSearch(NonProfObj loginNP) {

		String email = loginNP.getEmailAddress();
		String password = loginNP.getPassword();

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `handleitdb`.`nonprofittable` where `email_address` like '"
					+ email + "' and `password` like '" + password + "';");

			while (resSet.next()) {

				NonProfObj npForLogin = new NonProfObj();

				npForLogin.setId(resSet.getString("id"));
				npForLogin.setName(resSet.getString("name"));
				npForLogin.setPassword(resSet.getString("password"));
				npForLogin.setLink(resSet.getString("link"));
				npForLogin.setContactPerson(resSet.getString("contact_person"));
				npForLogin.setEmailAddress(resSet.getString("email_address"));
				npForLogin.setFocus(resSet.getString("focus"));
				npForLogin.setLocation(resSet.getString("location"));
				npForLogin.setProjectType(resSet.getString("project_type"));
				npForLogin.setProjectDescription(resSet.getString("project_description"));

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	private static String insertToTable = "INSERT INTO `handleitdb`.`nonprofittable` "
			+ "(`id`, `name`, `password`, `link`, `contact_person`, `email_address`, `focus`, `location`, `project_type`, `project_description`)"
			+ " VALUES " + "(?,?,?,?,?,?,?,?,?,?)";

	private static String whichStmt(String projectType, String focus) {

		if (projectType.equalsIgnoreCase("*") && focus.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.nonprofittable;";

		} else if (projectType.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.devtable WHERE `skills` LIKE '" + focus + ";";

		} else if (focus.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.devtable WHERE `projects` LIKE '" + projectType + ";";
		}
		return "SELECT * FROM handleitdb.devtable WHERE `projects` LIKE '" + projectType + "' AND `skills` LIKE '"
				+ projectType + ";";

	}
}
