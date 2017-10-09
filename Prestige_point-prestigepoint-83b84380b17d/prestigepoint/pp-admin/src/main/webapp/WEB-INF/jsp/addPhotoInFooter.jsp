<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval
	expression="@propertyConfigurer.getProperty('pp.jspImagePath')"
	var="imgPath" />
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<!-- <script type="text/javascript" src="js/page-js/registration.js"></script> -->
<script type="text/javascript" src="js/page-js/dynamicFooter.js"></script>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<title>Add Courses</title>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <h3 style="color: red;">${message}</h3>
      <form:form method="POST" action="saveFooterPhoto.do" modelAttribute="PhotoInFooter" autocomplete="off">
       <h3 style="color: #873d80;">Add Placed Student Detail For Dynamic Photo In Footer  </h3>
      
     			
        <table width="100%" border="0">
         <tr><td></td></tr> <tr><td></td></tr> <tr><td></td></tr>
          <tr>
            <td><div class="form-control">
                <form:errors path=""  class="label error-label"></form:errors>
              <label>
                  <p>
                    Student Name<small class="required"></small>
                  </p> <form:input path="studentName" class="inputControl1" placeholder="Student Name" required="autofocus"
                    maxlength="50" onkeypress="return Alphabets(event)"/> <form:hidden path="studentId" /> </label>
                  
              </div>
            </td>
             <td><div class="form-control">
                <form:errors path=""  class="label error-label"></form:errors>
                <label>
                  <p>
                   Student Comment<small class="required"></small>
                  </p> <form:textarea   path="studentComment" class="inputControl1" placeholder="Comments" required="autofocus"
                    maxlength="300" onkeypress="return Alphabets(event)" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                <form:errors path=""  class="label error-label"></form:errors>
                <label>
                  <p>
                   Company Name<small class="required"></small>
                  </p> <form:input path="placedInCompany" class="inputControl1" placeholder="Company Name" required="autofocus"
                    maxlength="50" onkeypress="return Alphabets(event)" /> </label>
                                  
              </div>
              </td>
              <td><div class="form-control">
             	<h4>
					<b>Please browse student image</b>
				</h4>
             	 <img id="preview" src="${imgPath}${PhotoInFooter.studentId}.png" style="width: 50px; height: 50px" />
             	<input type="file" name="image_file" id="image_file"
							onchange="fileSelected();" />
						
		<div id="fileinfo">
					<div id="filename"></div>
					<div id="filesize"></div>
					<div id="filetype"></div>
					<div id="filedim"></div>
				</div>
				</div>
				
            </td>
             
          </tr>
           <tr>
            <td><div class="form-control">
                <form:errors path=""  class="label error-label"></form:errors>
              <label>
                  <p>
                    Student package
                    <small class="required"></small>
                  </p><p>Example 1.5/3.5</p> <form:input path="studentPackage" class="inputControl1" placeholder="Student Package" required="autofocus"
                    maxlength="50" />  </label>
                  
              </div>
            </td></tr>
            <tr>
            <td colspan="2"><input type="submit" value="Submit"  onclick="imgvalue()" class="btn lg-btn" />
            </td>
          </tr>
        </table>
    	<form:hidden path="imgPath" id="imagePath" />
      <c:set var="count" value="0" scope="page" />
      <display:table name="photoInFooterList" pagesize="8" class="basic-table" uid="cat" requestURI="getFooterPhotoPage.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO" class="showHeading" style="width:1%;">
     ${count}
    </display:column>
        <display:column property="studentName" title="STUDENT NAME" />
        <display:column property="placedInCompany" title="COMPANY NAME" />
        <display:column property="studentComment" title="COMMENT" />
        <display:column property="studentPackage" title="STUDENT PACKAGE" />
            <display:column title="IMAGES" class="showHeading" style="width:1%;">
     <img id="preview" src="${imgPath}${cat.studentId}.png" style="width: 50px; height: 50px" />
    </display:column>
        <display:column title="Status">
        <c:if test="${cat.isStatusActive==1}">
     <form:checkbox path="isStatusActive" checked="checked" value="${cat.studentId}" id="checkboxId${cat.studentId}" onClick="enableStudentStatus(this);"/>
      </c:if>
        <c:if test="${cat.isStatusActive==0}">
     <form:checkbox path="isStatusActive" value="${cat.studentId}" id="checkboxId${cat.studentId}" onClick="enableStudentStatus(this);"/>
      </c:if>
      
        </display:column>
        <display:column title="Edit">
          <a href="saveFooterPhoto.do?studentId=${cat.studentId}">Edit</a>
        </display:column>
        <display:column title="Delete">
          <a href="deleteStudent.do?studentId=${cat.studentId}"
            onclick="return confirm('Please confirm if you want to delete this course!');">Delete</a>
        </display:column>
      </display:table>
        </form:form>
    </div>
  </div>
  <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>