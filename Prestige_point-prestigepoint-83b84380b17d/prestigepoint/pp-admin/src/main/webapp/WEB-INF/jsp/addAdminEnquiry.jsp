<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<script type="text/javascript" src="js/page-js/registration.js"></script>
<title>Add Admin Enquiries</title>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
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
			<form:form method="POST" action="saveAdminEnquiry.do"
				modelAttribute="Enquiry" autocomplete="off">
				<table width="100%" border="0">
					<tr>
						<td><div class="form-control">
								
								<label>
									<p>
									<h3 style="color: #873d80;">Add Admin Enquiry</h3> <small
									class="required"></small>
									</p>
								</label> 
							</td></tr>
							<tr><td><label>
									<p>First Name<small></small></p>
									<form:input path="name" class="inputControl1"
										placeholder="First Name" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" /> <form:hidden
										path="enquiryId" />
								    </label>
							</div></td>
							<td><label>
									<p>Last Name<small></small></p>
									<form:input path="lastName" class="inputControl1"
										placeholder="Last Name" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" /> <form:hidden
										path="enquiryId" />
								    </label>
							</div></td>
						
							<tr>
							<td><div class="form-control">
								<form:errors path="date" class="label error-label"></form:errors>
								<label>
									<p>
										Date Of Enquiry<small></small>
									</p> <form:input path="date" id="datepick"
										class="inputControl1" placeholder="Date Of Enquiry"
										required="autofocus" maxlength="30" readonly="true" />
								</label>
							</div></td>
							<td><div class="form-control">
								<form:errors path="subject" class="label error-label"></form:errors>
								<label>
									<p>
										Handled By<small></small>
									</p> <form:input path="handledBy" class="inputControl1"
										placeholder="Handled By" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" /> <form:hidden
										path="enquiryId" />
								</label>
							</div></td>
							</tr>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="mobileNo" class="label error-label"></form:errors>
								<span class="label error-label" id="contact"
									style="display: none;">Contact No should be 10 digit</span> <label>
									<p>
										Mobile No.<small></small>
									</p> <form:input path="mobileNo" class="inputControl1"
										placeholder="Mobile No." required="autofocus" maxlength="10"
										onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="emailId" class="label error-label"></form:errors>
								<label>
									<p>
										Email Id<small></small>
									</p> <form:input path="emailId" class="inputControl1"
										placeholder="Email Id" required="autofocus" maxlength="100" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="subject" class="label error-label"></form:errors>
								<label>
									<p>
										Qualification<small></small>
									</p> <form:input path="qualification" class="inputControl1"
										placeholder="Qualification" required="autofocus"
										maxlength="50"/> <form:hidden
										path="enquiryId" />
								</label>
							</div></td>
						<td><div class="form-control">
								<form:errors path="subject" class="label error-label"></form:errors>
								<label>
									<p>
										Collage<small></small>
									</p> <form:input path="collage" class="inputControl1"
										placeholder="Collage" required="autofocus" maxlength="50"/> <form:hidden
										path="enquiryId" />
								</label>
							</div></td>
					</tr>
					<%-- <tr>
						  <td><div class="form-control">
								<form:errors path="subject" class="label error-label"></form:errors>
								<label>
									<p>
										Reference Name<small></small>
									</p> <form:input path="referenceName" class="inputControl1"
										placeholder="Reference Name" required="autofocus"
										maxlength="50" onkeypress="return Alphabets(event)" /> <form:hidden
										path="enquiryId" />
								</label>
							</div></td> --%>
							
							 <td><div class="form-control">
																
												 	<form:errors path="reference.referenceId" class="label error-label"></form:errors>				
																<label>
																		<p>
																				Reference<small class="required"></small>
																		</p> <form:select path="reference.referenceId"
																				class="inputControl" id="referenceId">
																				<form:option value="0" label="Select" />
																				<c:forEach items="${reference}" var="reference">
																						<form:option value="${reference.referenceId}"
																								label="${reference.referenceName}" />
																				</c:forEach>
																		</form:select>
																</label>
														</div></td> 
							
						
							
						<td><div class="form-control">
								<form:errors path="referenceMobileNo" class="label error-label"></form:errors>
								<label>
									<p>
										Reference Mobile No.<small></small>
									</p> <form:input path="referenceMobileNo" class="inputControl1"
										placeholder="Reference Mobile No." required="autofocus"
										maxlength="10" onkeypress="return onlyNos(event,this);" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<form:errors path="trainingType" class="label error-label"></form:errors>
								<label>
									<p>
										Training Type<small></small>
									</p>
									<form:select path="trainingType" class="inputControl1">
										<form:option value="0" label="Select" />
										<form:option value="1" label="Industrial" />
										<form:option value="2" label="Corporate" />
										<form:option value="3" label="Collage" />
										<form:option value="4" label="Other" />
									</form:select> <form:hidden path="enquiryId" />
								</label>
							</div></td>
							<td><div class="form-control">
								<%-- <form:errors path="subject" class="label error-label"></form:errors> --%>
								<label>
								<p>
										Comment<small></small>
									</p> <form:textarea path="comment" class="inputControl1"
										placeholder="comment" required="autofocus" maxlength="50" /> <form:hidden
										path="enquiryId" />
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
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
	 <script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"
		charset="utf-8"></script>
	<script type="text/javascript" src="js/page-js/commonDate.js"
		charset="utf-8"></script> 
</body>
</html>