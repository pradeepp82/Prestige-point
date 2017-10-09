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
<script type="text/javascript" src="js/page-js/registration.js"></script>
<script type="text/javascript" src="js/script.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
<script type="text/javascript" src="js/page-js/commonDate.js" charset="utf-8"></script>
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css" />
<script type="text/javascript">
function callAllPlacedStudent() {
	  if ($('#allPlacedStudent').prop('checked')) {
	    document.getElementById("datepick").disabled = true;
	    document.getElementById("picker").disabled = true;
	    document.getElementById("datepick").value = " ";
	    document.getElementById("picker").value = " ";
	  }
	  else
	    {
	    document.getElementById("datepick").disabled = false;
	    document.getElementById("picker").disabled = false;
	    
	    }
	}
	function uncheckEvent()
	{
	  $('#allPlacedStudent').attr('checked', false);
	  
	 
	}
	

</script>
</head>
<div class="container clearfix">
		<div class="conact-form">
  <form:form method="POST" action="viewPlacedStudentDetails.do" modelAttribute="AddPlacedStudent" autocomplete="off">
    <table width="30%" border="0">
      <tr>
        <td>
            <tr>

              <td><div class="form-control">
                  <label> ALL&nbsp;&nbsp;&nbsp;&nbsp;<form:checkbox path="searchType" value="all" id="allPlacedStudent"
                      onclick = "callAllPlacedStudent()" /> </label>
                </div></td>
            </tr>
            <tr>

              <td><div class="form-control">
                  <label>
                    <p>From Date</p> <form:input path="fromDate"  id="datepick" class="inputControl" onclick="uncheckEvent()"
                      placeholder="From Date" readonly="true" maxlength="50" /> </label>
                </div></td>
            </tr>
            <tr>
              <td><div class="form-control">
                  <label>
                    <p>To Date</p> <form:input path="toDate"  id="picker" class="inputControl" placeholder="TO Date"
                    readonly="true" maxlength="50" /> </label>
                </div>
              </td>
            </tr>
            <tr>
            <tr>
              <td><input type="submit" value="search" /></td>
            </tr>
          
     </table>
    <c:set var="count" value="0" scope="page" />

    <display:table name="placedStudentList" pagesize="20" class="basic-table" uid="studentList">
      <c:set var="count" value="${count+1}" scope="page" />
      <display:column title="S.NO" style="width:1%;">
     ${count}
    </display:column>
      <display:column property="registration.firstName" title="First Nname" />
      <display:column property="registration.lastName" title="Last Name" />
      <display:column property="companyName" title="Company Name" />
      <display:column property="studentPackage" title="Package" />
      <display:column property="joiningDate" title="Joining date" />
      <display:column title="Release aartek">
      <fmt:parseDate var="parsedDate" value="${studentList.releaseDateFromAartek}" pattern="MM-dd-yyyy"/>
      <fmt:formatDate var="FormattedDateChange" value="${parsedDate}" pattern="dd-MM-yyyy"/>
      <c:out value="${FormattedDateChange}"></c:out>
      </display:column>
      <display:column property="jobLocation" title="Job location" />
      <display:column property="experience" title="Experience" />
      <display:column property="year" title="Year" />
      <c:if test="${sessionScope.login.adminType!=4}">
      <display:column title="Edit">
        <a href="editPlacedStudent.do?studentId=${studentList.studentId}">
        Edit</a>
      </display:column>
      <display:column title="Delete">
        <a href="deletePlacedStudent.do?studentId=${studentList.studentId}"
          onclick="return confirm('Please confirm if you want to delete this batch!');">Delete</a>
      </display:column>
      </c:if>
    </display:table>

    </form:form></div></div>
</body>
</html>