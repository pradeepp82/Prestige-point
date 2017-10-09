<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>Add Courses</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css" />
<script>
function validateForm()
{
      var x=document.forms["testForm"]["date"].value;
      if (x==null || x=="")
      {
            alert("Please select the date!");   
           
            return false;
      }
}
</script> 
<script type="text/javascript">
	$(document).ready(function() {
		var regId = "${registrationId}";
		document.getElementById("regId").value = regId;
	});
	
	
</script>
</head>


<body>
  <div class="container clearfix">
    <div class="conact-form">
      <p>&nbsp;</p>
    
      <h2>Fee Details</h2>
      <c:forEach items="${registrationList}" var="reg">
        <b>Total Fee:</b> &nbsp;${reg.totalFee}<br />
        <b>Submitted Fee:</b> &nbsp;${reg.submittedFee}<br />
        
        <p>&nbsp;</p>
      </c:forEach>
      <c:set var="count" value="0" scope="page" />
      <display:table name="feesDetails" pagesize="8" class="basic-table" uid="cat" requestURI="emi.do">
        <c:set var="count" value="${count+1}" scope="page" />
        <display:column title="S.NO">
     ${count}
    </display:column>
        <display:column property="amount" title="Amount" />
       <fmt:parseDate value="${cat.date}" var="date" pattern="yyyy-MM-dd" />
          <fmt:formatDate type="date" value="${date}" var="startDate" pattern="dd-MM-yyyy" />
        <display:column title="DATE">${startDate}</display:column>
         <c:if test="${sessionScope.login.adminType!=4}">
           <display:column title="Edit">
         <a href="editEmi.do?emiId=${cat.emiId}">Edit</a>
        </display:column>
        <display:column title="GenrateReceipt">
         <a href="genrateReceipt.do?emiId=${cat.emiId}">GenrateReceipt</a>
        </display:column>
        <display:column title="Delete">
          <a href="deleteEmiDetails.do?emiId=${cat.emiId}"
            onclick="return confirm('Please confirm if you want to delete this Emi Details!');">Delete</a>
        </display:column>
        </c:if>
      </display:table>
       <h3 style="color: red;">${message}</h3>
      <form:form name="testForm" method="POST" action="saveEmi.do" modelAttribute="Emi" autocomplete="off" onsubmit="return validateForm()">
      <form:form  method="POST" action="getStudentDetails.do" modelAttribute="Emi" autocomplete="off" >
        <table width="100%" border="0" ><form:hidden path="emiId" />
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="name"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                  <h3 style="color: #873d80;">Emi Chart</h3>
                  <small class="required"></small>
                </p> </label> <label>
                  <p>
                    Amount<small class="required"></small>
                  </p> <form:input path="amount" class="inputControl1" placeholder="Amount" required="autofocus"
                    maxlength="6" onkeypress="return onlyNos(event,this);" /> <%-- <form:hidden path="registration.registrationId" id="regId" /> --%> 
                    <form:hidden path="registration.registrationId" value="${registrationId}"/></label>
              </div>
              
            </td>
          </tr>
          <tr>
            <td><div class="form-control">
                 <form:errors path="date"  class="label error-label"></form:errors> 
                <label>
                  <p>
                    Date<small class="required"></small>
                    <fmt:parseDate value="${cat.date}" var="date" pattern="yyyy-MM-dd" />
         			 <fmt:formatDate type="date" value="${date}" var="startDate" pattern="dd-MM-yyyy" />
                  </p> <form:input path="date" id="datepick" class="inputControl1" placeholder="Date"
                    maxlength="20" readonly="true" /> </label>
              
              </div>
            </td>
          </tr>
        <tr><td>
           <input type="submit" value="Submit" class="btn lg-btn" />&nbsp;&nbsp;
          
             <!--  <input type="cancel" value="Cancel" class="btn lg-btn" onclick="Emifun();" ></td> -->
           
        </table>
      </form:form>
      </form:form>
    </div>
  </div>
  <script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="js/page-js/commonDate.js" charset="utf-8"></script>
</body>
</html>