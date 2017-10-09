<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <section class="inner-banner">
  <div class="container">
    <ul class="breadcrumb">
      <li><a href="welcome.do">Home</a>
      </li>
      <li>&frasl;</li>
      <li>Assignment</li>
    </ul>
  </div>
  </section>
  </br>
  </br>
  </br>
  <div align="right">
    <div class="container clearfix">
        <div class="conact-form">

			<display:table name="getAssignmentList" pagesize="10" class="basic-table"  uid="getAssignmentList" requestURI="viewAssignment.do">
				<!-- uid is user define -->
				<c:set var="count" value="${count+1}" scope="page"/>
				<display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
				<display:column title="ASSIGNMENT TITLE" >
				 <a href="displyTopicDetails.do?subjectId=${getAssignmentList.addAssignment.subject.subjectId}">${getAssignmentList.addAssignment.subject.subjectName}</a>
				</display:column>
			</display:table> 
        </div>
    </div>
    </div>
</body>
</html>