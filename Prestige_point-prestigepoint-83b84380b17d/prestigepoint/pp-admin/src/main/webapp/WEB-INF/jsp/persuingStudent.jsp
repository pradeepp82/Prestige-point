<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>persuing student Detatil</title>
<script type="text/javascript" src="js/page-js/registration.js"></script>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">

			<p>&nbsp;</p>
			<h3 style="color: red;">${message}</h3>
			<form:form method="GET" action="persuingStudent.do"
				modelAttribute="PersuingStudent" autocomplete="off">
<form:form method="GET" action="savePersuingStudentDetails.do"
				modelAttribute="PersuingStudent" autocomplete="off">


				<table width="100%" border="0">
					<tr>

						<td><div class="form-control">
								
								<label>
									<p>FirstName</p> <form:input path="registration.firstName" id="firstName"
										class="inputControl" placeholder=" FirstName" required="autofocus"
										maxlength="50" onkeypress="return Alphabets(event)" /> <form:hidden
										path="persuingStudentId" onkeypress="return Alphabets(event)" /><form:hidden
                                        path="registration.registrationId" id="registrationId"/>
								</label>
							</div></td>
<td><div class="form-control">
								<form:errors path="name" class="label error-label"></form:errors>
								<label>
									<p>LastName</p> <form:input path="registration.lastName" id="lastName"
										class="inputControl" placeholder=" LastName" required="autofocus"
										maxlength="50" onkeypress="return Alphabets(event)" /> <form:hidden
										path="persuingStudentId" onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
</tr>




<tr>
						<td><div class="form-control">
								<form:errors path="registration.emailId" class="label error-label"></form:errors>
								<label>
									<p>Contact</p> <form:input path="registration.emailId" id="emailId"
										class="inputControl" placeholder=" Contact"
										required="autofocus" maxlength="10"
										onkeypress="return onlyNos(event,this);" />

								</label>
							</div></td>
					
					
						<td><div class="form-control">
								<form:errors path="registration.contact" class="label error-label"></form:errors>
								<label>
									<p>
										Email Id<small class="required">*</small>
									</p> <form:input path="registration.emailId" class="inputControl"
										placeholder="Email" required="autofocus" maxlength="100"
										onblur="emailVarification(this);" />

								</label>
							</div></td></tr>


						<tr><td><div class="form-control">
								<form:errors path="registration.qualification" class="label error-label"></form:errors>
								<label>
									<p>Qualification</p> <form:input path="registration.qualification"
										id="qualification" class="inputControl"
										placeholder="Qualification " required="autofocus"
										maxlength="50" onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
					
					
						<td><div class="form-control">
								<form:errors path="semester" class="label error-label"></form:errors>
								<label>
									<p>Semester</p> <form:input path="semester" id="semester"
										class="inputControl" placeholder="Semester "
										required="autofocus" maxlength="1"
										onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td></tr>
				<tr>		<td><div class="form-control">
								<form:errors path="registration.collegeName" class="label error-label"></form:errors>
								<label>
									<p>
										College Name<small class="required">*</small>
									</p> <form:input path="registration.collegeName" class="inputControl"
										placeholder="College Name" required="autofocus" maxlength="30"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							id="Submit" class="btn lg-btn" /></td>
					</tr>
				</table>


				<c:if test="${persuingStudentList != null}">
					<c:set var="count" value="0" scope="page" />

					<display:table name="persuingStudentList" pagesize="10"
						class="basic-table" uid="persuingStudentList"
						requestURI="persuingStudent.do">
						<!-- uid is user define -->
						<c:set var="count" value="${count+1}" scope="page" />

						<display:column title="S.NO" style="width:1%;" >
                                                       ${count}</display:column>
						 <display:column property="registration.firstName" title=" FIRSTNAME" /> 
						 <display:column property="registration.lastName" title=" LASTNAME" /> 
						<display:column property="registration.emailId" title="EMAIL ID" />
						<display:column property="registration.contact" title="Contact" />
						<display:column property="registration.qualification" title="Qualification" />
						<display:column property="semester" title="Semester" />
						<display:column property="registration.collegeName" title="CollegeName" />

						<display:column title="Edit">
							<a
								href="editPersuingStudent.do?persuingStudentId=${persuingStudentList.persuingStudentId}">Edit</a>
						</display:column>
						<display:column title="Delete">
							<a
								href="deletePersuingStudent.do?persuingStudentId=${persuingStudentList.persuingStudentId}"
								onclick="return confirm('Please confirm if you want to delete this student description!');">Delete</a>
						</display:column>


					</display:table>
				</c:if>


</form:form>
			</form:form>
		</div>
	</div>

</body>
</html> --%>