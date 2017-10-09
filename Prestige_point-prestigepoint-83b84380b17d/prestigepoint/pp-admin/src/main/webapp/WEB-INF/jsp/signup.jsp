<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sign Up</title>
<!--stylesheet begins here -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="fonts/font-class.css" media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/page-js/login.js"></script>
<script type="text/javascript" src="js/page-js/common.js"></script>
</head>
<body>
  <!--header starts here-->
    <!--header ends here-->
  <div class="container clearfix">
    <div class="conact-form">
      <h3 style="color: red;">${message}</h3>
      
      <form:form method="POST" action="adminsignup.do" modelAttribute="AdminLogin" autocomplete="off">
        <table width="100%" border="0">
        <tr>
            <td><div class="form-control">
                <form:errors path="firstName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    First Name<small class="required"></small>
                  </p> <form:input path="firstName" class="inputControl1" placeholder="Please enter your First Name"
                    required="autofocus" maxlength="50" id="firstName" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="lastName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Last Name<small class="required"></small>
                  </p> <form:input path="lastName" class="inputControl1" placeholder="Please enter your Last Name"
                    required="autofocus" maxlength="50" id="lastName" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="emailId"  class="label error-label"></form:errors>
                <label>
                  <p>
                    E-Mail<small class="required"></small>
                  </p> <form:input path="emailId" class="inputControl1" placeholder="Please enter your email"
                    required="autofocus" maxlength="50" id="" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="contactNo"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Contact<small class="required">*</small>
                  </p> <form:input path="contactNo" class="inputControl1" placeholder="Mobile Number" required="autofocus"
                    maxlength="10" onkeypress="return onlyNos(event,this);" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="password"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Password<small class="required"></small>
                  </p> <form:password path="Password" class="inputControl1" placeholder="Password" required="autofocus"
                    maxlength="15" id="" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                 <form:errors path="adminType"  class="label error-label"></form:errors> 
                <label>
                  <p>
                    Admin Type<small class="required"></small>
                  </p><form:select path="adminType">
                  <form:option value="0">---Select---</form:option>
                  <form:option value="1">SuperAdmin</form:option>
                  <form:option value="2">Admin</form:option>
                  <form:option value="3">Manager</form:option>
                  <form:option value="4">HR</form:option>
                  </form:select> </label>
              </div>
            </td>
          </tr>
              <!-- <tr>
            <td><div class="form-control">
                <label>
                   <small class="required"></small>
                 <input type="checkbox" id="rememberMe" /> Remember Me</label>
              </div></td>
          </tr> -->
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" onclick="remeberMe();" />
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
</body>
</html>
