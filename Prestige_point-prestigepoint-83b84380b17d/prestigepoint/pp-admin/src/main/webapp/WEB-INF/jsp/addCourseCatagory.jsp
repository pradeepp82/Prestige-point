<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<form:form method="POST" action="saveCourseCategory.do"
				modelAttribute="CourseCategory" autocomplete="off">
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								<label>
									<p>
									<h3 style="color: #873d80;">Add Course Category</h3> <small
									class="required"></small>
									</p>
								</label> <label>
									<p>
										Course Category Name <small
											class="required"></small>
									</p> <form:input path="courseCatName" class="inputControl1"
										placeholder="Course Category Name" required="autofocus" maxlength="25" />
									<form:hidden path="courseCatId" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn" /></td>
					</tr>
					</table>
					</form:form>
					</div>
					</div>
				
</body>
</html>