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
<title>Public Forum</title>
<script type="text/javascript" src="js/script.js"></script>
<!-- <script type="text/javascript" src="js/page-js/forum.js"></script> -->
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" />
<link rel="stylesheet" type="text/css" href="css/jquery.datetimepicker.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.9.1.custom.min.css" />
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css" media="all">
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.demo').click(function() {
			document.getElementById("fId").value = this.id;
			// alert("fdgdgf"+document.getElementById("fId").value);
		});
	});
</script>
<!--below script is for Auto-complete search   -->
<!-- <script type="text/javascript">
$(document).ready(function () {
	$("#search" ).autocomplete({
		source: function( request, response ) {
			var searchName=$("#search")[0];
			var searchValue=searchName.value;
			$.ajax({
				url: "searchQuestion.do?searchValue="+searchValue,  
				dataType: "json",
				data: {
						maxRows: 6,
						startsWith: request.term
					  },
				success: function( data ) {
					 response(data);
				 } 
			});
		}
	  });
	});
</script> -->
</head>
<body>
  <!--section for ask question start  -->
  <section class="inner-banner">
  <div class="container">
    <ul class="breadcrumb">
      <li><a href="askQueries.do"><input type="submit" value="Ask Question" class="btn lg-btn"
          style="width: 178px;" />
      </a>
      </li>
    </ul>
  </div>
  </section>
  <div class="container clearfix">
    <div class="conact-form">
      <form:form method="POST" action="usersQueriesReviews.do" modelAttribute="ForumAnswer" autocomplete="off">
        <h3 style="color: red;">${message}</h3>
        <p>&nbsp;</p>
        <table width="100%" border="0">
          <tr>
            <td><div class="form-control">
                <%-- <form:errors path="firstName"  class="label error-label"></form:errors> --%>
                <label>
                  <p>
                    Search<small class="required"></small>
                  </p> <%-- <c:forEach items="${searchList}" var="searchContent"></c:forEach> --%> <form:textarea
                    path="forumQuestion.forumQuestion" id="search" rows="2" cols="65" style="width: 1000px;"
                    placeholder="search your question" /> </label>
              </div>
            </td>
          </tr>
          <tr>
            <td colspan="2"><input type="submit" value="Search" class="btn lg-btn"
              style="width: 178px; float: right;" />
            </td>
          </tr>
        </table>
        <div class="container innercontent" style="width: 130%; margin: 35px -1%;">
          <h1 class="heading">Recently asked question</h1>
          <div id="accordion">
            <c:forEach items="${questionList}" var="question">
              <h5 class="demo" id="${question.forumQuestionId}">
                <b>${question.forumQuestion}</b>
              </h5>
              <div>
                <p>
                  <b> <!-- to do for answers inside here  --> <c:set var="count" value="0" /> <c:forEach
                      items="${question.forumAnswerList}" var="quesAns">
                      <%-- <a href="forum.do?forumAnswerId=${quesAns.forumAnswerId}" style="margin: 0 97%;">
													<img src="img/edit.png"></a> --%>
                      <c:set var="count" value="${count+1}" />
                      <h2>
                        <b style="font-family: initial;font-size:14px "> <c:out value="Ans ${count} : ${quesAns.forumAnswer}">
                       <%--  <div> ${quesAns.forumAnswer}</div> --%>
                          </c:out> </b>
                      </h2>
                      <br>
                    </c:forEach>
                    <div>
                      <form:textarea path="forumAnswer" rows="5" cols="65" style="width: 938px;" />
                      <br> <br> <input type="submit" value="Submit Answer" class="btn lg-btn"
                        style="width: 178px; float: right; font-size: 15px;" />
                    </div> </b>
                </p>
              </div>
            </c:forEach>
            <form:hidden path="forumQuestion.forumQuestionId" id="fId" value="" />
          </div>
        </div>
        <!-- </table> -->
      </form:form>
    </div>
  </div>
  <script type="text/javascript" src="js/jquery-ui-1.9.1.custom.min.js" charset="utf-8"></script>
  <script type="text/javascript" src="js/page-js/commonDate.js" charset="utf-8"></script>
  <script type="text/javascript" src="js/page-js/stuRegistration.js"></script>
</body>
</html>