<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<script type="text/javascript" src="js/page-js/registration.js"></script>
<title>Student Registration</title>
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css"
	href="css/jquery-ui-1.9.1.custom.min.css" />
	
<script type="text/javascript">
	$(document).ready(function() {

		if (document.getElementById('ccheck').checked) {
			$("#semester").hide();
			$("#year").show();
		} else {
			$("#semester").hide();
			$("#year").hide();
		}
		if (document.getElementById('pcheck').checked) {
			$("#semester").show();
			$("#percentage1").hide();

		}
		$("#ccheck").click(function() {
			$("#semester").hide();
			$("#percentage1").show();
			$("#year").show();
		});
		$("#pcheck").click(function() {
			$("#semester").show();
			$("#percentage1").hide();
			$("#year").hide();
		});

	});
</script>

<style>
	.inputControl{
	    width: 100%;
	}
	</style>
</head>
<body>

	<div class="container clearfix">
		<div class="conact-form">
			<h3 style="color: red;">${message}</h3>
			<p>&nbsp;</p>
			<form:form method="POST" action="saveStudentDeatils.do"
				modelAttribute="Registration" autocomplete="off">
				<h4>
					<b>Please browse student image</b>
				</h4>
				<div id="fileinfo">
					<div id="filename"></div>
					<div id="filesize"></div>
					<div id="filetype"></div>
					<div id="filedim"></div>

				</div>
				<div id="error">You should select valid image files only!</div>
				<div id="error2">An error occurred while uploading the file</div>
				<div id="abort">The upload has been canceled by the user or
					the browser dropped the connection</div>
				<div id="warnsize">Your file is very big. We can't accept it.
					Please select more small file</div>
				<div id="progress_info">
					<div id="upload_response"></div>
				</div>
				<img id="preview" src="" onerror="this.src='${imgPath}image.jpg'" />
				<div>
					<div>
						<input type="file" name="image_file" id="image_file"
							onchange="fileSelected();" />
					</div>
				</div>
				<form:hidden path="imgPath" id="imagePath" />
				<form:hidden path="imagePath" />
				<table width="100%" border="0">
					<tr>
						<td style="width: 290px;"><div class="form-control">
								<%-- <form:errors path="firstName" class="label error-label"></form:errors> --%>
								<label>
									<p>
										Enrollment No<small class="required">*</small>
									</p> <form:input path="enrollmentNo" class="inputControl"
										placeholder="Enrollment No" required="autofocus" maxlength="30" />
										
										<%-- maxlength="30" onblur="enrolVarification(this);" /> --%>
								</label>
							</div></td>

						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="firstName" class="label error-label"></form:errors>
								<label>
									<p>
										Name<small class="required">*</small>
									</p> <form:input path="firstName" class="inputControl"
										placeholder="Name" required="autofocus" maxlength="30"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
						<form:hidden path="registrationId" />
						
						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="emailId" class="label error-label"></form:errors>
								<label>
									<p>
										Email Id<small class="required">*</small>
									</p> 
								</label>
								<form:input path="emailId" class="inputControl"
										placeholder="Email Id" required="autofocus" maxlength="100"
										 /> <form:hidden
										path="password" />
							</div></td>
					</tr>
