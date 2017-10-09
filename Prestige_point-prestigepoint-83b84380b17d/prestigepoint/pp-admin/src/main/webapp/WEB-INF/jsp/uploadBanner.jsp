<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
     <h3 style="color: red;">${uploadMessage}</h3>
      <form action="uploadBImage.do" method="post" enctype="multipart/form-data">
        <table width="100%" border="0">
        <tr><td><h3 style="color: #873d80;"><b>Please select Image for upload</b></h3></td></tr>
        <!--   <tr>
            <td><div class="form-control">
                <label>
                  <h3 style="color: #873d80;"><b>Select type :</b></h3> <small class="required"></small> </label> <label>
                   <small class="required"></small> </label> <br><select name="type" class="inputControl1">
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
          </tr> -->
          <tr>
            <td colspan="2"><input type="file" name="file" id="file" size="50" /></td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Upload Image" class="btn lg-btn" /></td>
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
</html> --%>