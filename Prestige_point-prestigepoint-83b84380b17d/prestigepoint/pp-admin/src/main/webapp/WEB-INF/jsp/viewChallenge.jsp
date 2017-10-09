<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Challenge List</title>
<script type="text/javascript">
$(document).ready(function() {
	if ("${AddChallenge.technology}" == '') {
		$("#tech").hide();

	} else {
		$("#tech").show();
	}
});
</script>
<link rel="stylesheet" type="text/css" href="css/jquery.challenge.css" />
</head>
<body>
    <h1 align="center">

        <p>
            <b>Title:-${AddChallenge.title}</b>
        </p>
    </h1>

    <table style="width: 60%; margin: 0px auto;" align="center">

        <tr>
            <td><b>Price:-</b> ${AddChallenge.price}Rs <span style="padding-left: 450px"><b>Duration:-</b>
                    ${AddChallenge.duration}</span></td>
        </tr>
        <tr>
            <td><div id="tech">
                    <b>Technology:-</b> ${AddChallenge.technology}
                </div></td>
        </tr>

        <tr>
            <td><b>Description:-</b>${AddChallenge.discription}</td>
        </tr>
        <tr>
            <td><b>Terms And Condition:-</b> <c:set var="arrayofmsg"
                    value="${fn:split(AddChallenge.challengeCondition,'#')}" /> <c:forEach var="i" begin="0"
                    end="${fn:length(arrayofmsg)}">
                    <tr>
                        <td>${arrayofmsg[i]}</td>
                    </tr></td>
            </c:forEach>
        </tr>
    </table>
</body>
</html>


