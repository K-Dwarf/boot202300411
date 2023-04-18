package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub12")
public class Controller12 {

	@Value("${spring.datasource.url}")
	private String url;

	@Value("${spring.datasource.username}")
	private String name;

	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() {
		String sql = """
				SELECT LastName FROM Employees
				""";

		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {
			while (rs.next()) {
				String a = rs.getString("lastName");
				System.out.println(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link2")
	public void method2(Model model) {
		String sql = """
				SELECT ShipperName FROM Shippers;
				""";

		List<String> list = new ArrayList<>();

		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {
			while (rs.next()) {
				String a = rs.getString("ShipperName");
				System.out.println(a);

				list.add(a);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("ship", list);

	}

	@RequestMapping("link3")
	public void method3() {
		String sql = """

				SELECT * FROM Customers;
				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {
			rs.next();
			System.out.println(rs.getString("customerName"));
			System.out.println(rs.getString("contactName"));
			System.out.println(rs.getString("country"));
			rs.next();
			System.out.println(rs.getString("customerName"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link4")
	public void method4() {

		String Name = "";
		int ID = 0;

		String sql = """

				SELECT * FROM Customers

				WHERE CustomerID <= 4
				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {

			while (rs.next()) {
				Name = rs.getString("CustomerName");
				ID = rs.getInt("CustomerID");
				System.out.println(Name);
				System.out.println(ID);

				// ResultSet의 get은 각 컬럼에 번호를 메겨놓는다
				System.out.println(rs.getInt(1));//
				System.out.println(rs.getString(2));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link5")
	public void method5(Model model) {
		String sql = """
				SELECT LastName,FirstName
				FROM Employees
				WHERE EmployeeID < 4
				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {
			while (rs.next()) {
				String lastName = rs.getString("LastName");
				String firstName = rs.getString("FirstName");

				System.out.println(lastName + "," + firstName);

				model.addAttribute("fn", firstName); // list 가 아닌 단일변수로 while 문이 돌때마다 다음값으로 덮여씌워짐
				model.addAttribute("ln", lastName); // list 객체를 만들어서 저장하고 넣어야함
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link6")
	public void method6() {
		// 고객테이블 조회 쿼리 작성
		// 나머지 코드들도 완성

		String sql = """
				SELECT CustomerID,CustomerName,Country
				FROM Customers
				WHERE Country = 'USA'

				""";
		try (Connection con = DriverManager.getConnection(url, name, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);

		) {

			while (rs.next()) {
				int customerId = rs.getInt(1);
				String customerName = rs.getString(2);
				String country = rs.getString(3);
				System.out.println(customerId + ", " + customerName + ", " + country);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
