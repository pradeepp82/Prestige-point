<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval expression="@propertyConfigurer.getProperty('pp.jspImagePath')" var="imgPath" />
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Student Registration</title>
<script type="text/javascript" src="js/script.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css" />
<script type="text/javascript" src="js/page-js/common.js"></script>
<script type="text/javascript">
  function imgvalue() {
    var src = $("#preview").attr("src");
    $('#imagePath').attr("value", src);
  }
$(document).ready(function() {
    document.getElementById("preview").src = "${imgPath}${Registration.registrationId}.png";
});
</script>
<style>
.lg-btn {
    width: 20%;
}
</style>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <p>&nbsp;</p>
      <form:form method="POST" action="editProfileUser.do" modelAttribute="Registration" autocomplete="off">
        <h4>
          <b>Please browse student image</b>
        </h4>
        <div id="fileinfo">
          <div id="filename"></div>
          <div id="filesize"></div>
          <div id="filetype"></div>
          <div id="filedim"></div>
        </div>
        <div id="error">You should select valid image files only!</div>
        <div id="error2">An error occurred while uploading the file</div>
        <div id="abort">The upload has been canceled by the user or the browser dropped the connection</div>
        <div id="warnsize">Your file is very big. We can't accept it. Please select more small file</div>
        <div id="progress_info">
          <div id="upload_response"></div>
        </div>
        <img id="preview" src="" onerror="this.src='${imgPath}image.jpg'" />
        <div>
          <div>
            <input type="file" name="image_file" id="image_file" onchange="fileSelected();" onclick="hideImg()" />
          </div>
        </div>
        <form:hidden path="imgPath" id="imagePath" />
        <form:hidden path="registrationId" />
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <form:errors path="firstName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    First Name<small class="required">*</small>
                  </p> <form:input path="firstName" class="inputControl" placeholder="First Name" required="autofocus"
                    maxlength="30" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="lastName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Last Name<small class="required"></small>
                  </p> <form:input path="lastName" class="inputControl" placeholder="Last Name" required="autofocus"
                    maxlength="30" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
            <tr>
            <td><div class="form-control">
                <form:errors path="firstName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    State<small class="required">*</small>
                  </p> <form:input path="state" class="inputControl" placeholder="State" required="autofocus"
                    maxlength="50" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="lastName"  class="label error-label"></form:errors>
                <label>
                  <p>
                    City<small class="required"></small>
                  </p> <form:input path="city" class="inputControl" placeholder="City" required="autofocus"
                    maxlength="50" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="emailId"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Email Id<small class="required">*</small>
                  </p> <form:input path="emailId" class="inputControl" placeholder="Email Id" required="autofocus"
                    maxlength="100" /> </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="dateOfBirth"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Date Of Birth<small class="required">*</small>
                  </p> <form:input path="dateOfBirth" id="datepick" class="inputControl" placeholder="Date Of Birth"
                    required="autofocus" maxlength="30" readonly="true" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path="contact"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Contact<small class="required">*</small>
                  </p> <form:input path="contact" class="inputControl" placeholder="Mobile Number" required="autofocus"
                    maxlength="10" onkeypress="return onlyNos(event,this);" /> </label>
              </div>
            </td>
            <td><div class="form-control">
                <form:errors path="qualification"  class="label error-label"></form:errors>
                <label>
                  <p>
                    Qualification<small class="required"></small>
                  </p> <form:input path="qualification" class="inputControl" placeholder="Qualification"
                    required="autofocus" maxlength="20" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Update" class="btn lg-btn" onclick="imgvalue()" />
            </td>
          </tr>
        </table>
      </form:form>
    </div>
  </div>
  <script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="js/page-js/commonDate.js" charset="utf-8"></script>
</body>
</html>