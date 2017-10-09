<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<script type="text/javascript" src="js/page-js/common.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
</head>
<body>
  <!--header ends here-->
  <!--map banner begins here-->
  <section> <a
    href="https://www.google.co.in/maps/place/Prestige+Point/@22.7254621,75.8912971,17z/data=!4m5!1m2!2m1!1sPrestige+Point+Indore!3m1!1s0x3962fd360fa596b5:0x746e43fe47e1c850"><div
      class="container map-banner"></div>
  </a> </section>
  <!--map banner ends here-->
  <!--contact begins here-->
  <section>
  <div class="container clearfix">
    <div class="address">
      <h2>Office</h2>
      <address>
        <h1>Prestige Point</h1>
        A/2, Classic Moon Building,<br> 3rd Floor, Old Palasia,Indore - 452001,<br> Madhya Pradesh, India.<br>
        Call: 91-731-3087869<br> Email: <a href="mailto:hrd@prestigepoint.co.in">hrd@prestigepoint.in</a>
      </address>
    </div>

    <div class="conact-form">
      <h2>Get in Touch</h2>
      <h3 style="color: #863d7f;">${message}</h3>
      <form:form modelAttribute="Enquiry" action="saveContact.do" method="post" id="contact-form" autocomplete="off">
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
               <%--  <form:errors path="name" class="label error-label"></form:errors> --%>
                <!-- <span class="label error-label">Error message goes here</span> -->
                <label>
                  <p>
                    Your Name<small class="required">*</small>
                  </p> <form:input path="name" class="inputControl" maxlength="30" onkeypress="return Alphabets(event)" required="autofocus" />
                </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="subject" class="label error-label"></form:errors>
                <label>
                  <p>
                    Subject<small class="required">*</small>
                  </p> <form:input path="subject" class="inputControl" maxlength="40" onkeypress="return Alphabets(event)" required="autofocus" />
                </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="emailId" class="label error-label"></form:errors>
               
                <label>
                  <p>
                    Your Email Address<small class="required">*</small>
                  </p> <form:input path="emailId" class="inputControl" maxlength="100" required="autofocus" /> </label>
              </div>
            </td>
            <td rowspan="2">
              <div class="form-control">
               <%--  <form:errors path="comment" class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Your Comments<small class="required">*</small>
                  </p> <form:textarea path="comment" class="inputControl" rows="6" maxlength="150" required="autofocus" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="mobileNo" class="label error-label"></form:errors>
                <label>
                  <p>
                    Your Phone No.<small class="required">*</small>
                  </p> <form:input path="mobileNo" class="inputControl" maxlength="11"
                    onkeypress="return onlyNos(event,this);" required="autofocus" /> </label>
              </div>
            </td>

          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn" />
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
  </section>
</body>
</html>