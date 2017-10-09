<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Persuing Student Detail</title>
<style>
.basic-table {
	width: 50px;
}

#table-scroll {
	height: 400px;
	width: 1250px;
	overflow: auto;
	margin-top: 20px;
}
</style>
</head>

<body>
<div class="container clearfix">
		<div class="conact-form">
	<div id="table-scroll">

		 <c:if test="${persuingList != null}"> 
			<c:set var="count" value="0" scope="page" />
			<display:table name="persuingList" pagesize="15" uid="persuingList"
				class="basic-table" requestURI="persuingStudentDetail.do">
				<display:column property="enrollmentNo" title="Enrollment No"
					style="width:1%;"></display:column>
				<display:column title="NAME">${persuingList.firstName} ${persuingList.lastName}</display:column>
				<display:column property="contact" title="CONTACT NO" />
				<display:column property="emailId" title="EMAIL ID" />
				<display:column property="totalFee" title="Total Fee" />
				<display:column property="submittedFee" title="SUBMITTED FEE" />
				<display:column property="tenthMarksheet" title="10_MARKSHEET" />
				<display:column property="twelfthMarksheet" title="12_MARKSHEET" />
				<display:column property="graduation" title="GRADUATION" />
				<display:column property="idProof" title="ID_PROOF" />
				<display:column property="persuing" title="PERSUING" />
				<display:column property="semester" title="SEMESTER" />
				<display:column title="Current Status">${persuingList.currentStatus.currentStatus}</display:column>
				<c:choose>
					<c:when test="${cat.status!='free'}">
						<display:column>
							<a
								href="getEmiDetails.do?registrationId=${persuingList.registrationId}">FEE
								DETAILS</a>
						</display:column>
					</c:when>
					<c:otherwise>
						<display:column>
							<a
								href="setStudentDetails.do?registrationId=${persuingList.registrationId}">MAKE
								STUDENT</a>
						</display:column>
					</c:otherwise>
				</c:choose>
				<display:column>
					<a href="getEmailId.do?emailId=${cat.emailId}">Send Mail</a>
				</display:column>
				<c:if test="${sessionScope.login.adminType!=4}">
					<display:column title="Edit">
						<a
							href="getStudentDetails.do?registrationId=${persuingList.registrationId}">Edit</a>
					</display:column>

					<display:column title="Delete">
						<a
							href="deleteStudentDetails.do?registrationId=${persuingList.registrationId}"
							onclick="return confirm('Please confirm if you want to delete this Details!');">Delete</a>
					</display:column>
				</c:if>
			</display:table>
		</c:if>

	</div></div></div>

</body>
</html>




