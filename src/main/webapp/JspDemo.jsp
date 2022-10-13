<%@page import="javax.servlet.annotation.WebServlet"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<table border="1">

	<form action="jsp">
		
			<tr>
				<th><label for="fname">Enter The First Name: </label>
				<td><input type="text" name="name" id="fname"></td>
			</tr>
			<tr>
			<th><label for="usn">Enter The USN: </label>
				<td><input type="text" name="usn" id="usn"></td>
			
			</tr>
			<tr>
			<td>
			<input type="submit">
			</td>
			</tr>
		
	</form>
	</table>
	<%!
	class Demo extends HttpServlet{
		public void service(HttpServletRequest req,HttpServletResponse res){
			String sname=req.getParameter("name");
			String susn=req.getParameter("usn");
			try{
				PrintWriter out=res.getWriter();
				out.println("Student Name: "+sname);
				out.println("Student USN: "+susn);
			}
			catch(Exception e){
				System.out.println(e);
			}
			
		}
	}
	%>
	


</body>
</html>