package hotelManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import javassist.bytecode.Mnemonic;

public class MainClass {

	public void menuPrint() {
		System.out.println();
		System.out.println("----------------------------------");
		System.out.println("WELCOME TO HOTEL MANAGEMENT SYSTEM");
		System.out.println("----------------------------------");
		System.out.println("1 -> MENU  \n2 -> ORDER \n3 -> PRICE \n4 -> EXIT");
		System.out.println("----------------------------------");
		System.out.println();

	}

	public void hotelmenu() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from menu");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + " rupees");
			}

			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {

		int menuKey, menuKey1 = 0, quantityKey = 0;

		Scanner scanner = new Scanner(System.in);
		MainClass mainclass = new MainClass();

		mainclass.menuPrint();

		System.out.print("YOUR CHOICE PLEASE : ");
		menuKey = scanner.nextInt();
		if (menuKey == 1) {
			mainclass.hotelmenu();
			mainclass.menuPrint();
			System.out.print("YOUR CHOICE PLEASE : ");
			System.out.println();
			menuKey = scanner.nextInt();
		}
		if (menuKey == 2) {

			System.out.print("PLEASE SELECT ITEM FROM MENU WITH ID ");
			System.out.println("ORDER ID : ");
			menuKey1 = scanner.nextInt();
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from menu WHERE DISH_ID = " + menuKey1);
				while (rs.next())
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3) + "rupees only");
				var order = rs;
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}
			System.out.print("PLEASE ENTER QUANTITY : ");
			quantityKey = scanner.nextInt();
			var quantity = quantityKey;
			System.out.println();
			System.out.println("THANK YOU");
			System.out.println("*****ORDER SUCCESFULLY PLACED*****");
			System.out.println("NOTE* : PLEASE CHECK YOUR TOTAL AMOUNT IN PRICE");
			System.out.println();
			mainclass.menuPrint();
			System.out.print("YOUR CHOICE PLEASE : ");
			menuKey = scanner.nextInt();
		}

		if (menuKey == 3) {

			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmenu", "root", "");
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select * from menu WHERE DISH_ID = " + menuKey1);
				while (rs.next()) {
					System.out.print("YOUR SELECTD ITEM : ");
					System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getInt(3));
					System.out.println("TOTAL AMOUNT : " + quantityKey * rs.getInt(3) + "rupees only");
				}
				con.close();
			} catch (Exception e) {
				System.out.println(e);
			}

			mainclass.menuPrint();
			System.out.print("YOUR CHOICE PLEASE : ");
			menuKey = scanner.nextInt();
		}

		if (menuKey == 4) {
			System.out.println();
			System.out.println("**********************************************");
			System.out.println("THANK YOU FOR VISITING HOTEL MANAGEMENT SYSTEM");
			System.out.println("***************VISIT AGAIN********************");
			System.out.println("**********************************************");
		}
	}
}
