<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<spring:eval expression="@propertyConfigurer.getProperty('pp.jspImagePath')" var="imgPath" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
<style type="text/css">
.conact-form table tr td {
    padding: 4px;
}
</style>
</head>
<body>
  <div class="container clearfix">
    <div class="conact-form">
      <h2>Your Profile</h2>
      <p>&nbsp;</p>
      <h3 style="color: red;">${message}</h3>
      <table width="150%">
        <tr>
          <td width="40%">
            <table>
              <c:forEach items="${detailsList}" var="list">
                <tr>
                  <td><table>
                      <tr>
                        <td>First Name:</td>
                        <td><b>${list.firstName}</b></td>
                      </tr>
                      <tr>
                        <td>Last Name:</td>
                        <td><b>${list.lastName}</b></td>
                      </tr>
                      <tr>
                        <td>Email Id:</td>
                        <td><b>${list.emailId}</b></td>
                      </tr>
                        <tr>
                        <td>State:</td>
                        <td><b>${list.state}</b></td>
                      </tr>
                      <tr>
                        <td>City:</td>
                        <td><b>${list.city}</b></td>
                      </tr>
                      <tr>
                        <td>Date Of Birth:</td>
                        <td><b>${list.dateOfBirth}</b></td>
                      </tr>
                      <tr>
                        <td>Contact No.</td>
                        <td><b>${list.contact}</b></td>
                      </tr>
                    </table>
                  </td>
                </tr>
                <tr>
                  <td>
                  <c:if test="${sessionScope.registration!=null}">
                  <c:if test="${sessionScope.registration.status=='paid'}">
                  <table>
                      <tr>
                        <td><font color="#73346d"><b>Fee Details</b> </font></td>
                      </tr>
                      <tr>
                        <td>Total Fee:</td>
                        <td><b>${list.totalFee}</b></td>
                      </tr>
                      <tr>
                        <td>Submitted Fee:</td>
                        <td><b>${list.submittedFee}</b></td>
                      </tr>
                    </table>
                   </c:if>
                   </c:if>
                <tr>
                  <td><a href="editProfile.do?registrationId=${list.registrationId}"><font color="#73346d">For
                        edit profile <b>CLICK HERE</b> </font> </a></td>
                </tr>
              <tr>
                  <td><a href="changePassword.do?registrationId=${list.registrationId}"><font color="#73346d"><u><b>Change password</b></u> </font> </a></td>
                </tr>
                </c:forEach>
            </table>
          </td>
          <td width="80%">
            <c:forEach items="${detailsList}" var="list">
            <table>
            <tr>
                  <td>
                    <table>
                      <tr>
                        <td><img src="${imgPath}${list.registrationId}.png" onerror="this.src='${imgPath}image.jpg'" style="width: 120px; height: 120px">
                        </td>
                      </tr>
                    </table>
                  </td>
                </tr>
          </table>
          </c:forEach>
          <c:if test="${sessionScope.registration!=null}">
          <c:if test="${sessionScope.registration.status=='paid'}">
            <h3>
              <font color="#73346d"><b>Emi Details</b> </font>
            </h3> <c:set var="count" value="0" scope="page" /> <display:table name="emiList" pagesize="8"
              class="basic-table" uid="cat" requestURI="viewProfile.do">
              <c:set var="count" value="${count+1}" scope="page" />
              <display:column title="S.NO">
     ${count}
    </display:column>
              <display:column property="amount" title="Amount" />
              <display:column title="DATE">
                <fmt:parseDate value="${cat.date}" var="date" pattern="yyyy-MM-dd" />
                <fmt:formatDate type="date" value="${date}" var="startDate" pattern="dd-MM-yyyy" />
                <c:out value="${startDate}" />
              </display:column>
            </display:table>
             </c:if>
          </c:if>
          </td>
        </tr>
      </table>
    </div>
  </div>
</body>
</html>