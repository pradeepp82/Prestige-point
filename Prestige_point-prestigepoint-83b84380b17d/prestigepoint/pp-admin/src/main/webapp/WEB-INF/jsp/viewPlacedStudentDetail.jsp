<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>

<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Place StudentFee Structure</title>

<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript">
	function remainingAmount() {

		var totalFee = document.getElementById("totalFee").value;
		var submittedFee = document.getElementById("submittedFee").value;

		if (totalFee != "" || submittedFee != "") {

			var remainingFee = totalFee - submittedFee;
			if (totalFee < 0 || submittedFee < 0) {
				alert("invalid fee");
			} else {

				document.getElementById("remainingFee").value = remainingFee;

			}
			if (remainingFee < 0) {
				alert("invalid fee");
			} else {
				document.getElementById("remainingFee").value = remainingFee;
			}
		}
	}
</script>
</head>
<body>
		<div class="container clearfix">
				<div class="conact-form">
						<h3 style="color: red;">${message}</h3>
						<form:form method="POST" action="savePlacedStudentDetail.do"
								modelAttribute="PlacedStudentFeeStructure" autocomplete="off">
								<table width="100%" align="right">
										<tr>

												<td><div class="form-control">
																<form:errors path="firstName" class="label error-label"></form:errors>
																<label>
																		<p>Name</p> <form:input path="firstName"
																				id="firstName" class="inputControl"
																				placeholder=" First Name" required="autofocus"
																				maxlength="50" onkeypress="return Alphabets(event)" />
																		<form:hidden path="placedStudentId"
																				onkeypress="return Alphabets(event)" />
																</label>
														</div></td>
												<td><div class="form-control">
																<form:errors path="lastName" class="label error-label"></form:errors>
																<label>
																		<p>Last Name</p> <form:input path="lastName"
																				id="lastName" class="inputControl"
																				placeholder=" Last Name" required="autofocus"
																				maxlength="50" onkeypress="return Alphabets(event)" />

																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<form:errors path="contactNumber"
																		class="label error-label"></form:errors>
																<label>
																		<p>Contact No:</p> <form:input path="contactNumber"
																				id="contactNumber" class="inputControl"
																				placeholder=" ContactNumber" required="autofocus"
																				maxlength="10"
																				onkeypress="return onlyNos(event,this);" />

																</label>
														</div></td>
												<td><div class="form-control">
																<form:errors path="email" class="label error-label"></form:errors>
																<label>
																		<p>
																				Email Id<small class="required">*</small>
																		</p> <form:input path="email" class="inputControl"
																				placeholder="Email Id" required="autofocus"
																				maxlength="100" />

																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<form:errors path="totalFee" class="label error-label"></form:errors>
																<label>
																		<p>
																				Total Fee<small class="required">*</small>
																		</p> <form:input path="totalFee" class="inputControl"
																				placeholder="Total Fee" required="autofocus"
																				maxlength="6"
																				onkeypress="return onlyNos(event,this);" />

																</label>
														</div></td>
												<td><div class="form-control">
																<form:errors path="submittedFee"
																		class="label error-label"></form:errors>
																<label>
																		<p>
																				Submitted Fee<small class="required">*</small>
																		</p> <form:input path="submittedFee" class="inputControl"
																				placeholder="submitted Fee" required="autofocus"
																				maxlength="6" onblur="remainingAmount();" />

																</label>
														</div></td>
										<tr>
												<td><div class="form-control">
																<%-- <form:errors path="remainingFee" class="label error-label"></form:errors> --%>
																<label>
																		<p>
																				Remaining Fee<small class="required"></small>
																		</p> <form:input path="remainingFee" id="remainingFee"
																				class="inputControl" placeholder="Remaining Fee"
																				required="autofocus" maxlength="6" readonly="true" />

																</label>
														</div></td>
												<td><div class="form-control">
																<form:errors path="studentPackage"
																		class="label error-label"></form:errors>
																<label>
																		<p>
																				Student Package<small class="required">*</small>
																		</p> <form:input path="studentPackage"
																				class="inputControl" placeholder="Student Package"
																				required="autofocus" maxlength="6" />

																</label>
														</div></td>
										</tr>
										<tr>
												<td colspan="2"><input type="submit" value="Submit"
														class="btn lg-btn" /></td>
										</tr>
								</table>
						</form:form>
						<c:if test="${placedStudentList != null}">
								<c:set var="count" value="0" scope="page" />
								<display:table name="placedStudentList" pagesize="8"
										class="basic-table" uid="placedStudentId"
										requestURI="viewPlacedStudentDetail.do">
										<c:set var="count" value="${count+1}" scope="page" />
										<display:column title="S NO:" style="width:1%;" >
									 ${count}</display:column>
												 
										<display:column title="NAME">${placedStudentId.firstName} ${placedStudentId.lastName}</display:column>
										<display:column property="contactNumber" title="CONTACT NO" />
										<display:column property="email" title="EMAIL ID" />
										<display:column property="totalFee" title="Total Fee" />
										<display:column property="submittedFee" title="SUBMITTED FEE" />
										<display:column property="remainingFee" title="REMAINING FEE" />
										<display:column property="studentPackage" title="STUDENT PACKAGE" />
									<display:column>
									<a href="getPlacedStudentEmiDetails.do?placedStudentId=${placedStudentId.placedStudentId}">FEE
										DETAILS</a>
								</display:column>
										<display:column title="Edit">
												<a
														href="editPlacedStudentDetail.do?placedStudentId=${placedStudentId.placedStudentId}">Edit</a>
										</display:column>

										<display:column title="Delete">
												<a
														href="deletePlacedStudentDetail.do?placedStudentId=${placedStudentId.placedStudentId}"
														onclick="return confirm('Please confirm if you want to delete this Details!');">Delete</a>
										</display:column>

								</display:table>
						</c:if>


				</div>
		</div>

</body>
</html>