<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Add Courses</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.1.custom.min.css" />
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<form:form method="POST" action="saveBatch.do" modelAttribute="Batch"
				autocomplete="off">
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								<%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
								<label>
									<p>
									<h3 style="color: #873d80;">Add Batch</h3> <small
									class="required"></small>
									</p>
								</label> <label>
									<p>
										Batch Name<small class="required"></small>
									</p> <form:input path="batchName" class="inputControl1"
										placeholder="Batch Name" required="autofocus" maxlength="50" />
									<form:hidden path="batchId" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="startDate" class="label error-label"></form:errors>
								<label>
									<p>
										Start Date<small class="required"></small>
									</p> <form:input path="startDate" id="datepick"
										class="inputControl1" placeholder="Start Date"
										required="autofocus" maxlength="20" readonly="true" />
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
			<display:table name="batchList" pagesize="8" class="basic-table"
				uid="cat" requestURI="batch.do">
				<c:set var="count" value="${count+1}" scope="page" />
				<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
				<display:column property="batchName" title="BATCH NAME" />
				<display:column property="startDate" title="START DATE" />
				<display:column title="Edit">
					<a href="saveBatch.do?batchId=${cat.batchId}">Edit</a>
				</display:column>
				<display:column title="Delete">
					<a href="deleteBatch.do?batchId=${cat.batchId}"
						onclick="return confirm('Please confirm if you want to delete this batch!');">Delete</a>
				</display:column>
			</display:table>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="js/page-js/commonDate.js"
		charset="utf-8"></script>
</body>
</html>