<tr>
				<%-- <td><div class="form-control">
								<form:errors path="city" class="label error-label"></form:errors>
								<label>
									<p>
										City<small class="required">*</small>
									</p> <form:input path="city" class="inputControl"
										placeholder="City" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td> --%>
							
							<td><div class="form-control" >
								
								<label>
									<p>
										City<small class="required">*</small>
									</p> <form:select path="cities.cityId" class="inputControl"
										id="cityId">
										<form:option value="0" label="Select" />
										<c:forEach items="${cityList}" var="city">
											<form:option value="${city.cityId}"
												label="${city.cityName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td> 
							
							
							
							
							
							
							
					
							<td><div class="form-control" style="margin-left: 20px;">
								<%-- <form:errors path="qualification" class="label error-label"></form:errors> --%>
								<label>
									<p>
										Qualification<small class="required">*</small>
									</p> <form:input path="qualification" class="inputControl"
										placeholder="Qualification" required="autofocus" maxlength="50"
										 />
								</label>
							</div></td>
						</td>

					 	<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="course.courseId" class="label error-label"></form:errors>
								<label>
									<p>
										Course<small class="required">*</small>
									</p> <form:select path="course.courseId" class="inputControl"
										id="courseId">
										<form:option value="0" label="Select" />
										<c:forEach items="${course}" var="refCourse">
											<form:option value="${refCourse.courseId}"
												label="${refCourse.courseName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td> 


					</tr>




					<tr>

						<td><div class="form-control">
								<form:errors path="contact" class="label error-label"></form:errors>
								<label>
									<p>
										Contact<small class="required">*</small>
									</p> <form:input path="contact" class="inputControl"
										placeholder="Contact" required="autofocus" maxlength="10"
										onkeypress="return onlyNos(event,this);"/>
										 
								</label>

							</div></td>



						<td><div class="form-control" style="margin-left: 20px;">
								<%-- <form:errors path="currentStatus.current_status_Id"
									class="label error-label"></form:errors> --%>
								<label>
									<p>
										Current Status<small class="required">*</small>
									</p> <form:select path="currentStatus.current_status_Id"
										class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${currentStatus}" var="refcurrentStatus">
											<form:option value="${refcurrentStatus.current_status_Id}"
												label="${refcurrentStatus.currentStatus}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>

					
						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="courseFee" class="label error-label"></form:errors>
								<label>
									<p>
										Course Fee<small class="required"></small>
									</p> <form:input path="courseFee" class="inputControl"
										id="courseFee" readonly="true" maxlength="6"
										required="autofocus" />

								</label>
							</div></td>
</tr>
<tr>
						<td><div class="form-control" >
								<form:errors path="reference.referenceId"
									class="label error-label"></form:errors>
								<label>
									<p>
										Reference<small class="required">*</small>
									</p> <form:select path="reference.referenceId" class="inputControl"
										id="referenceId">
										<form:option value="0" label="Select" />
										<c:forEach items="${reference}" var="reference">
											<form:option value="${reference.referenceId}"
												label="${reference.referenceName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
					
						<td>

							<div class="form-control" style="margin-left: 20px;">

								<label>
									<p>
										Reference Name<small class="required">*</small>
									</p> <form:input path="referenceName" class="inputControl"
										placeholder="Reference Name" required="autofocus"
										maxlength="50" onkeypress="return Alphabets(event)" />
								</label>
							</div>


						</td>

						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="handledBy" class="label error-label"></form:errors>
								<label>
									<p>
										Handled By<small class="required">*</small>
									</p> <form:input path="handledBy" class="inputControl"
										placeholder="HandledBy" required="autofocus" maxlength="50"
										onkeypress="return Alphabets(event)" />
								</label>
							</div></td>


					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Discount in Percentage or RS.<small class="required"></small>
									</p> <input type="radio" name="dis" value="percentage"
									checked="checked">&nbsp;Percentage
								</label> <label><input type="radio" name="dis" value="rs">&nbsp;RS
								</label>
							</div></td>





						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="discount" class="label error-label"></form:errors>
								<label>
									<p>
										Discount<small class="required"></small>
									</p> <form:input path="discount" class="inputControl" id="discount"
										placeholder="Discount" onblur="return discountAmount() "
										maxlength="6" />
								</label>
							</div></td>
					
					

						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="totalFee" class="label error-label"></form:errors>
								<label>
									<p>
										Total Fee<small class="required"></small>
									</p> <form:input path="totalFee" class="inputControl"
										placeholder="Total Fee" id="totalFee" readonly="true" />
								</label>
							</div></td>
