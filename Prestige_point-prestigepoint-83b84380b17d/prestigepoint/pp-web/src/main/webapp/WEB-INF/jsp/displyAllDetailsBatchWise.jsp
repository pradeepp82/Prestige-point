<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assignment List</title>
<style>
th, td {
	padding: 5px;
	text-align: left;
}

.wider td {
	width: 10%;
}

th1, td1 {
	padding: 10px;
	text-align: left;
}
</style>
</head>
<body>
	<section class="inner-banner">
	<div class="container">
		<ul class="breadcrumb">
			<li><a href="welcome.do">Home</a></li>
			<li>&frasl;</li>
			<li>Assignment</li>
		</ul>
	</div>
	</section>
	<form:form>
		<table style="width: 60%; margin: 0px auto;" align="center">

			<tr>
				<td><b>Title:-${AddAssignment.subject.subjectName}</td>

			</tr>
			</br>
			<tr>
				<td><b>Topic:-</b> ${AddAssignment.topic}</td>

			</tr>
			</br>
			<tr>
				<td><b>Description:-</b>${AddAssignment.description}</td>
			</tr>
		</table>
		</br>
		</br>
		</br>
		<div align="center">
		<c:choose>
		<c:when test='${docAssignmentName.get(0)!=""}'>
			<c:set var="count" value="0" scope="page" />
			<display:table name="docAssignmentName" class="basic-table" uid="doc"
				requestURI="viewAssignment.do">
						<c:set var="count" value="${count+1}" scope="page" />
						<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
						<display:column title="Doc Name">
		        ${doc}
				</display:column>
						<display:column title="Assignment Download Doc">
							<a
								href="displyAndDownloadDoc.do?assignmentId=${AddAssignment.assignmentId}&doc=${doc}">Download
								Doc</a>
						</display:column>
			</display:table>
			</c:when>
				</c:choose>
		</div>
	</form:form>
</body>
</html>