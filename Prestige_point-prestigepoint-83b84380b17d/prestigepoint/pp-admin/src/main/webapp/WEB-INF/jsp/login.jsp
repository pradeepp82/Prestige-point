<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Login</title>
<!--stylesheet begins here -->
<link rel="stylesheet" type="text/css" href="css/reset.css" media="all">
<link rel="stylesheet" type="text/css" href="fonts/font-class.css" media="all">
<link rel="stylesheet" type="text/css" href="css/style.css" media="all">
<script type="text/javascript" src="js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="js/jquery.cookie.js"></script>
<script type="text/javascript" src="js/page-js/login.js"></script>
</head>
<body>
  <!--header starts here-->
  <header> <section class="top-header">
  <div class="container clearfix">
    <ul class="contact-info">
      <li><i class="icon icon-email"></i><a href="mailto:hrd@prestigepoint.in">hrd@prestigepoint.in</a>
      </li>
      <li><i class="icon  icon-call"></i> 91-731-3087869</li>
    </ul>
    <div class="registration-alert">
      <font color="#873d80">WELCOME TO ADMIN PANEL</font>
    </div>
  </div>
  </section> <section class="main-header">
  <div class="container clearfix bottom-border">
    <div class="brand-logo">
      <a href="welcome.do"><img src="img/logo-prestige-point.png" alt="Brand Logo">
      </a>
    </div>
  </div>
  </section> </header>
  <!--header ends here-->
  <div class="container clearfix">
    <div class="conact-form">
      <h3 style="color: red;">${invalid}</h3>
      <h3 style="color: red;">${forgotMessage}</h3>
      <form:form method="POST" action="userSignIn.do" modelAttribute="AdminLogin" autocomplete="off">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    User Name<small class="required"></small>
                  </p> <form:input path="emailId" class="inputControl1" placeholder="Please enter your email"
                    required="autofocus" maxlength="50" id="emailId" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Password<small class="required"></small>
                  </p> <form:password path="Password" class="inputControl1" placeholder="Password" required="autofocus"
                    maxlength="15" id="password" /> </label>
              </div>
            </td>
          </tr>
              <tr>
            <td><div class="form-control">
                <label>
                   <small class="required"></small>
                 <input type="checkbox" id="rememberMe" /> Remember Me</label>
                  &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                 <label>
                  <a href="forgotPassword.do" >Forgot Password</a></label> 
              </div></td>
          </tr>
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
