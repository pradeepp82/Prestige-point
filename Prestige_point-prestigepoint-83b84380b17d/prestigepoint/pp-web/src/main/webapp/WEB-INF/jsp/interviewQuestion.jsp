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
<title>jQuery UI Accordion - Default functionality</title>
<link rel="stylesheet" type="text/css" href="css/jquery-ui.css"
	media="all">
<script src="js/jquery-ui.js"></script>
<script>
	$(function() {
		$("#accordion").accordion();
	});
</script>
</head>
<body>
	<div class="container innercontent">
		<h1 class="heading"><c:if test="${not empty questionAndAnswerList}">${questionAndAnswerList.get(0).subject.subjectName} question and answer</c:if></h1>
		<div id="accordion">
			 <c:set var="count" value="0" scope="page" />
			<c:forEach items="${questionAndAnswerList}" var="queAns">
			 <c:set var="count" value="${count+1}" scope="page" />
			<c:if test="${queAns.answer1!=null}">
   				<h5>
					<b>Q.${count} ${queAns.question}</b>
				</h5>
				<div>
					<p>
						<b>Ans: </b> <table class="basic-table1" >
						<c:set var="arrayofmsg" value="${fn:split(queAns.answer,'#')}"/>
						<c:set var="arrayofmsg1" value="${fn:split(queAns.answer1,'#')}"/>
						<c:forEach var="i" begin="0" end="${fn:length(arrayofmsg)}">
 						<tr><td>
 						${arrayofmsg[i]}
 						</td>
 						<td>
 						${arrayofmsg1[i]}
 						</td>
 						</tr>
						</c:forEach>	
						</table>
					</p>
				</div>	
			</c:if>
			<c:if test="${queAns.answer1==null}">
				<h5>
					<b>Q.${count} ${queAns.question}</b>
				</h5>
				<div>
					<p>
						<b>Ans: </b> ${queAns.answer}
					</p>
				</div>	
			</c:if>
			</c:forEach>
		</div>
	</div>
</body>
</html>