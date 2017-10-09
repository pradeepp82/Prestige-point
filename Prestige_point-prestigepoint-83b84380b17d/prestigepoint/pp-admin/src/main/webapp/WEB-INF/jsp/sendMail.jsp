<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Email Send</title>
<script type="text/javascript" src="js/page-js/emailSend.js"></script>
<script type="text/javascript">
	$(document)
			.ready(
					function() {
						if (emailId != null && emailId != '') {
							document.getElementById("emailId").value = "${emailId}";
						}
					});
</script>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <form:form method="POST" action="sendMail.do" modelAttribute="Registration" enctype="multipart/form-data">
        <table width="100%" border="0">
         <tr>
          <td><span id="Mail" style="color: red;"></span></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <h3 style="color: #873d80;">Send e-mail with attachments</h3> <small class="required"></small> </label> <label>
                  <form:checkbox path="allStudent" value="allstudent" id="student" onclick="disablefields()" /> All Student<small
                  class="required"></small> </label>&nbsp; &nbsp; <label> <form:checkbox path="allEnquiry"
                    value="allenquiry" id="allEnquiry" onclick="disablefields()" /> All Enquiry<small class="required"></small> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Email To:<small class="required"></small>
                  </p> <form:input path="emailId" class="inputControl1" placeholder="Email Address" maxlength="80"
                    id="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$" /> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Subject<small class="required"></small>
                  </p> <form:input path="subject" class="inputControl1" placeholder="Subject" required="autofocus"
                    maxlength="50" /> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Message<small class="required"></small>
                  </p> <form:textarea path="message" cols="50" rows="10"  required="autofocus"/> </label>
              </div></td>
          </tr>
          <tr>
            <td><div class="form-control">
                <label>
                  <p>
                    Attach file:<small class="required"></small>
                  </p> <input type="file" name="attachFile" size="60" />
                   </label>
              </div></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Submit" class="btn lg-btn"/>
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
</body>
</html>