</tr>
<tr>

						<td><div class="form-control">
								<form:errors path="submittedFee" class="label error-label"></form:errors>
								<label>
									<p>
										Submitted Fee<small class="required">*</small>
									</p> <form:input path="submittedFee" class="inputControl"
										placeholder="Submitted Fee" required="autofocus"
										onfocus="return discountAmount()"
										onkeypress="return onlyNos(event,this);" maxlength="6" />
								</label>
							</div></td>
					
					
						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="batch.batchId" class="label error-label"></form:errors>
								<label>
									<p>
										Batch<small class="required">*</small>
									</p> <form:select path="batch.batchId" class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${batch}" var="refBatch">
											<form:option value="${refBatch.batchId}"
												label="${refBatch.batchName}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>




						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="collegeName" class="label error-label"></form:errors>
								<label>
									<p>
										College Name<small class="required">*</small>
									</p> <form:input path="collegeName" class="inputControl"
										placeholder="College Name" required="autofocus"
										maxlength="100" onkeypress="return Alphabets(event)" />
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">

								<label> Completed<form:radiobutton path="persuing"
										value="completed" id="ccheck" required="autofocus" />
								</label> <label>Persuing<form:radiobutton path="persuing"
										value="persuing" id="pcheck" />
								</label>
								<div id="semester">
									Semester
									<form:input path="semester" placeholder="semester"
										maxlength="1" onkeypress="return onlyNos(event,this);" />
								</div>
								
								<div id = "year">
								<%-- <form:errors path="year.yearId" class="label error-label"></form:errors> --%>
								<label>
									<p>
										Passout Year<small class="required">*</small>
									</p> <form:select path="year.yearId" class="inputControl">
										<form:option value="0" label="Select" />
										<c:forEach items="${year}" var="refYear">
											<form:option value="${refYear.yearId}"
												label="${refYear.year}"/>
										</c:forEach>
									</form:select>
								</label>
						
							</div>
							</div></td>


						<td><div id="percentage1" class="form-control" style="margin-left: 20px;">

								<label>
									<p>
										Percentage
									</p> <form:input path="percentage" class="inputControl"
										placeholder="%"   maxlength="5" />
								</label>
							</div></td>

					

						<td><div class="form-control" style="margin-left: 20px;">
								<form:errors path="idNumber" class="label error-label"></form:errors>
								<label>
									<p>
										Id Number<small class="required"></small>
									</p> <form:input path="idNumber" class="inputControl"
										placeholder="IdNumber" required="autofocus" maxlength="16" />
								</label>
							</div></td>


						</tr>

<tr>
						<td>
							<div class="form-control">
								<label>10th MarkSheet&nbsp;&nbsp;&nbsp;<form:checkbox
										path="tenthMarksheet" value="submitted" class="tenthMarksheet" />
										
										</label></div>
						</td>
						<td><label style="margin-left: 20px;">12thMarkSheet&nbsp;&nbsp;&nbsp;<form:checkbox
											path="twelfthMarksheet" value="submitted"
											class="tenthMarksheet" /></label></td>
						<td> <label style="margin-left: 20px;">Graduation&nbsp;&nbsp;&nbsp;<form:checkbox
												path="graduation" value="submitted" class="tenthMarksheet" /></label></td>
				</tr>
				<tr>
				<td><label>IdProof&nbsp;&nbsp;&nbsp;<form:checkbox
													path="idProof" value="submitted" class="tenthMarksheet" />
										</label></td>
				<td> <label style="margin-left: 20px;">PG Marksheet&nbsp;&nbsp;&nbsp;<form:checkbox
													path="pgMaeksheet" value="submitted" class="tenthMarksheet" />
										</label></td>
				</tr>
						<td colspan="2"><input type="submit" value="Submit"
							id="Submit" class="btn lg-btn" onclick="imgvalue()" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
	<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js"
		charset="utf-8">
		
	</script>
	<script type="text/javascript" src="js/page-js/commonDate.js"
		charset="utf-8"></script>

</body>
</html>