package com.sks;

import java.io.IOException;
import com.sks.*;
import java.sql.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.GenericServlet;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import org.eclipse.jdt.internal.compiler.batch.Main;
@WebServlet("/log")
public class LogInJava extends GenericServlet{
	
	public void service(ServletRequest req,ServletResponse res) throws IOException{
		String first_name = req.getParameter("firstname");
		String last_name =req.getParameter("lastname");
		String usn=req.getParameter("usn");
		String pass=req.getParameter("pass");
		String gender=req.getParameter("gen");
		String lang=req.getParameter("lang");
		PrintWriter out=res.getWriter();
		out.println("Form Successfully Created\n");
		out.println("Student First Name: "+first_name);
		out.println("Student Last Name: "+last_name);
		out.println("Student USN: "+usn);
		out.println("Student Gender: "+gender);
		out.println("Selected Programming Language: "+lang);
		try {
			Connection cn=DataBase.Databasecon();
			PreparedStatement ps=cn.prepareStatement("insert into Login_info values(?,?,?,?,?,?)");
			ps.setString(1, first_name);
			ps.setString(2, last_name);
			ps.setString(3, usn);
			ps.setString(4, pass);
			ps.setString(5, gender);
			ps.setString(6, lang);
			int count =ps.executeUpdate();
			System.out.println("Number of rows afftected: "+count);
			cn.close();
			ps.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}

//		public static void main(String[] args)throws Exception {
//			
//			LogInJava jv=new LogInJava();
//			jv.service(null, null);
//				Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Sumanth$23");
//				PreparedStatement ps=cn.prepareStatement("insert into Login_info values(?,?,?,?,?)");
//				
//				ps.setString(1, first_name);
//				ps.setString(2, last_name);
//				ps.setString(3, usn);
//				ps.setString(4, pass);
//				ps.setString(5, gender);
//				ps.setString(6, lang);
//				int count =ps.executeUpdate();
//				System.out.println("Number of rows afftected: "+count);
//				cn.close();
//				ps.close();
//				
//			
//		}
		
		
		
		
		
	
//	public static void putdata(String fn,String ln,String usn,String gen,String pas,String lan)throws Exception {
//		Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Student","root","Sumanth$23");
//		PreparedStatement ps=cn.prepareStatement("insert into Login_info values(?,?,?,?,?)");
//		ps.setString(1, fn);
//		ps.setString(2, ln);
//		ps.setString(3, usn);
//		ps.setString(4, pas);
//		ps.setString(5, gen);
//		ps.setString(6, lan);
//		int count =ps.executeUpdate();
//		System.out.println("Number of rows afftected: "+count);
//		cn.close();
//		ps.close();
//		
//	}
	
	

}
