package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.HandleIT.*;

public class NonProfitDAO {

	public static boolean passOrFail = false;
	public static ArrayList<NonProfit> soughtNps = new ArrayList<>();
	public static NonProfit whoIsLogingIn = new NonProfit();

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

				NonProfit npForDev = new NonProfit();

				npForDev.setName(resSet.getString("name"));
				npForDev.setPassword(resSet.getString("password"));
				npForDev.setLink(resSet.getString("link"));
				npForDev.setContactPerson(resSet.getString("contact_person"));
				npForDev.setEmailAddress(resSet.getString("email_address"));
				npForDev.setLocation(resSet.getString("location"));
				npForDev.setFocus(resSet.getString("focus"));
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

	public static void writeToNPTable(NonProfit newNPObj) {

		try {
			initConnToDatabase();
			prepStmt = conn.prepareStatement(insertToTable);

			prepStmt.setString(1, newNPObj.getName());
			prepStmt.setString(2, newNPObj.getPassword());
			prepStmt.setString(3, newNPObj.getLink());
			prepStmt.setString(4, newNPObj.getContactPerson());
			prepStmt.setString(5, newNPObj.getEmailAddress());
			prepStmt.setString(6, newNPObj.getLocation());
			prepStmt.setString(7, newNPObj.getFocus());
			prepStmt.setString(8, newNPObj.getProjectType());
			prepStmt.setString(9, newNPObj.getProjectDescription());

			prepStmt.executeUpdate();
			passOrFail = true;

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	public static boolean npLoginSearch(NonProfit loginNP) {

		String email = loginNP.getEmailAddress();
		String password = loginNP.getPassword();

		try {

			initConnToDatabase();
			stmt = conn.createStatement();
			resSet = stmt.executeQuery("SELECT * FROM `handleitdb`.`nonprofittable` where `email_address` like '"
					+ email + "' and `password` like '" + password + "';");

			while (resSet.next()) {

				NonProfit npForLogin = new NonProfit();

				npForLogin.setName(resSet.getString("name"));
				npForLogin.setPassword(resSet.getString("password"));
				npForLogin.setLink(resSet.getString("link"));
				npForLogin.setContactPerson(resSet.getString("contact_person"));
				npForLogin.setEmailAddress(resSet.getString("email_address"));
				npForLogin.setLocation(resSet.getString("location"));
				npForLogin.setFocus(resSet.getString("focus"));
				npForLogin.setProjectType(resSet.getString("project_type"));
				npForLogin.setProjectDescription(resSet.getString("project_description"));

				whoIsLogingIn = npForLogin;

				return true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return false;
	}

	private static String insertToTable = "INSERT INTO `handleitdb`.`nonprofittable` "
			+ "(`name`, `password`, `link`, `contact_person`, `email_address`, `location`, `focus`, `project_type`, `project_description`)"
			+ " VALUES " + "(?,?,?,?,?,?,?,?,?)";

	private static String whichStmt(String projectType, String focus) {

		if (projectType.equalsIgnoreCase("*") && focus.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.nonprofittable;";

		} else if (projectType.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.nonprofittable WHERE `focus` LIKE '%" + focus + "%';";

		} else if (focus.equalsIgnoreCase("*")) {
			return "SELECT * FROM handleitdb.nonprofittable WHERE `project_type` LIKE '%" + projectType + "%';";
		}
		return "SELECT * FROM handleitdb.nonprofittable WHERE `focus` LIKE '%" + focus + "%' AND `project_type` LIKE '%"
				+ projectType + "%';";

	}
}
