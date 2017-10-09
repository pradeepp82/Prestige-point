<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login</title>
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="fonts/font-class.css" media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<style>
.lg-btn {
  width: 20%;
}
.inputControl{
width: 50%;
}
</style>
</head>
<body>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <!--header starts here-->
  <!--header ends here-->
  <div class="container clearfix">
    <div class="conact-form">
      <h3 style="color: red;">${invalid}</h3>
      <form:form method="POST" action="userForgotPassword.do" modelAttribute="Registration" autocomplete="off">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <form:errors path="emailId"  class="label error-label"></form:errors>
                 <label>
                  <p>
                  <h3 style="color: #873d80;">Forgot Password</h3>
                  <small class="required"></small>
                </p> </label>
                <label>
                  <p>
                    Enter Email Id<small class="required"></small>
                  </p> <form:input path="emailId" class="inputControl" placeholder="Please enter your email"
                    required="autofocus" maxlength="50" id="emailId" /> </label>
              </div></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" onclick="remeberMe();" /></td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>