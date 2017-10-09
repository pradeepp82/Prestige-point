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
<title>Enquiry By Month</title>
<script type="text/javascript" src="js/page-js/viewEnquiryByMonth.js"></script>
<style>
.basic-table {
	width: 158%;
}
</style>
</head>
<body>
	<div class="container clearfix">
		<div class="conact-form">
			<form:form method="POST" action="getEnquiryDetails.do"
				modelAttribute="Enquiry" autocomplete="off">
				<table width="100%" border="0">
					<label>
						<p>
						<h3 style="color: #873d80;">Please select atleast one for
							enquiry details</h3> <small class="required"></small>
						</p>
					</label>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Month <small class="required"></small>
									</p> <form:select path="month" class="inputControl1" id="month">
										<form:option value="0" label="SELECT" />
										<form:option value="1" label="JAN" />
										<form:option value="2" label="FEB" />
										<form:option value="3" label="MARCH" />
										<form:option value="4" label="APRIL" />
										<form:option value="5" label="MAY" />
										<form:option value="6" label="JUNE" />
										<form:option value="7" label="JULY" />
										<form:option value="8" label="AUG" />
										<form:option value="9" label="SEPT" />
										<form:option value="10" label="OCT" />
										<form:option value="11" label="NOV" />
										<form:option value="12" label="DEC" />
									</form:select>
								</label>
							</div></td>
					</tr>
					<tr>
						<td><div class="form-control">
								<label>
									<p>
										Year <small class="required"></small>
									</p>
									<form:select path="year" class="inputControl1">
										<form:option value="0" label="SELECT" />
										<c:forEach items="${year}" var="refYear">
											<form:option value="${refYear.year}" label="${refYear.year}" />
										</c:forEach>
									</form:select>
								</label>
							</div></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="Submit"
							class="btn lg-btn" /></td>
					</tr>
				</table>

			<%--  </form:form>--%>
			
			<display:table name="enquirylist" pagesize="12" class="basic-table"
				uid="cat" requestURI="getEnquiryDetails.do">
				<c:set var="count" value="${count+1}" scope="page" />
				<display:column title="S.NO" class="showHeading" style="width:1%;">${count}</display:column>
				<c:set var="displayTotalEnquiry"
				
					value="${displayTotalEnquiry+cat[0]}" scope="page" />
				<c:set var="displayConvertedEnquiry"
					value="${displayConvertedEnquiry+cat[2]}" scope="page" />
				<c:set var="displayPositiveEnquiry"
					value="${displayPositiveEnquiry+cat[0]-cat[2]}" scope="page" />
				<fmt:parseDate var="dateObj" value="${cat[1]}" type="DATE"
					pattern="yyyy-MM-dd" />
				<fmt:formatDate var="monthObj" value="${dateObj}" type="DATE"
					pattern="MMMM yyyy" />
				<display:column title="MONTH">${monthObj}</display:column>
				<c:if test="${cat[3]!=null}">
					<display:column title="HNDELED BY"> ${cat[3]}</display:column>
				</c:if>
				<display:column title="TOTAL">${cat[0]}</display:column>
				<display:column title="CONVERTED">${cat[2]}</display:column>
				<display:column title="PENDING">${cat[0]-cat[2]}</display:column>
			</display:table>
			<table style="width: 50%;" align="right" class="showHeading">
				<tr>
					<th>Total:</th>
					<td><b>${displayTotalEnquiry}</b></td>
					<th>Converted:</th>
					<td><b>${displayConvertedEnquiry}</b></td>
					<th>Pending:</th>
					<td><b>${displayPositiveEnquiry}</b></td>
				</tr>
			</table>
		</div>
	</div>
	</form:form>
	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
</body>
</html>