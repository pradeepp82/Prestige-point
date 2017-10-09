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
<style>
.basic-table {
	width: 110%;
}
</style>
</head>
<body>
		<div class="container clearfix">
				<div class="conact-form">
						<h3 style="color: red;">${message}</h3>
						<form:form method="POST" action="saveCurrentBatch.do"
								modelAttribute="CurrentBatch" autocomplete="off">
								<table width="100%" border="0">
										<tr>
												<td><div class="form-control">
																<%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
																<label>
																		<p>
																		<h3 style="color: #873d80;">Add Current Batch</h3> <small
																		class="required"></small>
																		</p>
																</label> <label>
																		<p>
																				Batch<small class="required">*</small>
																		</p> <form:input path="batchName" class="inputControl1"
																				placeholder="Current batch" required="autofocus"
																				maxlength="40" />
																</label>
																<form:hidden path="currentBatchId" />
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<form:errors path="status" class="label error-label"></form:errors>
																<label>
																		<p>
																				Status<small class="required"></small>
																		</p> <form:select path="status" class="inputControl1">
																				<form:option value="None" label="Select" />
																				<form:option value="open" label="Registration Open" />
																				<form:option value="close"
																						label="Registration Close" />
																		</form:select>
																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
																<label>
																		<p>
																				Current Topic<small class="required"></small>
																		</p> <form:input path="currentTopic" class="inputControl1"
																				placeholder="Current Topic" required="autofocus"
																				maxlength="40" onkeypress="return Alphabets(event)" />
																</label>
														</div></td>
										</tr>
										<tr>
												<td><div class="form-control">
																<%-- <form:errors path="subject"  class="label error-label"></form:errors> --%>
																<label>
																		<p>
																				No Of Student<small class="required"></small>
																		</p> <form:input path="onOfStudent" class="inputControl1"
																				placeholder="No of Student" required="autofocus"
																				maxlength="5"
																				onkeypress="return onlyNos(event,this);"/>
																</label>
														</div></td>
										</tr>

										<tr>
												<td><div class="form-control">
																<label>
																		<p>
																				Year<small class="required">*</small>
																		</p> <form:input path="year" class="inputControl1"
																				placeholder="year" required="autofocus"
																				maxlength="4" onkeypress="return onlyNos(event,this);"/>
																</label>

														</div></td>
										</tr>


										<tr>
												<td><div class="form-control">
																<label>
																		<p>
																				Month <small class="required">*</small>
																		</p> <form:input path="month" class="inputControl1"
																				placeholder="Month" required="autofocus"
																				maxlength="20" onkeypress="return Alphabets(event)"/>
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
						<display:table name="currentBatchList" pagesize="8"
								class="basic-table" uid="cbl" requestURI="currentBatch.do">
								<c:set var="count" value="${count+1}" scope="page" />
								<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
								<display:column property="batchName" title="BATCH NAME" />
								<display:column property="status" title="STATUS" />
								<display:column property="currentTopic" title="CURRENT TOPIC" />
								<display:column property="onOfStudent" title="NO OF STUDENT" />
								<display:column property="year" title="YEAR" />
								<display:column property="month" title="MONTH" />
								<display:column title="Edit">
										<a
												href="saveCurrentBatch.do?currentBatchId=${cbl.currentBatchId}">Edit</a>
								</display:column>
								<display:column title="Delete">
										<a
												href="deleteCurrentBatch.do?currentBatchId=${cbl.currentBatchId}"
												onclick="return confirm('Please confirm if you want to delete this batch!');">Delete</a>
								</display:column>
						</display:table>
				</div>
		</div>
</body>
</html>