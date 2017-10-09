<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>uploadJar</title>
<script type="text/javascript" src="js/page-js/uploadJar.js"></script>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
    <p style="color: red;" id="lblError"><h3 style="color: red;">${uploadMessage}</h3></p>
      <form action="saveJar.do" method="post" enctype="multipart/form-data">
        <table width="100%" border="0">
        <tr><td><h3 style="color: #873d80;"><b>Please select jar file for upload</b></h3></td></tr>
          <tr>
            <td><div class="form-control">
              <form:errors path="file"  class="label error-label"></form:errors> 
                <label>
                  <h3 style="color: #873d80;"><b>Select type :</b></h3> <small class="required"></small> </label> <label>
                   <small class="required"></small> </label> <br><select name="languageType" class="inputControl1">
                  <option value="corejava">Core Java</option>
                  <option value="jdbc">JDBC</option>
                  <option value="advancejava">JSP Servlet</option>
                  <option value="hibernate">Hibernate</option>
                  <option value="struts">Struts</option>
                  <option value="spring">Spring</option>
                  <option value="others">Others</option>
                </select>
              </div>
            </td>
          </tr>
         <!--  <tr>
          <td><span id="lblError" style="color: red;"></span></td>
          </tr> -->
          <tr>
            <td colspan="2"><input type="file" name="file" id="file" size="50" /></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit"  value="Upload File" class="btn lg-btn" onclick="return ValidateExtension()" /></td>
          </tr>
        </table>
      </form>
    </div>
  </div>
</body>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;</p>
</html>