<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="js/page-js/registration.js"></script>
<title>Add Courses</title>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<form:form method="POST" action="saveCourse.do"
				modelAttribute="Course" autocomplete="off">
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								<label>
									<p>
									<h3 style="color: #873d80;">Add Courses</h3> <small
									class="required"></small>
									</p>
								</label> <label>
									<p>
										Course Name ${adminLogin.ADMIN_LOGIN_ID}<small
											class="required"></small>
									</p> <form:input path="courseName" class="inputControl1"
										placeholder="Course Name" required="autofocus" maxlength="25" />
									<form:hidden path="courseId" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Course Fee<small class="required"></small>
									</p> <form:input path="courseFee" class="inputControl1"
										placeholder="Course Fee" required="autofocus" maxlength="6"
										onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn" /></td>
					</tr>
				</table>
			</form:form>
			<c:set var="count" value="0" scope="page" />
			<display:table name="courseList" pagesize="8" class="basic-table"
				uid="cat" requestURI="course.do">
				<c:set var="count" value="${count+1}" scope="page" />
				<display:column title="S.NO" class="showHeading" style="width:1%;">
     ${count}
    </display:column>
				<display:column property="courseName" title="COURSE NAME" />
				<display:column property="courseFee" title="COURSE Fee" />
				<display:column title="Edit">
					<a href="editCourse.do?courseId=${cat.courseId}">Edit</a>
				</display:column>
				<display:column title="Delete">
					<a href="deleteCourse.do?courseId=${cat.courseId}"
						onclick="return confirm('Please confirm if you want to delete this course!');">Delete</a>
				</display:column>
				<display:column title="Add Course Catagory">
					<a href="addCourseCatagory.do?courseId=${cat.courseId}">Add Course Catagory</a>
				</display:column>
				
				
			</display:table>
		</div>
	</div>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>