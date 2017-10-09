<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

</head>
<body>
<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
<section>
  <div class="container innercontent">
      <c:set var="count" value="0" scope="page" />
       <c:forEach items="${currentBatchList}" var="count">
    <table class="basic-table">
      <thead>
        <tr>
          <th colspan="2"><c:out value="${count.batchName}"/></th>
        </tr>
      </thead>
      <tbody>
        <tr>
        	<td>Current Topic</td>
          <td><c:out value="${count.currentTopic}"/></td>
        </tr>
        <tr>
        <td>No Of Student</td>
          <td><c:out value="${count.onOfStudent}"/></td>
        </tr>
        <tr>
        <td>Registration Status</td>
          <td><c:out value="${count.status}"/></td>
        </tr>
        <tr>
        <td>Year</td>
          <td><c:out value="${count.year}"/></td>
        </tr>
        <tr>
        <td>Month</td>
          <td><c:out value="${count.month}"/></td>
        </tr>
      </tbody>
    </table>
	</c:forEach>
  </div>
  </section>
</body>
</html>