<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.chainsys.model.UserInfo" %>
<%@ page import="com.chainsys.model.BankAccountInfo" %>
<%@ page import="com.chainsys.dao.ServerManager" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Profile</title>
</head>
<body>
	
	<% HttpSession id = request.getSession(); 
		int userId = (int) id.getAttribute("userid");
		ServerManager server = new ServerManager();
		ArrayList<UserInfo> arrList = server.readUserDetails(userId);
		for (UserInfo user : arrList) {
	%>
	
    <h2>User Details</h2>
   <form method="post" action="processFormData.jsp">
        <label for="firstName">First Name: <%= user.getFirstName()  %> </label>
        
        <label for="lastName">Last Name: <%= user.getLastName() %> </label>
        
        
        <label for="email">Email: <%= user.getEmail() %> </label>
       <%
		}
		%>
		
		<% ArrayList<BankAccountInfo> arrList1 = server.readAccountDetails(userId);
			for (BankAccountInfo user : arrList1) { %>
         <label for="dob">Date of Birth:<%= user.getDOB() %> </label>
        
        <label for="accountNumber">Account Number: <%= user.getAccNo() %> </label>
        
        <label for="aadhaarNumber">Aadhaar Number: <%= user.getAadharNumber() %> </label>
        
        <label for="address">Address: <%= user.getAddress() %> </label>
         <%
		}
		%>
        <input type="submit" value="Submit">
    </form> 
</body>
</html>
